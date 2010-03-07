package org.dlw.model;

import org.dlw.model.BaseObject;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: dlwhitehurst
 * Date: Apr 25, 2009
 * Time: 5:39:09 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="customer")
public class Customer extends BaseObject implements Serializable {

    private Long id;
    private String name;
    private String phone;

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable=false,length=50,unique=true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable=false,length=50,unique=true)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String toString() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean equals(Object o) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int hashCode() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
