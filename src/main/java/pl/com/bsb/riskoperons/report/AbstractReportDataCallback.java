/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bsb.riskoperons.report;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author Grzegorz
 */
public abstract class AbstractReportDataCallback implements Serializable {

    private static final long serialVersionUID = -7470550090426769362L;

    public AbstractReportDataCallback() {
    }

    public abstract Map<String, Object> getParameters();

    public abstract Collection<? extends Object> getReportData();
}

