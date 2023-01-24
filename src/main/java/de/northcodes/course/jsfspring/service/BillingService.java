package de.northcodes.course.jsfspring.service;


import de.northcodes.course.jsfspring.model.BillingAddress;
import de.northcodes.course.jsfspring.model.User;

import java.util.List;

public interface BillingService {
    public void createBillingAdress(String username,String firstName, String lastName,  int zipCode, String city, String streetAddress, String country );

    public  List<BillingAddress> getAllBillingAdresses(User owner);
}
