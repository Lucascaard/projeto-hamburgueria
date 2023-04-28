package principal.controles;

import principal.db.Banco;
import principal.modelos.Produto;

import java.util.List;

public class ControleProduto {
	
	public static void adicionar(Produto produto){
        Banco.produtos.add(produto);
    }


    public static List<Produto> listar(){
        return Banco.produtos;
    }

    public static Produto buscarPorId(int idExterno){
        for (Produto produto : Banco.produtos) {
            if(produto.getId() == idExterno){
                return produto;
            }
        }

        return null;
    }
}
