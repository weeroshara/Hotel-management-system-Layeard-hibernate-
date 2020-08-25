package db;

import entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.File;

public class HibernateUtil {
    private static SessionFactory sessionFactory=buildSesionDfactory();

    private static SessionFactory buildSesionDfactory(){

        File configFile = new File("resource/application.properties");
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .loadProperties(configFile)
                .build();

        Metadata metadata = new MetadataSources( standardRegistry )
                //.addAnnotatedClass( MyEntity.class )
                .addAnnotatedClass(Food.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Room.class)
                .addAnnotatedClass(OrderFood.class)
                .addAnnotatedClass(OrderFoodItem.class)
                .addAnnotatedClass(RoomBookDate.class)


                .getMetadataBuilder()
                .applyImplicitNamingStrategy( ImplicitNamingStrategyJpaCompliantImpl.INSTANCE )
                .build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder()
                .build();

        return sessionFactory;

    }

    public static SessionFactory getSesionFactory(){
        return sessionFactory;
    }
}
//
//package db;
//
//import entity.Customer;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.Metadata;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//
//import java.io.File;
//
//public class HibernateUtil {
//    private static SessionFactory sessionFactory=buildSesionFactory();
//
//    private static SessionFactory buildSesionFactory(){
//
//        File configFile = new File("resource/application.properties");
//
//        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
//                //.configure("hibrnate.cfg.xml")
//                //.loadProperties("application.properties")
//                .loadProperties(configFile)
//                .build();
//
//        Metadata metadata = new MetadataSources( standardRegistry )
////                .addAnnotatedClass(Employee.class)
////                .addAnnotatedClass(Student.class)
//
//
////                .addAnnotatedClassName( "org.hibernate.example.Customer" )
////                .addResource( "org/hibernate/example/Order.hbm.xml" )
////                .addResource( "org/hibernate/example/Product.orm.xml" )
//                .getMetadataBuilder()
//                .applyImplicitNamingStrategy( ImplicitNamingStrategyJpaCompliantImpl.INSTANCE )
//                .build();
//
//        SessionFactory sessionFactory = (SessionFactory) metadata.getSessionFactoryBuilder()
//                .build();
//
//        return sessionFactory;
//
//
//    }
//
//    public static SessionFactory getSessionFactory(){
//        return sessionFactory;
//    }
//}