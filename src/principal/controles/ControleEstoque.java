package principal.controles;

import principal.db.Banco;
import principal.modelos.ItemEstoque;

public class ControleEstoque {
    

    public static void adicionar(ItemEstoque item){

        Banco.estoque.adicionarItem(item);
    }

}
