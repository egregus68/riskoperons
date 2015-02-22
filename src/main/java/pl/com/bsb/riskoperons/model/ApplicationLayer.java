/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bsb.riskoperons.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Grzegorz
 */
@Entity
@Table(name = "APPLICATION_LAYER")
public class ApplicationLayer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "OPERATING_SYSTEM", length = 100)
    private String operatingSystem;
    
    @Column(name = "APPLICATION_SYSTEM", length = 100)
    private String applicationSystem;
    
    @Column(name = "HOST", length = 20)
    private String host;
    
    @Column(name = "HTTP_PORT", length = 20)
    private String httpPort;
    
    @Column(name = "PATH", length = 100)
    private String path;
    
    @Column(name = "APPLICATION_CONTEXT", length = 100)
    private String applicationContext;
    
    @Column(name = "SVN_BRANCH", length = 50)
    private String svnBranch;
    
    @Column(name = "INFORMATION", length = 200)
    private String information;
    
    @Column(name = "ADMIN_PORT", length = 20)
    private String adminPort;
    
    @Column(name = "ADMIN_CONTEXT", length = 20)
    private String adminContext;
    
    @Column(name = "HTTPS_PORT", length = 20)
    private String httpsPort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getApplicationSystem() {
        return applicationSystem;
    }

    public void setApplicationSystem(String applicationSystem) {
        this.applicationSystem = applicationSystem;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getHttpPort() {
        return httpPort;
    }

    public void setHttpPort(String httpPort) {
        this.httpPort = httpPort;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(String applicationContext) {
        this.applicationContext = applicationContext;
    }

    public String getSvnBranch() {
        return svnBranch;
    }

    public void setSvnBranch(String svnBranch) {
        this.svnBranch = svnBranch;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getAdminPort() {
        return adminPort;
    }

    public void setAdminPort(String adminPort) {
        this.adminPort = adminPort;
    }

    public String getAdminContext() {
        return adminContext;
    }

    public void setAdminContext(String adminContext) {
        this.adminContext = adminContext;
    }

    public String getHttpsPort() {
        return httpsPort;
    }

    public void setHttpsPort(String httpsPort) {
        this.httpsPort = httpsPort;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApplicationLayer)) {
            return false;
        }
        ApplicationLayer other = (ApplicationLayer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.com.bsb.riskoperons.model.ApplicationLayer[ id=" + id + " ]";
    }
    
    public String getUrlPath() {
        String result = "http://";
        result += this.host;
        result += (null!=this.httpPort && !this.httpPort.isEmpty() ? ":" + this.httpPort : "");
        result += (null!=this.applicationContext && !this.applicationContext.isEmpty() ? this.applicationContext : "");
        return result;
    }
    
    public String getUrlAdminConsole() {
        String result = "";
        if (null!=this.adminPort || null!=this.adminContext) {
            result += "http://";
            result += this.host;
            result += (null!=this.adminPort && !this.adminPort.isEmpty() ? ":" + this.adminPort : "");
            result += (null!=this.adminContext && !this.adminContext.isEmpty() ? this.adminContext : "");
        }
        return result;
    }
}
