package principal.telas;

import principal.util.Mensagem;
import principal.util.Prompt;
import principal.controles.ControleEstoque;
import principal.controles.ControleProduto;
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
        Prompt.imprimir("[3] - " + Mensagem.VOLTAR);
        Integer opcao = Prompt.lerInteiro();

            switch (opcao) {
                case 1:
                    TelaEstoque.cadastrar();
                    break;
                case 2:
                    TelaEstoque.listar();
                    break;
                case 3:
                    TelaPrincipal.mostrar();
                    break;
                default:
                    Prompt.imprimir(Mensagem.OPCAO_INVALIDA);
                    TelaPrincipal.mostrar();
                    break;
            }


    }

    public static void cadastrar(){

        //Lendo e guardando dados em variáveis

        Prompt.separador();
        Prompt.imprimir(Mensagem.MSG_CADASTRO_ESTOQUE);
        Prompt.separador();
        Integer idProduto = Prompt.lerInteiro(Mensagem.INFORME_ID);
        Integer qtde = Prompt.lerInteiro(Mensagem.INFORME_QUANTIDADE);

        if(!idProduto.equals(null)) {


            Produto produto = ControleProduto.buscarPorId(idProduto);

            ItemEstoque item = new ItemEstoque();
            item.setProduto(produto);
            item.setQtde(qtde);

            ControleEstoque.adicionar(item);
        }

        Prompt.pressionarEnter();
		TelaEstoque.mostrar();

    }


    public static void listar(){

    }

    public static void voltar(){

    }

}

