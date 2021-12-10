
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexaobd{
    private Conexaobd conexao;
    
    public Conexaobd(){
        this.conexao = null;
    }
    private void setConexaobd (Conexaobd conexao){
        this.conexao = conexao;
    }
    public Conexaobd getConexaobd(){
        return this.conexao;
    }
    
    public boolean openconexao(){
        try{
            conexao = DriverManager.getConexaobd("jdbc:sqlite:/hospital.db");
            this.setConexaobd(conexao);
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    public boolean closeconexao(){
        try{
            if(this.getConexaobd() != null){
                this.getConexaobd().close();
                return true;
            }
        }catch(SQLException e){
            return false;
        }
    }
    }
    

