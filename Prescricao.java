import java.sql.*;
public class Prescricao extends Conexaobd{
    private int codconsulta;
    private int codmedicamento;
    private String posologia;
    public Prescricao(int c,int m,String p){
        this.codconsulta = c;
        this.codmedicamento = m;
        this.posologia = p;
    }
    public int getcodconsulta(){
        return this.codconsulta;
    }
    public int getidmedico(){
        return this.codmedicamento;
    }
    public String getposologia(){
        return this.posologia;
    }
    public void setcodconsulta(int c){
        this.codconsulta = c;
    }
    public void setidmedico(int m){
        this.codmedicamento = m;
    }
    public void setposologia(String p){
        this.posologia = p;
    }
    public boolean insertPrescricao(){
        try{
            Statement statement = this.connection.createStatement();
            statement.executeUpdate("INSERT INTO Prescricao(codMedicamento,codConsulta,Posologia) VALUES("+this.codmedicamento+","+this.codconsulta+",'"+this.posologia+"')");
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    public boolean deletePrescricaoC(int cod){ // deleta toda prescrição de uma consulta
        try{
            Statement statement = this.connection.createStatement();
            statement.executeUpdate("DELETE FROM Prescricao WHERE codConsulta = "+cod);
            return true;
        }catch(SQLException e){
            return false;
        }        
    }
    public boolean deletePrescricaoM(int codm,int codc){ // deleta determinado medicamento de uma consulta
        try{
            Statement statement = this.connection.createStatement();
            statement.executeUpdate("DELETE FROM Prescricao WHERE codMedicamento = "+codm+" AND codConsulta = "+codc);
            return true;
        }catch(SQLException e){
            return false;
        }        
    }
        public boolean updatePrescricao(int codm,int codc,String p){ // Altera a prescrição de um determinado medicamento e de uma determinada consulta
        try{
            Statement statement = this.connection.createStatement();
            statement.executeUpdate("UPDATE Prescricao SET Posologia = '"+p+"' WHERE codConsulta = "+codc+" AND codMedicamento = "+codm);
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }  
    }
    public boolean selectPrescricao(int cod){
        try{
            Statement statement = this.connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Prescricao WHERE codConsulta = "+cod);
            while(rs.next()){
                Integer codigoc = rs.getInt("codConsulta");
                Integer codigom = rs.getInt("codMedicamento");
                String nome = rs.getString("Posologia");
                System.out.println(codigoc+" - "+codigom+" - "+nome);
            }
            return true;
        }catch(SQLException e){
            return false;
        }
    }
}
