package de.northcodes.course.jsfspring.model;

import de.northcodes.course.jsfspring.model.AbstractEntity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = AbstractEntity.SHOP_PREFIX + "billing")
public class BillingAddress  extends AbstractEntity implements Serializable {




    @Column(name = "userid", nullable = false)
    private int userid;
    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "streetAddress", nullable = false)
    private String streetAddress;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "zipCode", nullable = false)
    private int zipCode;
    @Column(name = "country", nullable = false)
    private String country;

    public BillingAddress(int userid, String firstName, String lastName, String streetAddress, String city, int zipCode, String country) {
        this.userid=userid;
        this.firstName=firstName;
        this.lastName=lastName;
        this.streetAddress=streetAddress;
        this.city=city;
        this.zipCode=zipCode;
        this.country=country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

}
