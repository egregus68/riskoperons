/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bsb.riskoperons.report.wrapper;

import pl.com.bsb.riskoperons.enums.ReportType;
import java.io.Serializable;
import pl.com.bsb.riskoperons.report.ReportTemplate;
import pl.com.bsb.riskoperons.report.SupportedReportType;

/**
 *
 * @author Grzegorz
 */
public class ReportListWrapper implements Serializable {

    private String reportName;
    private SupportedReportType reportType;
    private ReportTemplate reportTemplate;
    private ReportType elixirReportType;

    public ReportListWrapper(final SupportedReportType reportType, final ReportTemplate reportTemplate, final ReportType elixirReportType) {
        this.reportType = reportType;
        this.reportTemplate = reportTemplate;
        this.elixirReportType = elixirReportType;
        this.reportName = reportTemplate.getReportName();
    }
    
    public ReportListWrapper(final String reportName) {
        this.reportName = reportName;
    }
    
    public ReportListWrapper(final String reportName, final SupportedReportType reportType, final ReportTemplate reportTemplate) {
        this.reportName = reportName;
        this.reportType = reportType;
        this.reportTemplate = reportTemplate;
    }

    public String getReportName() {
        return reportName;
    }
    
    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public SupportedReportType getReportType() {
        return reportType;
    }

    public void setReportType(final SupportedReportType reportType) {
        this.reportType = reportType;
    }

    public ReportTemplate getReportTemplate() {
        return reportTemplate;
    }

    public void setReportTemplate(final ReportTemplate reportTemplate) {
        this.reportTemplate = reportTemplate;
    }

    public ReportType getElixirReportType() {
        return elixirReportType;
}

    public void setElixirReportType(ReportType elixirReportType) {
        this.elixirReportType = elixirReportType;
    }
}
