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
        public boolean updatePaciente(int id,String nome){
        try{
            Statement statement = this.connection.createStatement();
            statement.executeUpdate("UPDATE Medico SET nomeMedico = '"+nome+"' WHERE idMedico = "+id);
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }  
    }
    public boolean selectPaciente(int id){
        try{
            Statement statement = this.connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Medico WHERE idMedico = "+id);
            while(rs.next()){
                Integer idMedico = rs.getInt("idMedico");
                String nome = rs.getString("nomeMedico");
                System.out.println(idMedico+" - "+nome);
            }
            return true;
        }catch(SQLException e){
            return false;
        }
    }
}
    