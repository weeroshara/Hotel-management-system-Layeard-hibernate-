import business.custom.impl.BusinessLayer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.CustomerTM;

import java.util.List;

public class BusinessTest {
    public static void main(String[] args) {
        List<CustomerTM> allCustomers = new BusinessLayer().getAllCustomers();
        ObservableList<CustomerTM> customerTMS = FXCollections.observableArrayList(allCustomers);
        for (CustomerTM customerTM : customerTMS) {
            System.out.println(customerTM);
        }
    }
}
