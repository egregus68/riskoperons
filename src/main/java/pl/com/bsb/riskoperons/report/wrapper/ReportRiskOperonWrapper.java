/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bsb.riskoperons.report.wrapper;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Grzegorz
 */
public class ReportRiskOperonWrapper implements Serializable {

    private String clientName;
    private String clientInformation;
    
    private String environmentName;
    private String environmentInfo;

    private String appUrlPath;
    private String appHost;
    private String appOperatingSystem;
    private String appAS;
    private String appUrlConsole;
    private String appPath;
    private String appSvnBranch;   
    private String appInformation;

    private String dbHost;
    private String dbOperatingSystem;
    private String dbDatabase;
    private String dbLink;
    private String dbInformation;

    private String rmiHost;
    private String rmiOperatingSystem;
    private String rmiPort;
    private String rmiReportsPath;
    private String rmiServerPath;
    private String rmiInformation;

    public ReportRiskOperonWrapper() {
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientInformation() {
        return clientInformation;
    }

    public void setClientInformation(String clientInformation) {
        this.clientInformation = clientInformation;
    }

    public String getEnvironmentName() {
        return environmentName;
    }

    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName;
    }

    public String getEnvironmentInfo() {
        return environmentInfo;
    }

    public void setEnvironmentInfo(String environmentInfo) {
        this.environmentInfo = environmentInfo;
    }
    
    public String getAppUrlPath() {
        return appUrlPath;
    }

    public void setAppUrlPath(String appUrlPath) {
        this.appUrlPath = appUrlPath;
    }

    public String getAppHost() {
        return appHost;
    }

    public void setAppHost(String appHost) {
        this.appHost = appHost;
    }

    public String getAppOperatingSystem() {
        return appOperatingSystem;
    }

    public void setAppOperatingSystem(String appOperatingSystem) {
        this.appOperatingSystem = appOperatingSystem;
    }

    public String getAppAS() {
        return appAS;
    }

    public void setAppAS(String appAS) {
        this.appAS = appAS;
    }

    public String getAppUrlConsole() {
        return appUrlConsole;
    }

    public void setAppUrlConsole(String appUrlConsole) {
        this.appUrlConsole = appUrlConsole;
    }

    public String getAppPath() {
        return appPath;
    }

    public void setAppPath(String appPath) {
        this.appPath = appPath;
    }

    public String getAppSvnBranch() {
        return appSvnBranch;
    }

    public void setAppSvnBranch(String appSvnBranch) {
        this.appSvnBranch = appSvnBranch;
    }

    public String getAppInformation() {
        return appInformation;
    }

    public void setAppInformation(String appInformation) {
        this.appInformation = appInformation;
    }

    public String getDbHost() {
        return dbHost;
    }

    public void setDbHost(String dbHost) {
        this.dbHost = dbHost;
    }

    public String getDbOperatingSystem() {
        return dbOperatingSystem;
    }

    public void setDbOperatingSystem(String dbOperatingSystem) {
        this.dbOperatingSystem = dbOperatingSystem;
    }

    public String getDbDatabase() {
        return dbDatabase;
    }

    public void setDbDatabase(String dbDatabase) {
        this.dbDatabase = dbDatabase;
    }

    public String getDbLink() {
        return dbLink;
    }

    public void setDbLink(String dbLink) {
        this.dbLink = dbLink;
    }

    public String getDbInformation() {
        return dbInformation;
    }

    public void setDbInformation(String dbInformation) {
        this.dbInformation = dbInformation;
    }

    public String getRmiHost() {
        return rmiHost;
    }

    public void setRmiHost(String rmiHost) {
        this.rmiHost = rmiHost;
    }

    public String getRmiOperatingSystem() {
        return rmiOperatingSystem;
    }

    public void setRmiOperatingSystem(String rmiOperatingSystem) {
        this.rmiOperatingSystem = rmiOperatingSystem;
    }

    public String getRmiPort() {
        return rmiPort;
    }

    public void setRmiPort(String rmiPort) {
        this.rmiPort = rmiPort;
    }

    public String getRmiReportsPath() {
        return rmiReportsPath;
    }

    public void setRmiReportsPath(String rmiReportsPath) {
        this.rmiReportsPath = rmiReportsPath;
    }

    public String getRmiServerPath() {
        return rmiServerPath;
    }

    public void setRmiServerPath(String rmiServerPath) {
        this.rmiServerPath = rmiServerPath;
    }

    public String getRmiInformation() {
        return rmiInformation;
    }

    public void setRmiInformation(String rmiInformation) {
        this.rmiInformation = rmiInformation;
    }
    
}
