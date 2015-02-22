/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bsb.riskoperons.enums;

/**
 *
 * @author Grzegorz
 */
public enum ReportFormat {

    PDF(".pdf"), CSV(".csv"), XLS(".xls"), XML(".xml"), TXT(".txt");
    private final String extension;

    private ReportFormat(final String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }
}
