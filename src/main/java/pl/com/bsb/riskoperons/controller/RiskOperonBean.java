/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bsb.riskoperons.controller;

import pl.com.bsb.riskoperons.report.ReportBase;
import pl.com.bsb.riskoperons.utils.PropertyFileUtils;
import pl.com.bsb.riskoperons.report.wrapper.ReportListWrapper;
import pl.com.bsb.riskoperons.report.wrapper.ReportRiskOperonWrapper;
import pl.com.bsb.riskoperons.report.ParamsBuilder;
import pl.com.bsb.riskoperons.enums.ReportType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.com.bsb.riskoperons.dao.ClientEnvironmentFacade;
import pl.com.bsb.riskoperons.dao.ClientFacade;
import pl.com.bsb.riskoperons.model.Client;
import pl.com.bsb.riskoperons.model.ClientEnvironment;
import pl.com.bsb.riskoperons.model.Environment;
import pl.com.bsb.riskoperons.enums.ReportFormat;
import pl.com.bsb.riskoperons.report.ReportTemplate;
import pl.com.bsb.riskoperons.report.SupportedReportType;
import pl.com.bsb.riskoperons.report.AbstractReportDataCallback;
import pl.com.bsb.riskoperons.to.RiskOperonTO;


/**
 *
 * @author Grzegorz
 */
@ManagedBean(name = "riskOperonBean")
@SessionScoped
public class RiskOperonBean extends ReportBase implements Serializable {
    
    private Logger LOGGER = LoggerFactory.getLogger(RiskOperonBean.class);
    
    @EJB
    private ClientFacade clientFacade;
    
    @EJB
    private ClientEnvironmentFacade clientEnvironmentFacade;
    
    private Environment selectedEnvironment;
    private ReportTemplate reportTemplate;
    private List<ReportListWrapper> reportList = new ArrayList<>();
    private SupportedReportType pdfReportType = new SupportedReportType(ReportFormat.PDF);
    private Long selectedId;
    List<Client> clients;
    List<ClientEnvironment> clientEnvironments;
    
    /**
     * Creates a new instance of RiskListBean
     */
    public RiskOperonBean() {
    }
    
    @PostConstruct
    public void init() {
        this.clients = clientFacade.findAll();
        this.clientEnvironments = clientEnvironmentFacade.findAll();
    }

    /**
     * @return the riskOperonsEntries
     */
    public List<RiskOperonTO> getRiskOperonsEntries() {        
//        List<Client> clients = clientFacade.findAll();
//        List<ClientEnvironment> clientEnvironments = clientEnvironmentFacade.findAll();
        List<RiskOperonTO> result = new ArrayList<>();
        for (Client client : clients) {
            RiskOperonTO riskOperonTO = new RiskOperonTO();
            riskOperonTO.setClientId(client.getId());
            riskOperonTO.setClientName(client.getName());
            riskOperonTO.setClientInformation(client.getInformation());            
            result.add(riskOperonTO);
        }
        
        for (RiskOperonTO riskOperonTO : result) {           
            List<Environment> environments = new ArrayList<>();
            for (ClientEnvironment clientEnvironment : clientEnvironments) {                
                if (riskOperonTO.getClientId().equals(clientEnvironment.getClient().getId())) {
                    environments.add(clientEnvironment.getEnvironment());
                }
            }
            riskOperonTO.setClientEnvironments(environments);            
        }
        return result;
    }
    
    public String riskOperonEntrie(Long id) {        
        LOGGER.info("Wskazano pozycję z menu: "+id);
        setSelectedId(id);
        
        this.selectedEnvironment = clientEnvironmentFacade.find(selectedId).getEnvironment();
        
        return "operational.page";
    }
    
    
    public void generateReport() {        
        reportTemplate = ReportType.RISK_OPERONS_INFO.getReportTemplate(true, new RiskOperonDataCallback());
        executeReport(pdfReportType, reportTemplate);
    }

    public Long getSelectedId() {
        LOGGER.info("Pobrano wartość ID: "+selectedId);
        
        return selectedId;
    }
    
    public Boolean getRendered() {       
        return selectedId != null ? Boolean.TRUE : Boolean.FALSE;
    }

    public void setSelectedId(Long selectedId) {
        this.selectedId = selectedId;
    }

    public Environment getSelectedEnvironment() {
        return selectedEnvironment;
    }

    public void setSelectedEnvironment(Environment selectedEnvironment) {
        this.selectedEnvironment = selectedEnvironment;
    }
    
    public String getSelectedClientName() {       
        String result = "";
        String clientName = "";
        for (ClientEnvironment clientEnvironment : clientEnvironments) {
            if (clientEnvironment.getEnvironment().getId().equals(selectedId)) {
                for (Client client : clients) {
                    if (client.getId().equals(clientEnvironment.getClient().getId())) {
                        clientName = client.getName();
                    }
                }
            }
        }
        result += clientName;
        return  result;
    }
    
    public String getSelectedEnvironmentName() {       
        String result = "";
        result += "[środowisko " + selectedEnvironment.getEnvironmentType().getName();
        result += (null!=selectedEnvironment.getName() ? " " + selectedEnvironment.getName() : "") + ", Id: " + selectedId + "]";
        return  result;
    }
    
    public String getSelectedEnvironmentInfo() {       
        String result = null!=selectedEnvironment.getInformation() && !selectedEnvironment.getInformation().isEmpty() ? selectedEnvironment.getInformation() : "";
        return result;
    }
    
    
    class RiskOperonDataCallback extends AbstractReportDataCallback {

