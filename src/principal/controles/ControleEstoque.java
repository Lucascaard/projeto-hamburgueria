package principal.controles;

import principal.db.Banco;
import principal.modelos.ItemEstoque;
import principal.modelos.Produto;

public class ControleEstoque {

    public static void adicionar(ItemEstoque item){
        Banco.itensEstoque.add(item);
    }

    public static boolean delete(int id){
        boolean produtoExcluido = false;
        for (ItemEstoque produto : Banco.itensEstoque) {
            if(produto.getId() == id){
                Banco.itensEstoque.remove(produto);
                produtoExcluido = true;
                break;
            }
        }
        return produtoExcluido;
    }

    public static boolean produtoExiste(int idProduto){
        for (ItemEstoque item : Banco.itensEstoque) {
            if(item.getId().equals(idProduto)){
                return true;
            }   
        }
        return false;
    }

    public static void alterarQuantidade(int id, int qtde){
        for (ItemEstoque item : Banco.itensEstoque) {
            if(item.getId() == id){
                item.setQtde(qtde);
            }
        }
    }

    public static ItemEstoque criarProduto(int id, Produto produto, int qtde){
        ItemEstoque item = new ItemEstoque();
                    item.setId(id);
                    item.setProduto(produto);
                    item.setQtde(qtde);

                return item;
    }

}