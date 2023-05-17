package principal;

import java.sql.SQLException;
import principal.db.Banco;
import principal.telas.TelaLogin;
public class Programa {
		public static void main(String[] args) throws SQLException {

			Banco.inserindoDados();
			TelaLogin.mostrar();
		}
}