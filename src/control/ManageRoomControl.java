package control;

import business.BOFactory;
import business.BOType;
import business.custom.RoomBO;
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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.RoomTM;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class ManageRoomControl {
    public AnchorPane root;
    public JFXTextField roomId;
    public JFXTextField roomPrice;
    public JFXTextField noOfBeds;
    public JFXButton saveRoom;
    public JFXButton deleteButton;
    public CheckBox acOrNot;
    public JFXButton addNewButton;
    public TableView<RoomTM> roomTable;
    public Button homeButton;

    RoomBO roomBO= BOFactory.getInstance().getBo(BOType.ROOM);
    public void initialize() throws Exception{
        roomTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("roomId"));
        roomTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("category"));
        roomTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("price"));
        roomTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("noOfBeds"));

        roomTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<RoomTM>() {
            @Override
            public void changed(ObservableValue<? extends RoomTM> observable, RoomTM oldValue, RoomTM newValue) {
                if (newValue==null){
                    return;
                }
                roomId.setText(newValue.getRoomId());;
                roomPrice.setText(newValue.getPrice()+"");
                noOfBeds.setText(newValue.getNoOfBeds()+"");
                if (newValue.getCategory().equals("AC Room")){
                    acOrNot.setSelected(true);
                }else {
                    acOrNot.setSelected(false);
                }
                saveRoom.setText("_Update");

            }
        });

        loadTable();
    }

    public void loadTable() throws Exception{
        List<RoomTM> allRooms = roomBO.findAllRooms();
        ObservableList<RoomTM> roomTMS = FXCollections.observableArrayList(allRooms);
        roomTable.setItems(roomTMS);
    }

    public void saveRoomButtonOnAction(ActionEvent actionEvent) throws Exception{
        if (roomId.getText().isEmpty() || roomPrice.getText().isEmpty() || noOfBeds.getText().isEmpty()){
            return;
        }
        String id = roomId.getText();
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(roomPrice.getText()));
        int noOFbeds = Integer.parseInt(noOfBeds.getText());
        String category="";
        if (acOrNot.isSelected()){
            category="AC Room";
        }else {
            category = "Normal Room";
        }

        if (saveRoom.getText().equals("_Save")){
            roomBO.saveRooms(id,category,price,noOFbeds);
        }
        roomBO.updateRoom(id,category,price,noOFbeds);

        loadTable();
        saveRoom.setText("_Save");

        roomId.clear();
        roomPrice.clear();
        noOfBeds.clear();
        acOrNot.setSelected(false);
    }

    public void deleteButtonOnAction(ActionEvent actionEvent) throws Exception{
        if (roomTable.getSelectionModel().isEmpty()){
            return;
        }
        roomBO.deleteRoom(roomTable.getSelectionModel().selectedItemProperty().getValue().getRoomId());
        loadTable();
    }

    public void addNewButtonOnAction(ActionEvent actionEvent) throws Exception{
    }

    public void navigateHomeOnAction(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/DashboardView.fxml"));
        Stage stage=(Stage) (this.root.getScene().getWindow());
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
