package control;

import com.jfoenix.controls.JFXButton;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardControl {

    public JFXButton _manageCustomerButton;
    public JFXButton manageRoomButton;
    public JFXButton manageFoodsButton;
    public JFXButton bookingRooms;
    public JFXButton orderFoods;
    public JFXButton manageParck;
    public AnchorPane root;


    public void manageCustomerButtonOnAcion(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/ManageCustomerView.fxml"));
        Stage stage=(Stage) (this.root.getScene().getWindow());
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void manageRoomButtonOnAction(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/ManageRoomView.fxml"));
        Stage stage=(Stage) (this.root.getScene().getWindow());
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void manageFoodsButtonOnAction(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/ManageFoodView.fxml"));
        Stage stage=(Stage) (this.root.getScene().getWindow());
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void bookingRoomsOnAction(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/BookingRoomsView.fxml"));
        Stage stage=(Stage) (this.root.getScene().getWindow());
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void orderFoodsOnAction(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/OrderFoodsView.fxml"));
        Stage stage=(Stage) (this.root.getScene().getWindow());
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void manageParckOnAction(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/ManageParkView.fxml"));
        Stage stage=(Stage) (this.root.getScene().getWindow());
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
