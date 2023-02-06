package de.northcodes.course.jsfspring.service;


import de.northcodes.course.jsfspring.model.BillingAddress;
import de.northcodes.course.jsfspring.model.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BillingService  {
    public void createBillingAdress(String username,String firstName, String lastName,  int zipCode, String city, String streetAddress, String country );

    public  List<BillingAddress> getAllBillingAdresses(User owner);

    public BillingAddress setBillingAddress(BillingAddress newBillingAddress);

}
