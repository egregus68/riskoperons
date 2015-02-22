/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bsb.riskoperons.report;

import pl.com.bsb.riskoperons.enums.ReportFormat;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Grzegorz
 */
public interface ReportService {

    void generateReport(ReportFormat reportFormat, String reportTemplateName, Map<String, Object> parameters, Collection reportData, OutputStream outputStream);

    void generateReport(ReportFormat reportFormat, String reportTemplateName, Map<String, Object> parameters, Collection reportData, OutputStream outputStream, HttpServletResponse httpServletResponse);
}
