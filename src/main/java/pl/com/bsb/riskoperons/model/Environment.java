/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bsb.riskoperons.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import pl.com.bsb.riskoperons.enums.EnvironmentType;

/**
 *
 * @author Grzegorz
 */
@Entity
@Table(name = "ENVIRONMENT")
public class Environment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "ENVIRONMENT_TYPE", length = 20)
    @Enumerated(EnumType.STRING)
    private EnvironmentType environmentType;
    
    @Column(name = "NAME", length = 100)
    private String name;
    
    @Column(name = "INFORMATION", length = 200)
    private String information;
    
    @ManyToOne
    @JoinColumn(name = "APPLICATION_LAYER_ID")
    private ApplicationLayer applicationLayer;
    
    @ManyToOne
    @JoinColumn(name = "DATABASE_LAYER_ID")
    private DatabaseLayer databaseLayer;
    
    @ManyToOne
    @JoinColumn(name = "RMI_LAYER_ID")
    private RmiLayer rmiLayer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EnvironmentType getEnvironmentType() {
        return environmentType;
    }

    public void setEnvironmentType(EnvironmentType environmentType) {
        this.environmentType = environmentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public ApplicationLayer getApplicationLayer() {
        return applicationLayer;
    }

    public void setApplicationLayer(ApplicationLayer applicationLayer) {
        this.applicationLayer = applicationLayer;
    }

    public DatabaseLayer getDatabaseLayer() {
        return databaseLayer;
    }

    public void setDatabaseLayer(DatabaseLayer databaseLayer) {
        this.databaseLayer = databaseLayer;
    }

    public RmiLayer getRmiLayer() {
        return rmiLayer;
    }

    public void setRmiLayer(RmiLayer rmiLayer) {
        this.rmiLayer = rmiLayer;
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
        if (!(object instanceof Environment)) {
            return false;
        }
        Environment other = (Environment) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "pl.com.bsb.riskoperons.model.Environment[ id=" + id + " ]";
    }
    
}
