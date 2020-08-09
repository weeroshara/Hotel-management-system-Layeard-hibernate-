package control;

import business.BOFactory;
import business.BOType;
import business.custom.BookingRoomBo;
import business.custom.CustomerBO;
import business.custom.RoomBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.sun.org.apache.bcel.internal.ExceptionConst;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.CustomerDAO;
import dao.custom.RoomDAO;
import entity.Customer;
import entity.Room;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.BookRoomTM;
import util.CustomerTM;
import util.RoomTM;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingRoomsControl {

    public AnchorPane root;
    public JFXButton saveButton;
    public JFXButton deletButton;
    public Button placeBookRoomButton;
    public JFXButton addNewButton;
    public JFXTextField date;
    public JFXComboBox<String> customerIdComboBox;
    public JFXComboBox<String> roomIdComboBox;
    public JFXTextField customerName;
    public CheckBox acOrNot;
    public JFXTextField noOFMembors;
    public JFXTextField price;
    public List<BookRoomTM> bookRoomTMSArray=new ArrayList<>();
    public TableView<BookRoomTM> bookingRoomTable;

    public List<String> acRooms=new ArrayList<>();
    public List<String> nonAcRooms=new ArrayList<>();

    private CustomerBO customerBO=BOFactory.getInstance().getBo(BOType.CUSTOMER);
    private BookingRoomBo bookingRoomBo=BOFactory.getInstance().getBo(BOType.BOOKINGROOM);
    private RoomBO roomBO=BOFactory.getInstance().getBo(BOType.ROOM);

    public void navigateHomeOnAction(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/DashboardView.fxml"));
        Stage stage=(Stage) (this.root.getScene().getWindow());
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void navigateCustomerManageForm(MouseEvent mouseEvent) throws Exception{
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/ManageCustomerView.fxml"));
        Stage stage=(Stage) (this.root.getScene().getWindow());
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void navigateOrderFoodForm(MouseEvent mouseEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/OrderFoodsView.fxml"));
        Stage stage=(Stage) (this.root.getScene().getWindow());
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize() throws Exception {
        bookingRoomTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("roomId"));
        bookingRoomTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("price"));
        bookingRoomTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("category"));

        customerIdComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue==null){
                    return;
                }
                try {
                    CustomerTM customer = customerBO.getCustomer(newValue);
                    customerName.setText(customer.getCustomerName());
                    noOFMembors.setText(customer.getOnOfMembors()+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });

        roomIdComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue==null){
                    return;
                }
                RoomTM room = null;
                try {
                    room = roomBO.findRoom(newValue);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                price.setText(room.getPrice()+"");
            }
        });

        acOrNot.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue){
                if (newValue==null){
                    return;
                }
                System.out.println(newValue);
                try {
                    //loadRooUsingArray();
                    if (newValue==true){
                        roomIdComboBox.setItems(FXCollections.observableArrayList(acRooms));
                    }
                    else {
                        roomIdComboBox.setItems(FXCollections.observableArrayList(nonAcRooms));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                price.setText("");
            }
        });


        loadRooms();
        loadCustomers();
        roomIdComboBox.setItems(FXCollections.observableArrayList(nonAcRooms));

        date.setText(LocalDate.now()+"");

    }

    public void loadCustomers() throws Exception {
        ObservableList<String> items = customerIdComboBox.getItems();
        List<CustomerTM> allCustomers = customerBO.getAllCustomers();
        for (CustomerTM customer : allCustomers) {
            items.add(customer.getCustomerId());
        }
    }

    public void loadRooms() throws Exception{
        System.out.println("is an ac room .."+acOrNot);
        ObservableList<String> items = roomIdComboBox.getItems();
        items.clear();

            List<String> ac_room = bookingRoomBo.acRoomOrNon("AC Room");
            for (String s : ac_room) {
                //items.add(s);
                acRooms.add(s);

            }


            List<String> normal_room = bookingRoomBo.acRoomOrNon("Normal Room");
            for (String s : normal_room) {
                //items.add(s);
                nonAcRooms.add(s);
            }


        System.out.println(acRooms);

    }

    public void addNewButtonOnAction(ActionEvent actionEvent) {
    }

    public void placeBookRoomButtonOnAction(ActionEvent actionEvent) throws Exception {
        String customrId = customerIdComboBox.getValue();
        String text = date.getText();
        Date date = Date.valueOf(text);
        bookingRoomBo.placeRoomOrder(customrId,date,bookRoomTMSArray);
    }

    public void deletButtonOnAction(ActionEvent actionEvent) {
        if (bookingRoomTable.getSelectionModel().isEmpty()){
            return;
        }
        String roomId = bookingRoomTable.getSelectionModel().getSelectedItem().getRoomId();
        List<BookRoomTM> bookRoomTMS=new ArrayList<>();
        for (BookRoomTM bookRoomTM : bookRoomTMSArray) {
            System.out.println("first");
            if (bookRoomTM.getRoomId().equals(roomId)){
                break;
            }
            System.out.println("second");
            bookRoomTMS.add(bookRoomTM);
        }
        bookRoomTMSArray=bookRoomTMS;
        System.out.println(bookRoomTMSArray);

        ObservableList<BookRoomTM> bookRoomTMS1 = FXCollections.observableArrayList(bookRoomTMSArray);
        bookingRoomTable.getItems().clear();
        bookingRoomTable.setItems(bookRoomTMS1);


    }

    public void saveButtonOnAction(ActionEvent actionEvent) throws Exception {
        if (!roomIdComboBox.getSelectionModel().isEmpty()) {
            bookingRoomTable.getItems().clear();

            String selectedItem = roomIdComboBox.getSelectionModel().getSelectedItem();
            RoomTM room = roomBO.findRoom(selectedItem);
            bookRoomTMSArray.add(new BookRoomTM(room.getRoomId(), room.getPrice(), room.getCategory()));
            ObservableList<BookRoomTM> bookRoomTMS = FXCollections.observableArrayList(bookRoomTMSArray);
            bookingRoomTable.setItems(bookRoomTMS);

            roomIdComboBox.getItems().clear();
            List<String> rooms=new ArrayList<>();
            ObservableList<String> roms = FXCollections.observableArrayList(rooms);
            if (room.getCategory().equals("AC Room")){
                for (String acRoom : acRooms) {
                    if (acRoom.equals(room.getRoomId())){
                       // break;
                    }else {
                        rooms.add(acRoom);
                    }

                }
                acRooms=rooms;
                System.out.println(acRooms);
                roomIdComboBox.setItems(roms);
            }else {
                for (String nonAcRoom : nonAcRooms) {
                    if (nonAcRoom.equals(room.getRoomId())){
                        //break;
                    }else {
                        rooms.add(nonAcRoom);
                    }
                }
                nonAcRooms=rooms;
                System.out.println(nonAcRooms);
                roomIdComboBox.setItems(roms);
            }

            price.setText("");
            //roomIdComboBox.getSelectionModel().clearSelection();
            acOrNot.setSelected(false);

        }

    }

    public void loadRooUsingArray() throws Exception {

    }
}
