/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bsb.riskoperons.to;

import java.util.List;
import pl.com.bsb.riskoperons.model.Environment;

/**
 *
 * @author Grzegorz
 */
public class RiskOperonTO {
    
    private Long clientId;
    private String clientName;
    private String clientInformation;
    
    private List<Environment> clientEnvironments;

    public RiskOperonTO() {
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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

    public List<Environment> getClientEnvironments() {
        return clientEnvironments;
    }

    public void setClientEnvironments(List<Environment> clientEnvironments) {
        this.clientEnvironments = clientEnvironments;
    }
    
    
    
}
