/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bsb.riskoperons.utils;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Grzegorz
 */
public class PropertyFileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertyFileUtils.class);
    private static final String DEFAULT_MSG_BUNDLE = "report-messages";

    public static String format(final String key, final String... params) {
        return format(key, new Locale("PL"), (Object) params);
    }

    public static String format(final String key, final Locale locale, final Object... params) {
        String result;
        final ResourceBundle detailsBundle = getDetailsBundle(locale);
        if (detailsBundle.containsKey(key)) {
            result = detailsBundle.getString(key);
            if (params != null && params.length > 0 && params[0] != null) {
                result = MessageFormat.format(result, params);
            }
        } else {
            result = "###" + key + "###";
        }
        return result;
    }

    private static ResourceBundle getDetailsBundle(final Locale locale) {
        ResourceBundle result;
        try {
            result = ResourceBundle.getBundle(DEFAULT_MSG_BUNDLE, locale);
        } catch (Exception ex) {
            LOGGER.warn("getDetailsBundle: using default locale PL");
            result = ResourceBundle.getBundle(DEFAULT_MSG_BUNDLE, new Locale("PL"));
        }
        return result;
    }
}
