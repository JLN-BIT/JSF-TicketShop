package de.northcodes.course.jsfspring.persistence;


import de.northcodes.course.jsfspring.model.BillingAddress;
import org.springframework.data.repository.CrudRepository;

public interface BillingRepository extends CrudRepository<BillingAddress, Long> {
}
