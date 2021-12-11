import java.sql.*;
public class Consulta extends Conexaobd{
    private int idpaciente;
    private int idmedico;
    private int codconsulta;
    public Consulta(int p,int m){
        this.idpaciente = p;
        this.idmedico = m;
    }
    public int getidpaciente(){
        return this.idpaciente;
    }
    public int getidmedico(){
        return this.idmedico;
    }
    public int getcodconsulta(){
        return this.codconsulta;
    }
    public void setidpaciente(int id){
        this.idpaciente = id;
    }
    public void setidmedico(int id){
        this.idmedico = id;
    }
    public void setcodconsulta(int cod){
        this.codconsulta = cod;
    }
    public boolean insertPaciente(){
        try{
            Statement statement = this.connection.createStatement();
            statement.executeUpdate("INSERT INTO Consulta (idPaciente, idMedico) VALUES("+this.idpaciente+","+this.idmedico+")");
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }
}
