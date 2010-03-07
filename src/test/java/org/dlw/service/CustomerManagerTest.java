package org.dlw.service;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.dlw.model.Customer;
import org.springframework.orm.ObjectRetrievalFailureException;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: dlwhitehurst
 * Date: Apr 25, 2009
 * Time: 11:06:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomerManagerTest extends BaseManagerTestCase {

    private GenericManager<Customer, Long> mgr = null;
    private Log log = LogFactory.getLog(CustomerManagerTest.class);
    private Customer customer;

    public void setCustomerManager(GenericManager<Customer, Long> customerManager) {
        this.mgr = customerManager;

    }

    public void testGetItem() throws Exception {
        customer = mgr.get(new Long(1));
        assertNotNull(customer);

        log.debug(customer);
    }

    public void testAddAndRemoveCustomer() throws Exception {

        customer = new Customer();
        customer.setName("John Doe");
        customer.setPhone("928-234-4566");

        customer = mgr.save(customer);
        assertEquals("John Doe", customer.getName());
        Long id = customer.getId();
        log.debug("removing customer...");

        mgr.remove(customer.getId());

        try {
            customer = null;
            customer = mgr.get(id);
        } catch (ObjectRetrievalFailureException orgfe) {
            log.debug("Customer not there");
        }
        assertNull(customer);
    }

   public void testGetAll() throws Exception {

       List<Customer> customers = mgr.getAll();
       assertEquals(customers.size(), 2);
   }
}

