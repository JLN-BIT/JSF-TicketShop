package de.northcodes.course.jsfspring.bean;

import de.northcodes.course.jsfspring.model.BillingAddress;
import de.northcodes.course.jsfspring.model.User;
import de.northcodes.course.jsfspring.service.BillingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.util.List;

@SessionScoped
@Component
@ManagedBean
public class Billing  {

    @Autowired
    private BillingService billingService;

    @Autowired
    private UserManager userManager;

    private final BillingAddress newBillingAddress = new BillingAddress();

    public BillingAddress getNewBillingAddress(){return newBillingAddress; }


    public List<BillingAddress> getBillingAddresses(User owner) { return billingService.getAllBillingAdresses(owner);}

    public void saveNewBillingAddress(){
        newBillingAddress.setOwner(userManager.getCurrentUser());
        billingService.setBillingAddress(newBillingAddress);



    }
}
