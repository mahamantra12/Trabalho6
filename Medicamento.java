import java.sql.*;
public class Medicamento extends Conexaobd{
    private String nome;
    public Medicamento(String nome){
        this.nome = nome;
    }
    public void setnome(String nome){
        this.nome = nome;
    }
    public String getnome(){
        return this.nome;
    }
    public boolean insertMedicamento(){
        try{
            Statement statement = this.connection.createStatement();
            statement.executeUpdate("INSERT INTO Medicamento(nomeMedicamento) VALUES('"+this.nome+"')");
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    public boolean deleteMedicamento(int cod){
        try{
            Statement statement = this.connection.createStatement();
            statement.executeUpdate("DELETE FROM Medicamento WHERE codMedicamento = "+cod);
            return true;
        }catch(SQLException e){
            return false;
        }        
    }
        public boolean updatePaciente(int cod,String nome){
        try{
            Statement statement = this.connection.createStatement();
            statement.executeUpdate("UPDATE Medicamento SET nomeMedicamento = '"+nome+"' WHERE codMedicamento = "+cod);
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }  
    }
    public boolean selectPaciente(int cod){
        try{
            Statement statement = this.connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Medicamento WHERE codMedicamento = "+cod);
            while(rs.next()){
                Integer codigo = rs.getInt("codMedicamento");
                String nome = rs.getString("nomeMedicamento");
                System.out.println(codigo+" - "+nome);
            }
            return true;
        }catch(SQLException e){
            return false;
        }
    }

}
