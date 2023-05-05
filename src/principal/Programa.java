package principal;
import javax.sql.rowset.spi.SyncResolver;

import principal.db.Banco;
import principal.telas.TelaLogin;
public class Programa {
		public static void main(String[] args)  {

			Banco.inserindoDados();
			TelaLogin.mostrar();
		}
		   wddwd
}