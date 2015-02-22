/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bsb.riskoperons.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pl.com.bsb.riskoperons.report.AbstractReportDataCallback;
import pl.com.bsb.riskoperons.report.ReportTemplate;
import pl.com.bsb.riskoperons.utils.PropertyFileUtils;

/**
 *
 * @author Grzegorz
 */
public enum ReportType {

    RISK_OPERONS_INFO("report", Arrays.asList(ReportFormat.PDF, ReportFormat.CSV));
    
    private String templateName;
    private List<ReportFormat> supportedFormats;

    private ReportType(final String templateName, final List<ReportFormat> supportedFormats) {
        this.templateName = templateName;
        this.supportedFormats = supportedFormats;
    }

    public ReportTemplate getReportTemplate(boolean active, AbstractReportDataCallback callback) {
        ReportTemplate reportTemplate = new ReportTemplate(PropertyFileUtils.format(this.getKey()), this.getTemplateName(), this.getSupportedFormats(), active, callback);
        return reportTemplate;
    }

//    public ReportTemplate getReportTemplate(Long id, Date createDate) {
//        ReportTemplate reportTemplate = new ReportTemplate(id, createDate, PropertyFileUtils.format(this.getKey()), this.getTemplateName(), this.getSupportedFormats());
//        return reportTemplate;
//    }

    public String getTemplateName() {
        return templateName;
    }

    public List<ReportFormat> getSupportedFormats() {
        return supportedFormats;
    }

    public String getKey() {
        return this.getClass().getSimpleName() + "." + this.name();
    }

    public static List<ReportType> getValues() {
        return new ArrayList<>(Arrays.asList(ReportType.values()));
    }

    public static List<ReportType> adhocReports() {
        return new ArrayList<>(Arrays.asList(RISK_OPERONS_INFO));
    }

    /**
     * Lista raportów dostępnych na widoku w menu Raporty > Raporty z
     * przetwarzania.
     *
     * @return lista kluczy raportów wygenerowanych
     */
    public static List<ReportType> generatedReports() {
        return null;
               
               
             
    }
}
