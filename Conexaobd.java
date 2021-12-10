
import java.sql.*;

public class Conexaobd{
    protected Connection connection;
    
    public Conexaobd(){
        this.connection = null;
    }
    private void setConnection (Connection connection){
        this.connection = connection;
    }
    public Connection getConnection(){
        return this.connection;
    }
    
    public boolean openconnection(){
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:hospital.db");
            this.setConnection(connection);
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    public boolean closeconnection(){
        try{
            if(this.getConnection() != null)
                this.getConnection().close();
                return true;
            
        }catch(SQLException e){
            return false;
        }
        
    }
}
    

