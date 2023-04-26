package principal.telas;

import principal.util.Mensagem;
import principal.util.Prompt;
import principal.controles.ControleEstoque;
import principal.db.Banco;
import principal.modelos.Estoque;
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
        Prompt.imprimir("[1] - " + Mensagem.CADASTRAR);
        Prompt.imprimir("[2] - " + Mensagem.LISTAR);
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
                    TelaEstoque.voltar();
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
        Integer qtde = Prompt.lerInteiro(Mensagem.INFORME_QUANTIDADE);
        String endereco = Prompt.lerLinha(Mensagem.INFORME_ENDERECO_ESTOQUE);

        if(!produto.isEmpty()) {

            ControleEstoque.adicionar(new Estoque(produto, qtde, endereco));
        }

    }

}

