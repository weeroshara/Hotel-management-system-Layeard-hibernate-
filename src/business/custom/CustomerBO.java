package business.custom;

import business.SuperBO;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import util.CustomerTM;

import java.util.List;

public interface CustomerBO extends SuperBO {
    public List<CustomerTM> getAllCustomers() throws Exception;
    public CustomerTM getCustomer(String id) throws Exception;
    public boolean saveCustomer(String id, String name, String phoneNo, int membors) throws Exception;
    public boolean updateCustmer(String name, String phoneNo, int membors, String id) throws Exception;
    public boolean deletCustomer(String id) throws Exception;

}
