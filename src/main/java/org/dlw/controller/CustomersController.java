package org.dlw.controller;

import com.opensymphony.xwork2.ValidationAwareSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Validateable;

import java.util.Collection;

import org.apache.struts2.rest.HttpHeaders;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.convention.annotation.Result;
import org.dlw.model.Customer;
import org.dlw.service.GenericManager;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: dlwhitehurst
 * Date: Apr 26, 2009
 * Time: 9:53:26 AM
 * To change this template use File | Settings | File Templates.
 */

@Results({
    @Result(name="success", type="redirectAction", params = {"actionName" , "customers"})
})
public class CustomersController extends ValidationAwareSupport implements ModelDriven<Object>, Validateable {

    private Customer model = new Customer();
    private String id;
    private Collection<Customer> list;

    private GenericManager<Customer, Long> customersService = null;

    public CustomersController() {

        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
                new String[] {"applicationContext-dao.xml", "applicationContext-service.xml",
                "applicationContext-resources.xml"});

        
        BeanFactory factory = (BeanFactory) appContext;
        customersService = (GenericManager<Customer, Long>) factory.getBean("customerManager");
    }

    // GET /customers/1
    public HttpHeaders show() {
        model = customersService.get(new Long(id));
        return new DefaultHttpHeaders("show");
    }

    // GET /customers
    public HttpHeaders index() {
        list = customersService.getAll();

        return new DefaultHttpHeaders("index")
            .disableCaching();
    }

    // GET /customers/1/edit
    public String edit() {
        return "edit";
    }

    // GET /customers/new
    public String editNew() {
        model = new Customer();
        return "editNew";
    }

    // GET /orders/1/deleteConfirm
    public String deleteConfirm() {
        return "deleteConfirm";
    }

    // DELETE /orders/1
    public String destroy() {
        customersService.remove(new Long(id));
        addActionMessage("Customer removed successfully");
        return "success";
    }

    // POST /orders
    public HttpHeaders create() {
        customersService.save(model);
        addActionMessage("New customer created successfully");
        return new DefaultHttpHeaders("success")
            .setLocationId(model.getId());
    }

    // PUT /orders/1
    public String update() {
        customersService.save(model);
        addActionMessage("Customer updated successfully");
        return "success";
    }

    public void validate() {
//        if (model.getClientName() == null || model.getClientName().length() ==0) {
//            addFieldError("clientName", "The client name is empty");
//        }
    }

    public void setId(String id) {
        if (id != null) {
            this.model = customersService.get(new Long(id));
        }

        this.id = id;
    }

    public Object getModel() {
        return (list != null ? list : model);
    }

}
