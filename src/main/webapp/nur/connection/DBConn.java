package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by nur on 27.10.16.
 */
public class DBConn {

    /**
     * Connection conn
     */
    private static Connection conn;

    /**
     * Connects to database, and returns the connection
     * @return
     */
    public static Connection getConnection() {
        if( conn != null )
            return conn;

        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/taxi_db";
            String user = "admin";
            String password = "mysqladmin";
            Class.forName( driver );
            conn = DriverManager.getConnection( url, user, password );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    /**
     * Closes the connection
     * @param toBeClosed
     */
    public static void closeConnection( Connection toBeClosed ) {
        if( toBeClosed == null )
            return;
        try {
            toBeClosed.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try{
                if(toBeClosed!=null)
                    toBeClosed.close();
            }catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end finally
    }

}