        @Override
        public Map<String, Object> getParameters() {
            ParamsBuilder params = new ParamsBuilder();
            params.put("createDate", new Date());
            params.put("reportTitle", PropertyFileUtils.format(ReportType.RISK_OPERONS_INFO.getKey()));
            return params.build();
        }

        @Override
        public Collection<Object> getReportData() {
            Collection<Object> riskOperonsReportWrapper = new ArrayList<>();
            if (selectedEnvironment != null) {
                List<ClientEnvironment> clientEnvironments = clientEnvironmentFacade.findAll();
                for (ClientEnvironment ce : clientEnvironments) {                
                    if (selectedEnvironment.getId().equals(ce.getEnvironment().getId())) {
                        ReportRiskOperonWrapper wrapper = new ReportRiskOperonWrapper();
                        wrapper.setClientName(ce.getClient().getName());
                        wrapper.setClientInformation(ce.getClient().getInformation());
                        
                        wrapper.setEnvironmentName("Środowisko " + ce.getEnvironment().getEnvironmentType().getName() + " " + ce.getEnvironment().getName() + "  Id: " + ce.getEnvironment().getId());
                        wrapper.setEnvironmentInfo(ce.getEnvironment().getInformation());
                        
                        if (null != ce.getEnvironment().getApplicationLayer()) {
                            if (null!= ce.getEnvironment().getApplicationLayer().getUrlPath()) {
                                wrapper.setAppUrlPath(ce.getEnvironment().getApplicationLayer().getUrlPath());
                            }
                            if (null!= ce.getEnvironment().getApplicationLayer().getHost()) {
                                wrapper.setAppHost(ce.getEnvironment().getApplicationLayer().getHost());
                            }
                            if (null!= ce.getEnvironment().getApplicationLayer().getOperatingSystem()) {
                                wrapper.setAppOperatingSystem(ce.getEnvironment().getApplicationLayer().getOperatingSystem());
                            }
                            if (null!= ce.getEnvironment().getApplicationLayer().getApplicationSystem()) {
                                wrapper.setAppAS(ce.getEnvironment().getApplicationLayer().getApplicationSystem());
                            }
                            if (null!= ce.getEnvironment().getApplicationLayer().getPath()) {
                                wrapper.setAppPath(ce.getEnvironment().getApplicationLayer().getPath());
                            }
                            if (null!= ce.getEnvironment().getApplicationLayer().getUrlAdminConsole()) {
                                wrapper.setAppUrlConsole(ce.getEnvironment().getApplicationLayer().getUrlAdminConsole());
                            }
                            if (null!= ce.getEnvironment().getApplicationLayer().getSvnBranch()) {
                                wrapper.setAppSvnBranch(ce.getEnvironment().getApplicationLayer().getSvnBranch());
                            }
                            if (null!= ce.getEnvironment().getApplicationLayer().getInformation()) {
                                wrapper.setAppInformation(ce.getEnvironment().getApplicationLayer().getInformation());
                            }
                        }
                        
                        if (null!= ce.getEnvironment().getDatabaseLayer()) {
                            if (null != ce.getEnvironment().getDatabaseLayer().getHost()) {
                                wrapper.setDbHost(ce.getEnvironment().getDatabaseLayer().getHost());
                            }
                            if (null != ce.getEnvironment().getDatabaseLayer().getOperatingSystem()) {
                                wrapper.setDbOperatingSystem(ce.getEnvironment().getDatabaseLayer().getOperatingSystem());
                            }
                            if (null != ce.getEnvironment().getDatabaseLayer().getDatabaseSystem()) {
                                wrapper.setDbDatabase(ce.getEnvironment().getDatabaseLayer().getDatabaseSystem());
                            }
                            if (null != ce.getEnvironment().getDatabaseLayer().getLink()) {
                                wrapper.setDbLink(ce.getEnvironment().getDatabaseLayer().getLink());
                            }
                            if (null != ce.getEnvironment().getDatabaseLayer().getInformation()) {
                                wrapper.setDbInformation(ce.getEnvironment().getDatabaseLayer().getInformation());
                            }
                        }
                        
                        if (null != ce.getEnvironment().getRmiLayer()) {
                            if (null != ce.getEnvironment().getRmiLayer().getHost()) {
                                wrapper.setRmiHost(ce.getEnvironment().getRmiLayer().getHost());
                            }
                            if (null != ce.getEnvironment().getRmiLayer().getOperatingSystem()) {
                                wrapper.setRmiOperatingSystem(ce.getEnvironment().getRmiLayer().getOperatingSystem());
                            }
                            if (null != ce.getEnvironment().getRmiLayer().getPort()) {
                                wrapper.setRmiPort(ce.getEnvironment().getRmiLayer().getPort());
                            }
                            if (null != ce.getEnvironment().getRmiLayer().getReportsPath()) {
                                wrapper.setRmiReportsPath(ce.getEnvironment().getRmiLayer().getReportsPath());
                            }
                            if (null != ce.getEnvironment().getRmiLayer().getRmiServerPath()) {
                                wrapper.setRmiServerPath(ce.getEnvironment().getRmiLayer().getRmiServerPath());
                            }
                            if (null != ce.getEnvironment().getRmiLayer().getInformation()) {
                                wrapper.setRmiInformation(ce.getEnvironment().getRmiLayer().getInformation());
                            }
                        }
                        
                        riskOperonsReportWrapper.add(wrapper);
                    }
                }
            }     
         return riskOperonsReportWrapper;
        }
        
    }

}
