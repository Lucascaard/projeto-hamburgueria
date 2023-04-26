package principal.controles;

import principal.db.Banco;
import principal.modelos.Produto;

public class ControleProduto {
	
	public static void adicionar(Produto produto){
        Banco.produtos.add(produto);
    }

}
