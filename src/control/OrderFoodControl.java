package control;

import business.BOFactory;
import business.BOType;
import business.custom.CustomerBO;
import business.custom.FoodBO;
import business.custom.OrderFoodBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.omg.CORBA.INTERNAL;
import util.CustomerTM;
import util.FoodTM;
import util.OrderFoodTM;

import java.awt.geom.Arc2D;
import java.beans.IntrospectionException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderFoodControl {
    public AnchorPane root;
    public JFXComboBox<String> customerId;
    public JFXTextField customerName;
    public JFXTextField foodName;
    public TableView<OrderFoodTM> orderFoodTable;
    public JFXButton saveButton;
    public JFXButton deletButton;
    public JFXComboBox<String> foodId;
    public JFXTextField quentity;
    public JFXTextField total;
    public JFXButton addNewButton;
    public JFXButton placeOrderButton;
    public Label ordrIdLable;
    public JFXTextField quentityOnHand;

    public List<OrderFoodTM> orderFoodTMS=new ArrayList<>();
    public int posiblefoods=0;

    private CustomerBO customerBO= BOFactory.getInstance().getBo(BOType.CUSTOMER);
    private FoodBO foodBO=BOFactory.getInstance().getBo(BOType.FOOD);
    private OrderFoodBO orderFoodBO=BOFactory.getInstance().getBo(BOType.ORDERFOOD);

    public void navigateHomeOnAction(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/DashboardView.fxml"));
        Stage stage=(Stage) (this.root.getScene().getWindow());
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize() throws Exception {
        orderFoodTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("foodId"));
        orderFoodTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("foodName"));
        orderFoodTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("quentity"));
        orderFoodTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("total"));

        loadCustomers();
        loadFoofs();
        orderID();

        customerId.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue==null){
                    return;
                }
                System.out.println(newValue);
                CustomerTM customer = null;
                try {
                    customer = customerBO.getCustomer(newValue);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                customerName.setText(customer.getCustomerName());
            }
        });

        foodId.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue==null){
                    return;
                }
                FoodTM food = null;
                try {
                    food = foodBO.findFood(newValue);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                foodName.setText(food.getFoodName());

                System.out.println(newValue);
                for (OrderFoodTM orderFoodTM : orderFoodTMS) {
                    if (newValue.equals(orderFoodTM.getFoodId())){
                        posiblefoods=orderFoodTM.getQuentity();
                    }
                }
                quentityOnHand.setText((food.getQuentityOnHand()-posiblefoods)+"");
                System.out.println(food.getQuentityOnHand()-posiblefoods);

            }
        });

        quentity.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue==null){
                    return;
                }else {
                    if (quentity.getText().equals("")) {
                        return;
                    } else {
                        int quentityOnHand = Integer.parseInt(OrderFoodControl.this.quentityOnHand.getText());
                        int newVal = Integer.parseInt(newValue);
                        if (newVal > quentityOnHand) {
                            new Alert(Alert.AlertType.ERROR, "you can order less than " + quentityOnHand, ButtonType.OK).show();
                            saveButton.setDisable(true);
                        } else {
                            System.out.println("else");
                            saveButton.setDisable(false);
                        }
                        return;
                    }
                }


            }
        });
    }

    public void loadCustomers() throws Exception {
        List<CustomerTM> allCustomers = customerBO.getAllCustomers();
        List<String> customers=new ArrayList<>();
        for (CustomerTM allCustomer : allCustomers) {
            customers.add(allCustomer.getCustomerId());
        }
        customerId.setItems(FXCollections.observableArrayList(customers));
    }

    public void loadFoofs() throws Exception {
        List<FoodTM> posibleFoods = foodBO.findPosibleFoods();
        List<String> foodId=new ArrayList<>();
        for (FoodTM posibleFood : posibleFoods) {
            foodId.add(posibleFood.getFoodId());
        }
        this.foodId.setItems(FXCollections.observableArrayList(foodId));

    }

    public void orderID() throws Exception {
        String s = orderFoodBO.orderId();
        ordrIdLable.setText(s);
    }

    public void placeOrderButtonOnAction(ActionEvent actionEvent) throws Exception{
        orderFoodBO.placeOrderFood(ordrIdLable.getText(),customerId.getValue(),orderFoodTMS);
        orderFoodTable.getItems().clear();
        customerId.getItems().clear();
        customerName.clear();

    }

    public void addNewButtonOnAction(ActionEvent actionEvent) throws Exception {
        orderID();
    }

    public void deletButtonOnAction(ActionEvent actionEvent) throws Exception{
    }

    public void saveButtonOnAction(ActionEvent actionEvent) throws Exception{
        if (foodId.getSelectionModel().isEmpty() || quentity.getText().isEmpty()){
            return;
        }
        String selectedItem = foodId.getSelectionModel().getSelectedItem();
        FoodTM food = foodBO.findFood(selectedItem);

        int qty = Integer.parseInt(quentity.getText());
        int price = Integer.parseInt(food.getPrice() + "");

        int tot = qty * price;
        BigDecimal totalDesimal = BigDecimal.valueOf(Double.parseDouble(tot + ""));

        orderFoodTable.getItems().clear();
        List<OrderFoodTM> neArray=new ArrayList<>();
        for (OrderFoodTM orderFoodTM : orderFoodTMS) {
            if (foodId.getSelectionModel().getSelectedItem().equals(orderFoodTM.getFoodId())){

                System.out.println(orderFoodTMS);
                int neQty = orderFoodTM.getQuentity() + qty;
                int newPrice = neQty * price;
                BigDecimal newtotalDesimal = BigDecimal.valueOf(Double.parseDouble(newPrice + ""));

                neArray.add(new OrderFoodTM(orderFoodTM.getFoodId(),orderFoodTM.getFoodName(),neQty,newtotalDesimal));
                orderFoodTMS=neArray;
                System.out.println("this is new experiment "+ orderFoodTMS);


                orderFoodTable.setItems(FXCollections.observableArrayList(orderFoodTMS));

                System.out.println(orderFoodTMS);
                foodId.getSelectionModel().clearSelection();
                foodName.clear();
                quentityOnHand.clear();
                quentity.clear();

                return;


            }else {
                neArray.add(orderFoodTM);
            }

        }

        orderFoodTMS.clear();
        orderFoodTMS=neArray;

        orderFoodTMS.add(new OrderFoodTM(food.getFoodId(),food.getFoodName(),qty,totalDesimal));

        orderFoodTable.setItems(FXCollections.observableArrayList(orderFoodTMS));

        System.out.println(orderFoodTMS);
        foodId.getSelectionModel().clearSelection();
        foodName.clear();
        quentityOnHand.clear();
        quentity.clear();



    }
}
