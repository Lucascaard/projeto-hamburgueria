package principal.controles;

import principal.db.Banco;
import principal.modelos.ItemEstoque;
import principal.modelos.Produto;
import principal.util.Prompt;

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

    public static void listarId(){
        for (Produto produto : Banco.produtos) {
            Prompt.imprimir("ID: " + produto.getId() + "\nProduto: " + produto.getNome() + "\nMarca: " + produto.getMarca() + "\n");
        }
    }

    public static void alterarQuantidade(int id, int qtde){
        for (ItemEstoque item : Banco.itensEstoque) {
            if(item.getId() == id){
                item.setQtde(qtde);
            }
        }
    }


    public static String ListarEstoque(){
        for (ItemEstoque produto : Banco.itensEstoque) {
            String info = "\nID: " + produto.getId() +"\n"
                        + "Produto: " + produto.getProduto().getNome() + "\n"
                        + "Quantidade: " + produto.getQtde();

            return info;
        }

        return null;
    }

    public static void ListarEstoqueEx(){
        for (ItemEstoque produto : Banco.itensEstoque) {
            String info = "\nID: " + produto.getId() +"\n"
                        + "Produto: " + produto.getProduto().getNome() + "\n"
                        + "Quantidade: " + produto.getQtde();

            Prompt.imprimir(info);
        }

    }
}
