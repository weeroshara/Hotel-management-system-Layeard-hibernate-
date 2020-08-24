import db.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateTest {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSesionFactory().openSession();
        Transaction transaction = session.beginTransaction();
//
//        //System.out.println(session);
//
        transaction.commit();
        session.close();
    }
}
