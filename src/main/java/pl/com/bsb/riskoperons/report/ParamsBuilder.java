/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bsb.riskoperons.report;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Grzegorz
 */
public class ParamsBuilder {

    Map<String, Object> parameters;

    public ParamsBuilder() {
        parameters = new HashMap<>();
    }

    public ParamsBuilder put(String key, Object value) {
        parameters.put(key, value);
        return this;
    }

    public Map<String, Object> build() {
        return parameters;
    }
}
