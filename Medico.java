import java.sql.*;
public class Medico extends Conexaobd{
    private String nome;
    public Medico(String nome){
        this.nome = nome;
    }
    public void setnome(String nome){
        this.nome = nome;
    }
    public String getnome(){
        return this.nome;
    }
    public boolean insertMedico(){
        try{
            Statement statement = this.connection.createStatement();
            statement.executeUpdate("INSERT INTO Medico VALUES('"+this.nome+"')");
            return true;
        }catch(SQLException e){
            return false;
            }
    }
    public boolean deleteMedico(int id){
        try{
            Statement statement = this.connection.createStatement();
            statement.executeUpdate("DELETE FROM Medico WHERE idMedico = "+id);
            return true;
        }catch(SQLException e){
            return false;
            }        
    }
}
    