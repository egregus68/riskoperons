/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bsb.riskoperons.report;

import pl.com.bsb.riskoperons.enums.ReportFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.nio.*;

/**
 *
 * @author Grzegorz
 */
public class JasperReportService implements ReportService {

    private static final String DEFAULT_REPORTS_LOCATION = "/reports/";
    private static final String CSV_FIELD_DELIMITER = ";";
    private static final String CSV_CHARACTER_ENCODING = "CP1250";
    private static final Logger LOGGER = LoggerFactory.getLogger(JasperReportService.class);
    public static final EnumMap<ReportFormat, ReportGenerator> reportGenerators = new EnumMap<ReportFormat, ReportGenerator>(ReportFormat.class);

    static {
        reportGenerators.put(ReportFormat.PDF, new PDFReportGenerator());
        reportGenerators.put(ReportFormat.XML, new XMLReportGenerator());
        reportGenerators.put(ReportFormat.XLS, new XLSReportGenerator());
        reportGenerators.put(ReportFormat.CSV, new CSVReportGenerator());
        reportGenerators.put(ReportFormat.TXT, new TXTReportGenerator());
    }

    @Override
    public void generateReport(ReportFormat reportFormat, String templateName, Map<String, Object> parameters, Collection reportData, OutputStream outputStream, HttpServletResponse httpServletResponse) {
        //templateName = new StringBuilder().append(templateName).append("_").append(reportFormat.name().toLowerCase()).toString();
        if (parameters == null) {
            parameters = new HashMap<>();
        }
        parameters.put("LOGO_INPUT_STREAM", JasperReportService.class.getClassLoader().getResourceAsStream("/logo_bsb.png"));
        ReportGenerator generator = reportGenerators.get(reportFormat);
        if (generator != null) {
            if (httpServletResponse != null) {
                generator.addHeaders(httpServletResponse, templateName, reportFormat);
            }
            try (InputStream templateInputStream = getJasperTemplateStream(reportFormat, templateName)) {
                generator.generateReport(templateInputStream, outputStream, parameters, reportData);

            } catch (IOException ex) {
                throw new ReportServiceException("Template read error", ex);
            }
        } else {
            throw new IllegalArgumentException("Unsupported report type: " + reportFormat);
        }
    }

    @Override
    public void generateReport(ReportFormat reportFormat, String reportTemplateName, Map<String, Object> parameters, Collection reportData, OutputStream outputStream) {
        generateReport(reportFormat, reportTemplateName, parameters, reportData, outputStream, null);
    }

    private InputStream getJasperTemplateStream(ReportFormat reportFormat, String templateName) {
        InputStream result;
        Class<? extends ReportService> clazz = getClass();
        final String reportPath = DEFAULT_REPORTS_LOCATION + templateName + "_" + reportFormat.name().toLowerCase() + ".jasper";
        result = clazz.getClassLoader().getResourceAsStream(reportPath);
        if (result == null) {
            result = clazz.getResourceAsStream(reportPath);
        }
        if (result == null) {
            result = clazz.getResourceAsStream(templateName);
        }
        if (result == null) {
            throw new RuntimeException("Can not resolve report template name:" + templateName);
        }
        return result;
    }

    public static abstract class ReportGenerator {

        public abstract void generateReport(InputStream template, OutputStream outputStream, Map<String, Object> parameters, Collection reportData);

        public void addHeaders(HttpServletResponse httpServletResponse, String templateName, ReportFormat reportFormat) {
            if (httpServletResponse != null) {
                try {
                    httpServletResponse.setHeader("Content-Disposition", "attachment; filename*=UTF-8''" + URLEncoder.encode(getFileName(templateName, reportFormat), "UTF-8").replace("+", "%20"));
                } catch (UnsupportedEncodingException ex) {
                    LOGGER.error("UnsupportedEncodingException: " + ex);
                }
            }
        }

        protected void throwException(JRException ex) {
            LOGGER.info(ex.getMessage(), ex);
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private String getFileName(String templateName, ReportFormat reportFormat) {
            return templateName + reportFormat.getExtension();
        }
    }

    private static class PDFReportGenerator extends ReportGenerator {

        @Override
        public void addHeaders(HttpServletResponse httpServletResponse, String templateName, ReportFormat reportFormat) {
            if (httpServletResponse != null) {
                super.addHeaders(httpServletResponse, templateName, reportFormat);
                httpServletResponse.setContentType("application/pdf");
            }
        }

        @Override
        public void generateReport(InputStream template, OutputStream outputStream, Map<String, Object> parameters, Collection reportData) {
            try {
                JasperReportsUtils.toPdfStream(template, outputStream, parameters, reportData);
            } catch (JRException ex) {
                throwException(ex);
            }
        }
    }

    private static class XMLReportGenerator extends ReportGenerator {

        @Override
        public void addHeaders(HttpServletResponse httpServletResponse, String templateName, ReportFormat reportFormat) {
            if (httpServletResponse != null) {
                super.addHeaders(httpServletResponse, templateName, reportFormat);
                httpServletResponse.setContentType("application/xml");
            }
        }

        @Override
        public void generateReport(InputStream template, OutputStream outputStream, Map<String, Object> parameters, Collection reportData) {
            try {
                JasperReportsUtils.toXmlStream(template, outputStream, parameters, reportData);
            } catch (JRException ex) {
                throwException(ex);
            }
        }
    }

    private static class CSVReportGenerator extends ReportGenerator {

        @Override
        public void addHeaders(HttpServletResponse httpServletResponse, String templateName, ReportFormat reportFormat) {
            if (httpServletResponse != null) {
                super.addHeaders(httpServletResponse, templateName, reportFormat);
                httpServletResponse.setContentType("application/csv");
            }
        }

        @Override
        public void generateReport(InputStream template, OutputStream outputStream, Map<String, Object> parameters, Collection reportData) {
            try {
                JasperReportsUtils.toCsvStream(template, outputStream, parameters, reportData, CSV_CHARACTER_ENCODING, CSV_FIELD_DELIMITER);
            } catch (JRException ex) {
                throwException(ex);
            }
        }
    }

    private static class XLSReportGenerator extends ReportGenerator {

        @Override
        public void addHeaders(HttpServletResponse httpServletResponse, String templateName, ReportFormat reportFormat) {
            if (httpServletResponse != null) {
                super.addHeaders(httpServletResponse, templateName, reportFormat);
                httpServletResponse.setContentType("application/vnd.ms-excel");
            }
        }

        @Override
        public void generateReport(InputStream template, OutputStream outputStream, Map<String, Object> parameters, Collection reportData) {
            try {
                JasperReportsUtils.toXlsStream(template, outputStream, parameters, reportData);
            } catch (JRException ex) {
                throwException(ex);
            }
        }
    }
    

    private static class TXTReportGenerator extends ReportGenerator {

        @Override
        public void addHeaders(HttpServletResponse httpServletResponse, String templateName, ReportFormat reportFormat) {
            if (httpServletResponse != null) {
                super.addHeaders(httpServletResponse, templateName, reportFormat);
                httpServletResponse.setContentType("text/plain");
            }
        }

        @Override
        public void generateReport(InputStream template, OutputStream outputStream, Map<String, Object> parameters, Collection reportData) {
            try {
                JasperReportsUtils.toTxtStream(template, outputStream, parameters, reportData, CSV_CHARACTER_ENCODING);
            } catch (JRException ex) {
                throwException(ex);
            }
        }
    }    
}
