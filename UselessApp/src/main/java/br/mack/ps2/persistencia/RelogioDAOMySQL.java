package br.mack.ps2.persistencia;
import br.mack.ps2.entidades.Relogio;
import java.sql.*;
import java.util.*;
public class RelogioDAOMySQL implements RelogioDAO{
    private String createSQL = "INSERT INTO relogio VALUES(?,?)";
    private String readSQL = "SELECT * FROM relogio";
    private String deleteSQL = "DELETE INTO relogio VALUES(?,?)";

    private final MySQLConnection mysql = new MySQLConnection();

    @Override
    public boolean create(Relogio relogio) {
        Connection conn = mysql.getConnection();
        try{
            PreparedStatement stm = conn.prepareStatement(createSQL);
            //Inicializando os valores
            stm.setString(1,relogio.getNome());
            stm.setInt(2,relogio.getHora());

            int registros = stm.executeUpdate();

            //se a qtde de registros for >1, significa q os dados foram inseridos direito
            return (registros>0);


        }catch (final SQLException er){
            System.out.println("Falha na conexão com o Banco de Dados!");
            er.printStackTrace();
        }catch (final Exception er){
            er.printStackTrace();
        }finally {
            try{
                conn.close();
            }catch (final Exception er){
                er.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Relogio> read() {
        Connection conn = mysql.getConnection();
        List<Relogio> relogios = new ArrayList<>();
        try{
            PreparedStatement stm = conn.prepareStatement(readSQL);
            ResultSet rs = stm.executeQuery();

            while (rs.next()){
                Relogio relogio = new Relogio();
                relogio.setNome(rs.getString("nome"));
                relogio.setHora(rs.getInt("hora"));
                relogios.add(relogio);
            }
        }catch (final SQLException er){
            System.out.println("Falha na conexão com o Banco de Dados!");
            er.printStackTrace();
        }catch (final Exception er){
            er.printStackTrace();
        }finally {
            try{
                conn.close();
            }catch (final Exception er){
                er.printStackTrace();
            }
        }
        return relogios;
    }

    @Override
    public boolean delete(Relogio relogio) {
        Connection conn = mysql.getConnection();
        try{
            PreparedStatement stm = conn.prepareStatement(deleteSQL);
            //Inicializando os valores
            stm.setString(1, relogio.getNome());

            int registros = stm.executeUpdate();
            return (registros>0);

        }catch (final SQLException er){
            System.out.println("Falha na conexão com o Banco de Dados");
            er.printStackTrace();
        }catch (final Exception er){
            er.printStackTrace();
        }finally {
            try{
                conn.close();
            }catch (final Exception er){
                er.printStackTrace();
            }
        }
        return false;
    }
}
