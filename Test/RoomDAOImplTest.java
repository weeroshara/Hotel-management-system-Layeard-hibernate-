import dao.DAOFactory;
import dao.DAOType;
import dao.SupperDAO;
import dao.custom.RoomDAO;
import entity.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomDAOImplTest {
    public static void main(String[] args) throws Exception {
        RoomDAO roomDAO = DAOFactory.getInstance().getDAO(DAOType.ROOM);
        List<Room> rooms1 = roomDAO.acRoom("AC Room");

        for (Room room : rooms1) {
            System.out.println(room);
        }


    }
}
