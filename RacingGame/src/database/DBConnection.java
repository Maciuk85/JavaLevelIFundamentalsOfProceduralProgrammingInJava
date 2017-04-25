package database;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import org.apache.commons.dbcp.BasicDataSource;
import org.flywaydb.core.Flyway;
 
public class DBConnection {
       
        private static final String DRIVER = "org.sqlite.JDBC";
        private static final String JDBC_PATH = "jdbc:sqlite:resources/db/";
        private static final String DB_NAME = "racingGameDB.db";
        private static final String USERNAME="";
        private static final String PASSWORD="";
       
        private static final DBConnection INSTANCE = new DBConnection();
       
        private BasicDataSource dataSource;
       
        private DBConnection(){
               
        }
       
        public static DBConnection getInstance(){
                return DBConnection.INSTANCE;
        }
       
        public void init(){
                dataSource = new BasicDataSource();
                dataSource.setDriverClassName(DRIVER);
                dataSource.setUrl(JDBC_PATH + DB_NAME);
                dataSource.setUsername(USERNAME);
                dataSource.setUsername(PASSWORD);
            final Flyway flyway = new Flyway();
            flyway.setDataSource(dataSource);
            flyway.clean();
            flyway.migrate();
        }
       
        public static void close(Connection connection, PreparedStatement preparedStatement) {
                try {
                        if (connection != null) {
                                connection.close();
                        }
 
                        if (preparedStatement != null) {
                                preparedStatement.close();
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
       
        public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
                try {
                        if (connection != null) {
                                connection.close();
                        }
 
                        if (preparedStatement != null) {
                                preparedStatement.close();
                        }
 
                        if (resultSet != null) {
                                resultSet.close();
                        }                      
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
 
         public static Connection getConnection() throws SQLException {
                    return DBConnection.getInstance().getDataSource().getConnection();
        }
         
          public void close() {
                    if (dataSource != null) {
                      try {
                        dataSource.close();
                      } catch (final SQLException e) {
                          e.printStackTrace();
                      }
                    }
                  }
         
        //Thread will be close automatically data source
        public void registerShutdownHook() {
                    Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
                      @Override
                      public void run() {
                        close();
                      }
                    }));
                  }
       
        public BasicDataSource getDataSource() {
                return dataSource;
        }
 
        public void setDataSource(BasicDataSource dataSource) {
                this.dataSource = dataSource;
        }
       
}
 