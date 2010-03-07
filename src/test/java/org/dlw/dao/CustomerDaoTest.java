package org.dlw.dao;

import org.dlw.model.Customer;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: dlwhitehurst
 * Date: Apr 25, 2009
 * Time: 10:07:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomerDaoTest extends BaseDaoTestCase {


    private GenericDao<Customer, Long> dao;

    public void setCustomerDao(GenericDao<Customer, Long> customerDao) {
        this.dao = customerDao;
    }

    public void testGetCustomer() throws Exception {

        Customer customer = dao.get(1L);

        assertNotNull(customer);
        assertEquals("David Whitehurst", customer.getName());

    }

    public void testGetCustomers() throws Exception {
        List<Customer> customers = dao.getAll();

        assertNotNull(customers);
        //assertEquals(2, customers.size());

    }

    public void testUpdateCustomer() throws Exception {

        Customer customer = dao.get(1L);

        dao.save(customer);
        flush();

        customer = dao.get(1L);
        assertEquals("David Whitehurst", customer.getName());

        // verify that violation occurs when adding new user with same name
        customer.setId(null);

        endTransaction();

        try {
            dao.save(customer);
            flush();
            fail("saveItem didn't throw DataIntegrityViolationException");
        } catch (DataIntegrityViolationException e) {
            assertNotNull(e);
            log.debug("expected exception: " + e.getMessage());
        }
    }


}

