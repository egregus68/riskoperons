/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bsb.riskoperons.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.com.bsb.riskoperons.dao.ClientEnvironmentFacade;
import pl.com.bsb.riskoperons.dao.ClientFacade;
import pl.com.bsb.riskoperons.model.Client;
import pl.com.bsb.riskoperons.model.ClientEnvironment;

/**
 *
 * @author Grzegorz
 */
@ManagedBean
@SessionScoped
public class MenuBean implements Serializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(MenuBean.class);
    
    private MenuModel menuModel;
    
    @EJB
    private ClientFacade clientFacade;
    
    @EJB
    private ClientEnvironmentFacade clientEnvironmentFacade;
    
    /**
     * Creates a new instance of MenuBean
     */
    public MenuBean() {
    }
    
    @PostConstruct
    public void init() {
        LOGGER.info("init menu start");
        
        menuModel = new DefaultMenuModel();
        
        List<Client> clients = clientFacade.findAll();
        List<ClientEnvironment> clientEnvironments = clientEnvironmentFacade.findAll();

        for (Client client : clients) {
            
            DefaultSubMenu submenu = new DefaultSubMenu(client.getName());
        
            for (ClientEnvironment clientEnvironment : clientEnvironments) {                
                if (client.getId().equals(clientEnvironment.getClient().getId())) {
                    DefaultMenuItem item = new DefaultMenuItem();
                    
                    item.setValue("Środowisko " + clientEnvironment.getEnvironment().getEnvironmentType().getName() + (null!=clientEnvironment.getEnvironment().getName() ? " " + clientEnvironment.getEnvironment().getName() : ""));
                    item.setCommand("#{riskOperonBean.riskOperonEntrie("+clientEnvironment.getId()+")}");                    

                    item.setUpdate(":resultForm");
                    
                    submenu.addElement(item);
                }
            }
            
            menuModel.addElement(submenu);
            
        }
        LOGGER.info("init menu stop");
    }
    
    public MenuModel getMenuModel() {
      return menuModel;
   }
}
