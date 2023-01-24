package de.northcodes.course.jsfspring.bean;

import de.northcodes.course.jsfspring.model.BillingAddress;
import de.northcodes.course.jsfspring.model.User;
import de.northcodes.course.jsfspring.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@RequestScoped
@Component
@ManagedBean
public class Billing {

    @Autowired
    private BillingService billingService;

    public List<BillingAddress> getBillingAddresses(User owner) { return billingService.getAllBillingAdresses(owner);}
}
