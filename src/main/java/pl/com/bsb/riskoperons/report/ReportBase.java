/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bsb.riskoperons.report;

import pl.com.bsb.riskoperons.utils.Timer;
import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Grzegorz
 */
public class ReportBase {

    private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ReportBase.class);
    private static final long serialVersionUID = 5360536275424089970L;
    private ReportTemplate reportTemplate;
    private SupportedReportType reportType;

    public void executeReport(SupportedReportType reportType, ReportTemplate reportTemplate) {
        this.reportType = reportType;
        this.reportTemplate = reportTemplate;
        executeReport();
    }

    public void executeReport() {
        Timer timer = new Timer();
        timer.start();
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        try (ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream()) {
            ReportService reportService = new JasperReportService();
            LOGGER.info("Wygenerowano raport o typie: " + reportType.getReportFormat() + " i szablonie: " + reportTemplate.getTemplateName());
            reportService.generateReport(reportType.getReportFormat(), reportTemplate.getTemplateName(),
                    reportTemplate.getDataCallback().getParameters(), reportTemplate.getDataCallback().getReportData(), servletOutputStream, httpServletResponse);
            servletOutputStream.flush();
            FacesContext.getCurrentInstance().responseComplete();
            timer.stop();
            LOGGER.info("executeReport(): duration={} ms", timer.getDuration(Timer.Precision.MILLISECOND));

        } catch (IOException ex) {
            throw new ReportServiceException("Execute report error", ex);
        }
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

}
