package principal.telas;

import principal.util.Mensagem;
import principal.util.Prompt;
import principal.controles.ControleEstoque;
import principal.controles.ControleProduto;
import principal.db.Banco;
import principal.modelos.ItemEstoque;
import principal.modelos.Produto;


/*
 * @version 1.0 Abr 2023
 * @author Vinícius Cordeiro Nocera
 */

public class TelaEstoque {

    public static void mostrar(){

        Prompt.linhaEmBranco();
        Prompt.separador();
        Prompt.imprimir(Mensagem.MENU_ESTOQUE);
        Prompt.separador();
        Prompt.linhaEmBranco();
        Prompt.imprimir("[1] - " + Mensagem.CREATE);
        Prompt.imprimir("[2] - " + Mensagem.READ);
        Prompt.imprimir("[3] - " + Mensagem.UPDATE);
        Prompt.imprimir("[4] - " + Mensagem.DELETE);
        Prompt.imprimir("[5] - " + Mensagem.VOLTAR);
        Integer opcao = Prompt.lerInteiro();

            switch (opcao) {
                case 1:
                    TelaEstoque.create();
                    break;
                case 2:
                    TelaEstoque.read();
                    break;
                case 3:
                    TelaEstoque.update();
                    break;
                case 4:
                    TelaEstoque.delete();
                    break;
                case 5:
                    TelaPrincipal.mostrar();
                    break;
                default:
                    Prompt.imprimir(Mensagem.OPCAO_INVALIDA);
                    TelaPrincipal.mostrar();
                    break;
            }


    }

    public static void create(){

        //Lendo e guardando dados em variáveis
        Prompt.linhaEmBranco();
        Prompt.separador();
        Prompt.imprimir(Mensagem.MSG_CADASTRO_ESTOQUE);
        Prompt.separador();
        Integer idProduto = Prompt.lerInteiro(Mensagem.INFORME_ID);
        boolean control = false;

        for (ItemEstoque item : Banco.itensEstoque) {
            if(item.getId() != idProduto){
                control = true;
            }    
        }

        if(control == true){

            if(idProduto != null) {
                
                
                Produto produto = ControleProduto.buscarPorId(idProduto);
                
                if(produto == null){
                    Prompt.imprimir(Mensagem.ID_INVALIDA);
                } else {
                    Integer qtde = Prompt.lerInteiro(Mensagem.INFORME_QUANTIDADE);
                    ItemEstoque item = new ItemEstoque();
                    item.setId(idProduto);
                    item.setProduto(produto);
                    item.setQtde(qtde);
            
                    ControleEstoque.adicionar(item);
    
                    Prompt.imprimir(Mensagem.PRODUTO_CADASTRADO_ESTOQUE);
                } 
                    
    
                    // ItemEstoque item = new ItemEstoque();
                    // item.setProduto(produto);
                    // item.setQtde(qtde);
            
                    // ControleEstoque.adicionar(item);
                    //comentado pra teste
            }
        } else {
            Prompt.imprimir(Mensagem.PRODUTO_EXISTENTE_ESTOQUE);
        }

        Prompt.linhaEmBranco();
        Prompt.pressionarEnter();
		TelaEstoque.mostrar();

    }


    public static void read(){

        Prompt.linhaEmBranco();
        Prompt.separador();
        Prompt.imprimir(Mensagem.LISTA_ESTOQUE);
        Prompt.separador();

        Prompt.linhaEmBranco();

        if(Banco.itensEstoque.isEmpty()){

            Prompt.imprimir(Mensagem.ESTOQUE_VAZIO);
        } else {

            for (ItemEstoque produto : Banco.itensEstoque) {
                 String info = "Produto: " + produto.getProduto().getNome() + "\n"
                             + "Quantidade: " + produto.getQtde() + "\n";

                Prompt.imprimir(info);
            }
        }

        Prompt.linhaEmBranco();
		Prompt.pressionarEnter();
		TelaEstoque.mostrar();
    }

    public static void update(){

        Prompt.linhaEmBranco();
        Prompt.separador();
        Prompt.imprimir(Mensagem.UPDATE_ESTOQUE);
        Prompt.separador();
        Integer idProduto = Prompt.lerInteiro(Mensagem.INFORME_ID);

        if(idProduto != null){

            Produto produtoAlterado = ControleProduto.buscarPorId(idProduto);

            if(produtoAlterado != null){
                Integer qtde = Prompt.lerInteiro(Mensagem.QTDE_ESTOQUE);

                ItemEstoque item = new ItemEstoque();
                item.setProduto(produtoAlterado);
                item.setQtde(qtde);

                ControleEstoque.adicionar(item);

                Prompt.linhaEmBranco();
				Prompt.imprimir(Mensagem.ESTOQUE_ALTERADO);
            } else {
                Prompt.linhaEmBranco();
				Prompt.imprimir(Mensagem.PRODUTO_NAO_ENCONTRADO);
            }
        }

        Prompt.linhaEmBranco();
		Prompt.pressionarEnter();
		TelaEstoque.mostrar();

    }

    public static void delete(){

        Prompt.linhaEmBranco();
        Prompt.separador();
        Prompt.imprimir(Mensagem.EXCLUIR_ESTOQUE);
        Prompt.separador();
        Integer idProduto = Prompt.lerInteiro(Mensagem.INFORME_ID_EXCLUIR_ESTOQUE);

        if(idProduto != null){
            boolean estoqueExcluido = ControleEstoque.delete(idProduto);
			Prompt.linhaEmBranco();
			if(estoqueExcluido) {
				Prompt.imprimir(Mensagem.ESTOQUE_EXCLUIDO);
			} else {
				Prompt.imprimir(Mensagem.PRODUTO_NAO_ENCONTRADO);
			}

		Prompt.linhaEmBranco();
		Prompt.pressionarEnter();

        }

        TelaEstoque.mostrar();
    }

}

