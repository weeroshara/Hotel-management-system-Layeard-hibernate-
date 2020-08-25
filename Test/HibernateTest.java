import business.custom.impl.CustomerBOImpl;
import com.mysql.cj.conf.RuntimeProperty;
import com.sun.org.apache.bcel.internal.generic.NEW;
import dao.custom.impl.CustomerDAOImpl;
import dao.custom.impl.FoodDAOImpl;
import dao.custom.impl.RoomDAOImpl;
import db.HibernateUtil;
import entity.Customer;
import entity.Food;
import entity.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateTest {
    public static void main(String[] args) throws Exception {
        Session session = HibernateUtil.getSesionFactory().openSession();
        Transaction transaction = session.beginTransaction();



//        List<Room> ac_room = session.createNativeQuery("SELECT *FROM Room r WHERE category=?1 AND isBook=?2", Room.class)
//                .setParameter(1, "AC Room")
//                .setParameter(2, 0).list();
//        for (Room room : ac_room) {
//            System.out.println(room.getRoomId());
//        }



//        List<Room> rooms = roomDAO.acRoom("AC Room");
//
//        for (Room room : rooms) {
//            System.out.println(room);
//        }


        transaction.commit();
        session.close();
    }
}
