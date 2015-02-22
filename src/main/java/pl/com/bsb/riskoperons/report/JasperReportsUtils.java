/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bsb.riskoperons.report;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRTextExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;

/**
 *
 * @author Grzegorz
 */
public class JasperReportsUtils {

    private static JasperPrint generateRaport(InputStream jasperTemplate, Map<String, Object> parameters, Collection reportData) throws JRException {
        JRDataSource dataSource;
        if (parameters == null) {
            parameters = new HashMap<>();
        }
        if (reportData != null && !reportData.isEmpty()) {
            dataSource = new JRBeanCollectionDataSource(reportData);
        } else {
            dataSource = new JREmptyDataSource();
        }      
        parameters.put(JRParameter.REPORT_LOCALE, new Locale("pl", "PL"));
        return JasperFillManager.fillReport(jasperTemplate, parameters, dataSource);
    }

    public static void toPdfStream(InputStream jasperTemplate, OutputStream outputStream, Map<String, Object> parameters, Collection reportData) throws JRException {
        JasperPrint jasperPrint = generateRaport(jasperTemplate, parameters, reportData);
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
    }

    public static void toXmlStream(InputStream jasperTemplate, OutputStream outputStream, Map<String, Object> parameters, Collection reportData) throws JRException {
        JasperPrint jasperPrint = generateRaport(jasperTemplate, parameters, reportData);
        JasperExportManager.exportReportToXmlStream(jasperPrint, outputStream);
    }

    public static void toCsvStream(InputStream jasperTemplate, OutputStream outputStream, Map<String, Object> parameters, Collection reportData, String encoding, String delimeter) throws JRException {
        JasperPrint jasperPrint = generateRaport(jasperTemplate, parameters, reportData);
        JRCsvExporter csvExporter = new JRCsvExporter();
        csvExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        csvExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
        csvExporter.setParameter(JRCsvExporterParameter.FIELD_DELIMITER, delimeter);
        csvExporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, encoding);
        csvExporter.exportReport();
    }

    public static void toXlsStream(InputStream jasperTemplate, OutputStream outputStream, Map<String, Object> parameters, Collection reportData) throws JRException {
        JasperPrint jasperPrint = generateRaport(jasperTemplate, parameters, reportData);
        JRXlsExporter xlsExporter = new JRXlsExporter();
        xlsExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        xlsExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
        xlsExporter.exportReport();
    }
    
    public static void toTxtStream(InputStream jasperTemplate, OutputStream outputStream, Map<String, Object> parameters, Collection reportData, String encoding) throws JRException {
        JasperPrint jasperPrint = generateRaport(jasperTemplate, parameters, reportData);
        JRTextExporter txtExporter = new JRTextExporter();
        txtExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        txtExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
        txtExporter.setParameter(JRTextExporterParameter.PAGE_WIDTH, 80);
        txtExporter.setParameter(JRTextExporterParameter.PAGE_HEIGHT, 60);
        txtExporter.setParameter(JRTextExporterParameter.BETWEEN_PAGES_TEXT, "");
        txtExporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, encoding);
        txtExporter.exportReport();
    }    
}
