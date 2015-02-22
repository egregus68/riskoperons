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
@Table(name = "RMI_LAYER")
public class RmiLayer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "OPERATING_SYSTEM", length = 100)
    private String operatingSystem;
    
    @Column(name = "RMI_SYSTEM", length = 100)
    private String rmiSystem;
    
    @Column(name = "HOST", length = 20)
    private String host;
    
    @Column(name = "PORT", length = 20)
    private String port;
    
    @Column(name = "REPORTS_PATH", length = 100)
    private String reportsPath;
    
    @Column(name = "RMI_SERVER_PATH", length = 100)
    private String rmiServerPath;
        
    @Column(name = "INFORMATION", length = 200)
    private String information;
    
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

    public String getRmiSystem() {
        return rmiSystem;
    }

    public void setRmiSystem(String rmiSystem) {
        this.rmiSystem = rmiSystem;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getReportsPath() {
        return reportsPath;
    }

    public void setReportsPath(String reportsPath) {
        this.reportsPath = reportsPath;
    }

    public String getRmiServerPath() {
        return rmiServerPath;
    }

    public void setRmiServerPath(String rmiServerPath) {
        this.rmiServerPath = rmiServerPath;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
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
        if (!(object instanceof RmiLayer)) {
            return false;
        }
        RmiLayer other = (RmiLayer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.com.bsb.riskoperons.model.RmiLayer[ id=" + id + " ]";
    }
    
}
