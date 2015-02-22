/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bsb.riskoperons.report;

import pl.com.bsb.riskoperons.enums.ReportFormat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Grzegorz
 */
public class ReportTemplate implements Serializable {

    private Long reportId;
    private Date createDate;
    private String reportName;
    private String reportFileName;
    private String templateName;
    private List<SupportedReportType> supportedFormats = new ArrayList<>();
    AbstractReportDataCallback dataCallback;
    private boolean active = true;

    public ReportTemplate(Long reportId, Date createDate, String reportName, String reportFileName, List<SupportedReportType> supportedFormats) {
        this.reportId = reportId;
        this.createDate = createDate;
        this.reportName = reportName;
        this.reportFileName = reportFileName;
        this.supportedFormats = supportedFormats;
    }

    public ReportTemplate(String reportName, String templateName, List<SupportedReportType> supportedFormats) {
        this.reportName = reportName;
        this.templateName = templateName;
        this.supportedFormats = supportedFormats;
    }

    public ReportTemplate(String reportName, String templateName, boolean active, List<SupportedReportType> supportedFormats, AbstractReportDataCallback dataCallback) {
        this.reportName = reportName;
        this.templateName = templateName;
        this.active = active;
        this.supportedFormats = supportedFormats;
        this.dataCallback = dataCallback;
    }

    public ReportTemplate(String name, String templateName, List<ReportFormat> supportedFormats, boolean active, AbstractReportDataCallback dataCallback) {
        this.reportName = name;
        this.templateName = templateName;
        this.supportedFormats = convert(supportedFormats);
        this.active = active;
        this.dataCallback = dataCallback;
    }

    public String getReportName() {
        return reportName;
    }

    public String getReportFileName() {
        return reportFileName;
    }

    public String getTemplateName() {
        return templateName;
    }

    public List<SupportedReportType> getSupportedFormats() {
        return supportedFormats;
    }

    public Long getReportId() {
        return reportId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public boolean isActive() {
        return active;
    }

    public AbstractReportDataCallback getDataCallback() {
        return dataCallback;
    }

    public static List<SupportedReportType> convert(List<ReportFormat> supportedFormats) {
        List<SupportedReportType> reportFormats = new ArrayList<>();
        if (supportedFormats != null) {
            for (ReportFormat supportedFormat : supportedFormats) {
                SupportedReportType rf = new SupportedReportType(supportedFormat);
                reportFormats.add(rf);
            }
        }
        return reportFormats;
    }
}
