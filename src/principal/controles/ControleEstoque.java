package principal.controles;

import principal.db.Banco;
import principal.modelos.Estoque;

public class ControleEstoque {
    
    public static void adicionar(Estoque estoque){
        Banco.produEstoques.add(estoque);
    }

}
