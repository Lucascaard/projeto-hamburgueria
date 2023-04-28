package principal.controles;

import principal.db.Banco;
import principal.modelos.ItemEstoque;
import principal.modelos.Produto;

public class ControleEstoque {
    

    // public static void adicionar(ItemEstoque item){

    //     Banco.itensEstoque.adicionarItem(item);
    // } comentado para teste

    public static void adicionar(ItemEstoque item){
        Banco.itensEstoque.add(item);
    }


    public static boolean delete(int id){
        boolean estoqueExcluido = false;
        for (ItemEstoque produto : Banco.itensEstoque) {
            if(produto.getId() == id){
                Banco.produtos.remove(produto);
                estoqueExcluido = true;
                break;
            }
        }

        return estoqueExcluido;
    }

    // public static void buscarPorIdEstoque(int idExterno){
    //     for (ItemEstoque produto : Banco.itensEstoque) {
    //         if(produto.getProduto() != null){
    //             ItemEstoque produtoID = produto;
    //         }

    //         break;
    //     }
    // }
}
