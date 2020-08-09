package dao;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrudUtil {

    public static <T> T execute(String sql, Object... parms){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            int i=0;
            for (Object parm : parms) {
                i++;
                preparedStatement.setObject(i,parm);
            }

            if (sql.startsWith("SELECT")){
                return (T) preparedStatement.executeQuery(); //ResultSet
            }
            return (T) ((Boolean)(preparedStatement.executeUpdate()>0)); //Boolean
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
