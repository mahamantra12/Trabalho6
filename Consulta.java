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
    public boolean insertConsulta(){
        try{
            Statement statement = this.connection.createStatement();
            statement.executeUpdate("INSERT INTO Consulta (idPaciente, idMedico) VALUES("+this.idpaciente+","+this.idmedico+")");
            ResultSet rs = statement.executeQuery("SELECT * FROM Consulta WHERE idPaciente = "+idpaciente+" AND idMedico = "+idmedico);
            while(rs.next()){ 
                /* Aqui eu criei pra receber o valor de consulta do insert e adicionar no objeto ja que 
                nao conseguiria ter esse valor diretamente porque ele é autoincremento.
                Mas noto que se existir uma segunda consulta de um mesmo paciente o codigo peca em receber o codConsulta
                pegando a ultima consulta do paciente ja que é um while.*/
                this.codconsulta = rs.getInt("codConsulta");
            }
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }
    public boolean deleteConsulta(int cod){ // deleta uma consulta por completo
        try{
            Statement statement = this.connection.createStatement();
            statement.executeUpdate("DELETE FROM Consulta WHERE codConsulta = "+cod);
            return true;
        }catch(SQLException e){
            return false;
        }        
    }
    public boolean updateConsultaM(int cod,int med){ // altera o medico de uma determinada consulta
        try{
            Statement statement = this.connection.createStatement();
            statement.executeUpdate("UPDATE Consulta SET idMedico = "+med+" WHERE codConsulta = "+cod);
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }  
    }
    public boolean selectConsulta(int cod){
        try{
            Statement statement = this.connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Consulta WHERE codConsulta = "+cod);
            while(rs.next()){
                Integer medico = rs.getInt("idMedico");
                Integer paciente = rs.getInt("idPaciente");
                Integer consulta = rs.getInt("codConsulta");
                System.out.println(paciente+" - "+medico+" - "+consulta);
            }
            return true;
        }catch(SQLException e){
            return false;
        }
    }
}
