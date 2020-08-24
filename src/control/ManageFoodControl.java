package control;

import business.BOFactory;
import business.BOType;
import business.SuperBO;
import business.custom.FoodBO;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.FoodTM;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class ManageFoodControl {
    public AnchorPane root;
    public JFXButton saveButton;
    public JFXButton deletButton;
    public TableView<FoodTM> foodTable;
    public JFXButton addNewButton;
    public JFXTextField foodId;
    public JFXTextField foodName;
    public JFXTextField unitPrice;
    public JFXTextField quentityOnHand;

    public   FoodBO foodBO = BOFactory.getInstance().getBo(BOType.FOOD);
    public void initialize() throws Exception{

        foodTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("foodId"));
        foodTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("foodName"));
        foodTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("price"));
        foodTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("quentityOnHand"));

        foodTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<FoodTM>() {
            @Override
            public void changed(ObservableValue<? extends FoodTM> observable, FoodTM oldValue, FoodTM newValue) {
                if (newValue==null){
                    return;
                }
                foodId.setText(newValue.getFoodId());
                foodName.setText(newValue.getFoodName());
                unitPrice.setText(newValue.getPrice()+"");
                quentityOnHand.setText(newValue.getQuentityOnHand()+"");
                saveButton.setText("_Update");
            }
        });

        loadTable();
    }

    public void loadTable() throws Exception{
        List<FoodTM> foodTM = foodBO.allFoods();
        ObservableList<FoodTM> foodTMS = FXCollections.observableArrayList(foodTM);
        foodTable.setItems(foodTMS);
    }

    public void navigateHomeOnAction(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/DashboardView.fxml"));
        Stage stage=(Stage) (this.root.getScene().getWindow());
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addNewButtonOnAction(ActionEvent actionEvent) throws Exception{

    }

    public void deletButtonOnAction(ActionEvent actionEvent) throws Exception{
        if (foodTable.getSelectionModel().isEmpty()){
            return;
        }
        String foodId = foodTable.getSelectionModel().getSelectedItem().getFoodId();
        foodBO.deletFood(foodId);
        loadTable();
    }

    public void saveButtonOnAction(ActionEvent actionEvent) throws Exception{
        if (foodId.getText().isEmpty() || foodName.getText().isEmpty() || unitPrice.getText().isEmpty() || quentityOnHand.getText().isEmpty()){
            return;
        }
        String Id = foodId.getText();
        String Name = foodName.getText();
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(unitPrice.getText()));
        int quentity = Integer.parseInt(quentityOnHand.getText());

        if (saveButton.getText().equals("_Save")){
            foodBO.saveFood(Id,Name,price,quentity);
        }
        foodBO.updateFoods(Id,Name,price,quentity);
        loadTable();
        saveButton.setText("_Save");

        foodId.clear();
        foodName.clear();
        unitPrice.clear();
        quentityOnHand.clear();

    }

}
