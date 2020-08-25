package business.custom;

import business.SuperBO;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import util.CustomerTM;

import java.util.List;

public interface CustomerBO extends SuperBO {
    public List<CustomerTM> getAllCustomers() throws Exception;
    public CustomerTM getCustomer(String id) throws Exception;
    public void saveCustomer(String id, String name, String phoneNo, int membors) throws Exception;
    public void updateCustmer(String name, String phoneNo, int membors, String id) throws Exception;
    public void deletCustomer(String id) throws Exception;

}
