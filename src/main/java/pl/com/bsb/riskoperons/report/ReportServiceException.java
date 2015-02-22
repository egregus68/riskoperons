/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bsb.riskoperons.report;

import java.io.IOException;

/**
 *
 * @author Grzegorz
 */
public class ReportServiceException extends RuntimeException {

    public ReportServiceException(String message, IOException ex) {
        super(message, ex);
    }
}
