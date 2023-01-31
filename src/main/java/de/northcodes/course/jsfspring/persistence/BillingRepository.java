package de.northcodes.course.jsfspring.persistence;


import de.northcodes.course.jsfspring.model.BillingAddress;
import de.northcodes.course.jsfspring.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BillingRepository extends CrudRepository<BillingAddress, Long> {


    List<BillingAddress> findByOwner(User owner);

   void createByOwner(User owner);
}
