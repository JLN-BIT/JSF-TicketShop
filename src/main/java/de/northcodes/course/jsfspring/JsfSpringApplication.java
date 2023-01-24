package de.northcodes.course.jsfspring;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

import de.northcodes.course.jsfspring.model.BillingAddress;
import de.northcodes.course.jsfspring.model.User;
import de.northcodes.course.jsfspring.persistence.BillingRepository;
import de.northcodes.course.jsfspring.persistence.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import de.northcodes.course.jsfspring.model.Product;
import de.northcodes.course.jsfspring.persistence.ProductRepository;

@SpringBootApplication
public class JsfSpringApplication extends SpringBootServletInitializer {
	
	private static final Logger log = LoggerFactory.getLogger(JsfSpringApplication.class);
	
    public static void main(String[] args) {
        SpringApplication.run(JsfSpringApplication.class, args);
    }

    @Autowired
    UserRepository userRepository;
    @Autowired
    BillingRepository billingRepository;

    @Bean
    ServletRegistrationBean<FacesServlet> jsfServletRegistration (ServletContext servletContext) {
    	log.info("jsfServletRegistration started...");
    	
        //spring boot only works if this is set
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());

        //FacesServlet registration
        ServletRegistrationBean<FacesServlet> srb = new ServletRegistrationBean<FacesServlet>();
        srb.setServlet(new FacesServlet());
        srb.setUrlMappings(Arrays.asList("*.xhtml"));
        srb.setLoadOnStartup(1);
        return srb;
    }
    
    
    //Only need for development initialization purposes
    @Bean
    public CommandLineRunner demo(ProductRepository repository) {
      return (args) -> {
        // save a few products

        repository.save( new Product("Top Gear Show", "Essential for every car fan - this is the show any motorist likes", new BigDecimal("295.00"), "Top-Gear"));
        repository.save( new Product("Grand Tour Show Tickets", "Enjoy Jeremy Clarkson, Richard Hammond and James May live. This show will take place near Chipping Norton.", new BigDecimal("325.00"), "The-Grand-Tour"));
        repository.save( new Product("AC/DC Concert", "Everybody should attend an AC/DC Concert. It's a highlight.", new BigDecimal("195.00"), "AC-DC"));
        repository.save( new Product("McLaren Driving Experience", "Drive a Mclaren Senna around the Nurburgring. This one will never let you down. Maybee its the most spectacular thing you have ever done.", new BigDecimal("895.00"), "McLaren"));
        repository.save( new Product("Porsche Museum", "Visit the Porsche Museum in Stuttgart-Zuffenhausen and see all the famous Porsche cars.", new BigDecimal("49.00"), "Porsche-Museum"));

         // repository.save(new BillingAddress("1", "Peter", "Weber", "Magicstreet 1", "Magierhausen", "12345", "Germany"));


          // fetch all products
        log.info("Products found with findAll():");
        log.info("-------------------------------");
        for (Product product : repository.findAll()) {
          log.info(product.toString());
        }
        log.info("");

        // fetch an individual product by ID
        Product product = repository.findById(1L).get();
        log.info("Product found with findById(1L):");
        log.info("--------------------------------");
        log.info(product.toString());
        log.info("");

      };
    }



    @Bean
    public CommandLineRunner demo1() {

        return (args) -> {
            // save a few products
            DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
            Date d1 = df.parse("12-10-2011");
            Date d2 = df.parse("12-10-2012");

            userRepository.save(new User("user1",1,"user1","uFirstName","uLastName","test@test.de","0177-1515151", d1,false));
            userRepository.save(new User("user2",2,"user2","uFirstName2","uLastName2","test2@test.de","0178-1515151", d2,false));


            billingRepository.save(new BillingAddress(userRepository.findByUsername("user1"), "Peter", "Weber", "Magicstreet 1", "Magierhausen", 12345, "Germany"));
            billingRepository.save(new BillingAddress(userRepository.findByUsername("user1"), "Vanessa", "Weber", "Playstationstreet 5", "Sonyhausen", 54321, "Germany"));
            billingRepository.save(new BillingAddress(userRepository.findByUsername("user1"), "Manuel", "Weber", "Dominusstreet 24", "Raketenhausen", 99559, "Germany"));
            billingRepository.save(new BillingAddress(userRepository.findByUsername("user2"), "Tessa", "Müller", "Dominusstreet 25", "Raketenhausen", 99559, "Germany"));
        };
    }




}