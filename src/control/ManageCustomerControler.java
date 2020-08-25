package control;

import business.BOFactory;
import business.BOType;
import business.custom.CustomerBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.CustomerTM;

import java.io.IOException;
import java.util.List;

public class ManageCustomerControler {
    public AnchorPane root;
    public TableView<CustomerTM> customerTable;
    public JFXTextField customerId;
    public JFXTextField customerName;
    public JFXTextField customerPhoneNumber;
    public JFXTextField noOfMembores;
    public JFXButton saveMemborButton;
    public JFXButton deletMemborButton;
    public JFXButton addNewButton;

    private CustomerBO customerBO= BOFactory.getInstance().getBo(BOType.CUSTOMER);
    public void initialize(){
        customerTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("customerId"));
        customerTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("customerName"));
        customerTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        customerTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("onOfMembors"));

        //ObservableList<CustomerTM> items = customerTable.getItems();
        //items.add(new CustomerTM("9745127123","kaml","077-2365741",7));

        customerTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CustomerTM>(){
            @Override
            public void changed(ObservableValue<?extends CustomerTM> observable, CustomerTM oldValue, CustomerTM newValue){
                if(newValue==null){
                    return;
                }
                customerId.setText(newValue.getCustomerId());
                customerName.setText(newValue.getCustomerName());
                customerPhoneNumber.setText(newValue.getPhoneNumber());
                noOfMembores.setText(newValue.getOnOfMembors()+"");
                saveMemborButton.setText("Update");

            }
        });

        loadTable();

    }

    public void loadTable(){
        try{
//            ObservableList<CustomerTM> items = customerTable.getItems();
//            items.add(new CustomerTM("9745127123","kaml","077-2365741",7));
            //List<CustomerTM> allCustomers = new BusinessLayer().getAllCustomers();
            List<CustomerTM> allCustomers=customerBO.getAllCustomers();
            ObservableList<CustomerTM> customerTMS= FXCollections.observableArrayList(allCustomers);
            customerTable.setItems(customerTMS);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void navigateHomeOnAction(ActionEvent actionEvent)throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/DashboardView.fxml"));
        Stage stage=(Stage)(this.root.getScene().getWindow());
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void moveToRomeUI(MouseEvent mouseEvent)throws IOException{
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/BookingRoomsView.fxml"));
        Stage stage=(Stage)this.root.getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void saveMemborButtonOnAction(ActionEvent actionEvent)throws Exception{

        String name=customerName.getText();
        String nic=customerId.getText();
        String phoneNo=customerPhoneNumber.getText();
        if(name.isEmpty()||nic.isEmpty()||phoneNo.isEmpty()||noOfMembores.getText().isEmpty()){
            return;
        }
        int memborCount=Integer.parseInt(noOfMembores.getText());


        if(saveMemborButton.getText().equals("Save")){
            customerBO.saveCustomer(nic,name,phoneNo,memborCount);
        }
        customerBO.updateCustmer(name,phoneNo,memborCount,nic);
        saveMemborButton.setText("Save");
        loadTable();

        customerId.clear();
        customerName.clear();
        customerPhoneNumber.clear();
        noOfMembores.clear();
    }

    public void deletMemborButtonOnAction(ActionEvent actionEvent)throws Exception{
        customerBO.deletCustomer(customerId.getText());
        loadTable();

    }


    public void addNewCustomerOnAction(ActionEvent actionEvent) {
    }
}
