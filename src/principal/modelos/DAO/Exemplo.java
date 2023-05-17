package principal.modelos.DAO;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import principal.modelos.*;;

public class Exemplo {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        //cliente.setId(1);
        cliente.setNome("João");
        cliente.setEmail("joao@example.com");

        String url = "jdbc:mysql://localhost:3306/exemplojdbc";
        String usuario = "root";
        String senha = "positivo";

        try (Connection con = DriverManager.getConnection(url, usuario, senha)) {
            String tableName = "clientes";
            String sql = generateInsertStatement(tableName, cliente);
            PreparedStatement statement = con.prepareStatement(sql);
            setStatementParameters(statement, cliente);

            int linhasAfetadas = statement.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Inserção realizada com sucesso!");
            } else {
                System.out.println("Falha ao inserir o cliente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String generateInsertStatement(String tableName, Object object) {
        StringBuilder sql = new StringBuilder("INSERT INTO ");
        sql.append(tableName).append(" (");

        Field[] fields = object.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            sql.append(field.getName());

            if (i < fields.length - 1) {
                sql.append(", ");
            }
        }

        sql.append(") VALUES (");
        for (int i = 0; i < fields.length; i++) {
            sql.append("?");

            if (i < fields.length - 1) {
                sql.append(", ");
            }
        }

        sql.append(")");
        return sql.toString();
    }

    private static void setStatementParameters(PreparedStatement statement, Object object) throws SQLException {
        Field[] fields = object.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            try {
                Object value = field.get(object);
                statement.setObject(i + 1, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
