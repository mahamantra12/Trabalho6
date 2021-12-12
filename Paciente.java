import java.sql.*;
public class Paciente extends Conexaobd{
    private String nome;
    public Paciente(String nome){
        this.nome = nome;
    }
    public void setnome(String nome){
        this.nome = nome;
    }
    public String getnome(){
        return this.nome;
    }

    public boolean insertPaciente(){
        try{
            Statement statement = this.connection.createStatement();
            statement.executeUpdate("INSERT INTO Paciente (nomePaciente) VALUES('"+this.nome+"')");
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }
    public boolean deletePaciente(int id){
        try{
            Statement statement = this.connection.createStatement();
            statement.executeUpdate("DELETE FROM Paciente WHERE idPaciente = "+id);
            return true;
        }catch(SQLException e){
            return false;
        }       
    }
    public boolean updatePaciente(int id,String nome){
        try{
            Statement statement = this.connection.createStatement();
            statement.executeUpdate("UPDATE Paciente SET nomePaciente = '"+nome+"' WHERE idPaciente = "+id);
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }  
    }
    public boolean selectPaciente(int id){
        try{
            Statement statement = this.connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Paciente WHERE idPaciente = "+id);
            while(rs.next()){
                Integer idPaciente = rs.getInt("idPaciente");
                String nome = rs.getString("nomePaciente");
                System.out.println(id+" - "+nome);
            }
            return true;
        }catch(SQLException e){
            return false;
        }
    }
        public boolean selectLike(String like){ 
            // método pra ultima questão com sucesso consegue mostrar todos elementos que possuem a determinada String.
        try{
            Statement statement = this.connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Paciente WHERE nomePaciente LIKE '%"+like+"%'");
            System.out.println("Nomes que possuem "+like+":");
            while(rs.next()){
                Integer idPaciente = rs.getInt("idPaciente");
                String nome = rs.getString("nomePaciente");
                System.out.println(idPaciente+" - "+nome);
            }
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    public boolean insertpacientes(Paciente[] x){ 
        // creio que aqui ele faz a inserção do vetor inteito no banco de dado
        // independente do tamanho do vetor porém para no primeiro erro de inserção e printa o erro.
        for(Paciente i:x){
            if(i != null){
                        try{
                            Statement statement = this.connection.createStatement();
                            statement.executeUpdate("INSERT INTO Paciente (nomePaciente) VALUES('"+i.nome+"')");
                            }catch(SQLException e){
                            System.out.println(e);
                            return false;
                        }
                }  
        }
        return true;
    }
}
