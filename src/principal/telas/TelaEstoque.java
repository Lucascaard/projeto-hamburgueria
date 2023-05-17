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

        if(opcao != null){

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

}

    public static void create(){

        Prompt.linhaEmBranco();
        Prompt.separador();
        Prompt.imprimir(Mensagem.MSG_CADASTRO_ESTOQUE);
        Prompt.separador();

        for (Produto produto : Banco.produtos) {
            Prompt.imprimir(produto);
        }

        Prompt.linhaEmBranco();
        Integer idProduto = Prompt.lerInteiro(Mensagem.INFORME_ID_CADASTRO);

        boolean control = ControleEstoque.produtoExiste(idProduto);

        if(!control){

            if(idProduto != null) {
                
                Produto produto = ControleProduto.buscarPorId(idProduto);
                
                if(produto == null){
                    Prompt.linhaEmBranco();
                    Prompt.imprimir(Mensagem.ID_INVALIDA);
                } else {
                    Integer qtde = Prompt.lerInteiro(Mensagem.INFORME_QUANTIDADE);
                    // ItemEstoque item = new ItemEstoque();
                    // item.setId(idProduto);
                    // item.setProduto(produto);
                    // item.setQtde(qtde);

                    ItemEstoque prod = ControleEstoque.criarProduto(idProduto, produto, qtde);
            
                    ControleEstoque.adicionar(prod);
    
                    Prompt.linhaEmBranco();
                    Prompt.imprimir(Mensagem.PRODUTO_CADASTRADO_ESTOQUE);
                } 
                    
            }
        } else {

            Prompt.linhaEmBranco();
            Prompt.imprimir(Mensagem.PRODUTO_EXISTENTE_ESTOQUE);
        }

        Prompt.linhaEmBranco();
        Prompt.pressionarEnter();
        Prompt.imprimir(Mensagem.CADASTRAR_OUTRO);
        Prompt.separador();
        Prompt.imprimir("[1] - " + Mensagem.SIM);
	    Prompt.imprimir("[2] - " + Mensagem.VOLTAR);
	    Prompt.imprimir("[3] - " + Mensagem.FINALIZAR_PROGRAMA);
        Integer op = Prompt.lerInteiro();

        switch (op) {
            case 1:
                TelaEstoque.create();;
                break;
            case 2:
                TelaEstoque.mostrar();
                break;
            case 3:
                Prompt.imprimir(Mensagem.FINALIZADO);
                break;
            default:
                Prompt.imprimir(Mensagem.OPCAO_INVALIDA);
                TelaEstoque.mostrar();
                break;
        }

    }

    public static void read(){

        Prompt.linhaEmBranco();
        Prompt.separador();
        Prompt.imprimir(Mensagem.LISTA_ESTOQUE);
        Prompt.separador();

        if(Banco.itensEstoque.isEmpty()){
            Prompt.imprimir(Mensagem.ESTOQUE_VAZIO);
        } else {
            for (ItemEstoque item : Banco.itensEstoque) {
                Prompt.imprimir(item);
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

        if(Banco.itensEstoque.isEmpty()){
            Prompt.imprimir(Mensagem.ESTOQUE_VAZIO);
            TelaEstoque.mostrar();
        } else {

            for (ItemEstoque item : Banco.itensEstoque ) {
                Prompt.imprimir(item);
            }
    
            Prompt.linhaEmBranco();
            Integer idProduto = Prompt.lerInteiro(Mensagem.INFORME_ID_ALTERAR);
    
            if(idProduto != null){

                boolean produtoExiste = ControleEstoque.produtoExiste(idProduto);
    
                if(produtoExiste){
    
                    Integer qtde = Prompt.lerInteiro(Mensagem.QTDE_ESTOQUE);
    
                    ControleEstoque.alterarQuantidade(idProduto, qtde);
    
                    Prompt.linhaEmBranco();
                    Prompt.imprimir(Mensagem.ESTOQUE_ALTERADO);
                    Prompt.separador();
                    Prompt.imprimir(Mensagem.ESTOQUE_ATUAL);
                    Prompt.linhaEmBranco();
                    // ControleEstoque.ListarEstoque();
                    for (ItemEstoque item : Banco.itensEstoque) {
                        Prompt.imprimir(item);
                    }

                    Prompt.separador();
                } else {
                    Prompt.linhaEmBranco();
                    Prompt.imprimir(Mensagem.PRODUTO_NAO_ENCONTRADO);
                }
            }
    
        }
        
        Prompt.linhaEmBranco();
        Prompt.pressionarEnter();
        Prompt.imprimir(Mensagem.ALTERAR_OUTRO);
        Prompt.separador();
        Prompt.imprimir("[1] - " + Mensagem.SIM);
        Prompt.imprimir("[2] - " + Mensagem.VOLTAR);
        Prompt.imprimir("[3] - " + Mensagem.FINALIZAR_PROGRAMA);
        Integer op = Prompt.lerInteiro();
        
        switch (op) {
            case 1:
                TelaEstoque.update();;
                break;
            case 2:
                TelaEstoque.mostrar();
                break;
            case 3:
                Prompt.imprimir(Mensagem.FINALIZADO);
                break;
            default:
                Prompt.imprimir(Mensagem.OPCAO_INVALIDA);
                TelaEstoque.mostrar();
                break;
        }

    }

    public static void delete(){

        Prompt.linhaEmBranco();
        Prompt.separador();
        Prompt.imprimir(Mensagem.EXCLUIR_ESTOQUE);
        Prompt.separador();

        if(Banco.itensEstoque.isEmpty()){
            Prompt.imprimir(Mensagem.ESTOQUE_VAZIO);
            TelaEstoque.mostrar();
        } else {

            for (ItemEstoque item : Banco.itensEstoque) {
                Prompt.imprimir(item);
            }

            Prompt.linhaEmBranco();
            Integer idProduto = Prompt.lerInteiro(Mensagem.INFORME_ID_EXCLUIR_ESTOQUE);

            if(idProduto != null){

                boolean estoqueExcluido = ControleEstoque.delete(idProduto);
                Prompt.linhaEmBranco();

                if(estoqueExcluido) {

                    Prompt.separador();
                    Prompt.imprimir(Mensagem.ESTOQUE_EXCLUIDO);
                    Prompt.separador();

                    if(Banco.itensEstoque.isEmpty()){
                        Prompt.imprimir(Mensagem.ESTOQUE_VAZIO);

                    }else{
                        Prompt.imprimir(Mensagem.ESTOQUE_ATUAL);
                        Prompt.linhaEmBranco();

                        for (ItemEstoque item : Banco.itensEstoque) {
                            Prompt.imprimir(item);
                        }
            
                    }

                    Prompt.separador();

                } else {
                    Prompt.imprimir(Mensagem.PRODUTO_NAO_ENCONTRADO);
                }
            }
        }

        Prompt.linhaEmBranco();
        Prompt.pressionarEnter();

        Prompt.imprimir(Mensagem.DELETAR_OUTRO);
        Prompt.separador();
        Prompt.imprimir("[1] - " + Mensagem.SIM);
	    Prompt.imprimir("[2] - " + Mensagem.VOLTAR);
	    Prompt.imprimir("[3] - " + Mensagem.FINALIZAR_PROGRAMA);
        Integer op = Prompt.lerInteiro();

        switch (op) {
            case 1:
                TelaEstoque.delete();
                break;
            case 2:
                TelaEstoque.mostrar();
                break;
            case 3:
                Prompt.imprimir(Mensagem.FINALIZADO);
                break;
            default:
                Prompt.imprimir(Mensagem.OPCAO_INVALIDA);
                TelaEstoque.mostrar();
                break;
        }

    }

}




