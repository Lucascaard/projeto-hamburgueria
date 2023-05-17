package principal.modelos.DAO;
import java.sql.SQLException;
import java.sql.*;
import principal.*;
public class ClienteDAO {

    private Connection con;

    public void conectar() {
        String url = "jdbc:mysql://localhost:3306/exemplojdbc";
        String usuario = "root";
        String senha = "positivo";

        try {
            con = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*No bloco catch, o código e.printStackTrace(); imprime o rastreamento da pilha (stack trace) da exceção que ocorreu. Isso pode ajudar a identificar a causa do erro ao exibir informações sobre o local e a sequência de chamadas que levaram à exceção. */
    }

    public void create(){
        
    }



















}
