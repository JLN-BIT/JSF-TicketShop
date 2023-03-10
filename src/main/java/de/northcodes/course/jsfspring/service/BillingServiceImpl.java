package de.northcodes.course.jsfspring.service;

import de.northcodes.course.jsfspring.model.BillingAddress;
import de.northcodes.course.jsfspring.model.User;
import de.northcodes.course.jsfspring.persistence.BillingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingServiceImpl implements BillingService {
    private static final Logger log = LoggerFactory.getLogger(BillingServiceImpl.class);
    @Autowired
    BillingRepository billingRepository;

    @Override
    public void createBillingAdress(String username, String firstName, String lastName, int zipCode, String city, String streetAddress, String country) {

    }

    @Override
    public List<BillingAddress> getAllBillingAdresses(User owner) {
        log.info("getAllBillingAdresses called with user " + owner);
        return billingRepository.findByOwner(owner);
    }

    public BillingAddress setBillingAddress(BillingAddress newBillingAddress) {
        return billingRepository.save(newBillingAddress);
    }
}
