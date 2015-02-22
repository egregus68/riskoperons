/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bsb.riskoperons.report;

import pl.com.bsb.riskoperons.enums.ReportFormat;
import java.io.Serializable;

/**
 *
 * @author Grzegorz
 */
public class SupportedReportType implements Serializable {

    private static final long serialVersionUID = -2752262084494532822L;
    private ReportFormat reportFormat;

    public SupportedReportType(final ReportFormat reportFormat) {
        this.reportFormat = reportFormat;
    }

    public ReportFormat getReportFormat() {
        return reportFormat;
    }

    public void setReportFormat(final ReportFormat reportFormat) {
        this.reportFormat = reportFormat;
    }
}