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

    private String appUrlPath;
    private String appHost;
    private String appOperatingSystem;
    private String appAS;
    private String appUrlConsole;
    private String appPath;
    private String appSvnBranch;   

    private String dbHost;
    private String dbOperatingSystem;
    private String dbDatabase;
    private String dbLink;

    private String rmiHost;
    private String rmiOperatingSystem;
    private String rmiPort;
    private String rmiReportsPath;
    private String rmiServerPath;

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
    
    

    public static class PackagesList {

        private Long bifId;
        private String transactionGroup;
        private String packagetransactionType;
        private BigDecimal transactionsAmount;
        private Integer transactionsCount;

        public PackagesList(String transactionGroup, String packagetransactionType, BigDecimal transacitonsAmount, Integer transactionsCount) {

            this.transactionsAmount = transacitonsAmount;
            this.transactionsCount = transactionsCount;
            this.transactionGroup = transactionGroup;
            this.packagetransactionType = packagetransactionType;
        }

        public Long getBifId() {
            return bifId;
        }

        public void setBifId(Long bifId) {
            this.bifId = bifId;
        }

        public String getTransactionGroup() {
            return transactionGroup;
        }

        public void setTransactionGroup(String transactionGroup) {
            this.transactionGroup = transactionGroup;
        }

        public String getPackagetransactionType() {
            return packagetransactionType;
        }

        public void setPackagetransactionType(String packagetransactionType) {
            this.packagetransactionType = packagetransactionType;
        }

        public BigDecimal getTransactionsAmount() {
            return transactionsAmount;
        }

        public void setTransactionsAmount(BigDecimal transacitonsAmount) {
            this.transactionsAmount = transacitonsAmount;
        }

        public Integer getTransactionsCount() {
            return transactionsCount;
        }

        public void setTransactionsCount(Integer transactionsCount) {
            this.transactionsCount = transactionsCount;
        }

    }

    public static class BifList {

        private Date createDate;
        private String clearingType;
        private Integer bifNumber;
        private String medium;

        public BifList(Date createDate, String clearingType, Integer bifNumber, String medium) {
            this.createDate = createDate;
            this.clearingType = clearingType;
            this.bifNumber = bifNumber;
            this.medium = medium;
        }

        public Date getCreateDate() {
            return createDate;
        }

        public void setCreateDate(Date createDate) {
            this.createDate = createDate;
        }

        public String getClearingType() {
            return clearingType;
        }

        public void setClearingType(String clearingType) {
            this.clearingType = clearingType;
        }

        public Integer getBifNumber() {
            return bifNumber;
        }

        public void setBifNumber(Integer bifNumber) {
            this.bifNumber = bifNumber;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

    }
}
