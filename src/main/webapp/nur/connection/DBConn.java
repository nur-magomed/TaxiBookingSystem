package connection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by nur on 27.10.16.
 */
public class DBConn {
    private static final Logger log = LoggerFactory.getLogger(DBConn.class);

    /**
     * Connection conn
     */
    private static Connection conn;

    /**
     * Connects to database, and returns the connection
     * @return
     */
    public static Connection getConnection() {
        if( conn != null ) {
            return conn;
        }
        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/taxi_db";
            String user = "admin";
            String password = "mysqladmin";
            Class.forName(driver);
            conn = DriverManager.getConnection( url, user, password );
        } catch (ClassNotFoundException e) {
            log.error("Exception: "+ e);
            e.printStackTrace();
        } catch (SQLException e) {
            log.error("SQL Exception: "+ e);
            e.printStackTrace();
        }

        log.info("Database connection is created");
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
            log.info("Database connection is closed");
        } catch (SQLException e) {
            log.error("SQL Exception: "+ e);
            e.printStackTrace();
        } finally{
            try{
                if(toBeClosed!=null)
                    toBeClosed.close();
                log.warn("Database connection is closed in 'fanally'");
            }catch(SQLException se){
                log.error("SQL Exception: "+ se);
                se.printStackTrace();
            } //end finally try
        } //end finally
    }

}