package de.northcodes.course.jsfspring.service;

import de.northcodes.course.jsfspring.model.BillingAddress;
import de.northcodes.course.jsfspring.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingServiceImpl implements BillingService{

    @Override
    public void createBillingAdress(User user, String firstName, String lastName, int zipCode, String city, String streetAddress, String country) {

    }

    @Override
    public List<BillingAddress> getAllBillingAdresses(User user) {
        return null;
    }
}
