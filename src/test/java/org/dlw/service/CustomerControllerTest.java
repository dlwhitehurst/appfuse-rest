package org.dlw.service;

import org.dlw.model.Customer;
import org.dlw.controller.CustomersController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.rest.HttpHeaders;
import org.springframework.beans.factory.BeanFactory;

/**
 * Created by IntelliJ IDEA.
 * User: dlwhitehurst
 * Date: Apr 26, 2009
 * Time: 7:09:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomerControllerTest extends BaseManagerTestCase {

    private GenericManager<Customer, Long> mgr = null;
    private Log log = LogFactory.getLog(CustomerManagerTest.class);


    private Customer customer;
    private BeanFactory beanFactory;



    public void setCustomerManager(GenericManager<Customer, Long> customerManager) {
        this.mgr = customerManager;

    }

    public GenericManager<Customer, Long> getMgr() {
        return mgr;
    }

    public void testController() throws Exception {

        CustomersController controller = new CustomersController();
        
        HttpHeaders headers = controller.index();

        int status = headers.getStatus();
        log.debug("status code: " + status);
    }

}
