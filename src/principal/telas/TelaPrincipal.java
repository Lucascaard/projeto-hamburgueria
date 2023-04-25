package principal.telas;

import java.util.Scanner;

import principal.util.Mensagem;
import principal.util.Prompt;

public class TelaPrincipal {

    
    public static void mostrar(){
        
        Scanner leitor = new Scanner(System.in);
        Prompt.linhaEmBranco();
        Prompt.imprimir(Mensagem.MENU_GERENTE);
        Prompt.imprimir(Mensagem.MSG_ESCOLHA_UMA_OPÇÃO);
        Prompt.imprimir("[1] " + Mensagem.MENU_CLIENTE);
        Prompt.imprimir("[2] " + Mensagem.CADASTRAR_FUNCIONARIO);
        Prompt.imprimir("[3] " + Mensagem.CADASTRAR_PRODUTO);
        Prompt.imprimir("[4] " + Mensagem.CADASTRAR_GERENTE);
        Prompt.imprimir("[5] " + Mensagem.VOLTAR);
        Integer opcao = leitor.nextInt();

        switch (opcao) {
            case 1:
                TelaCliente.mostrar();
                break;
            case 2:
                TelaCadastrarFuncionario.mostrar();
                break;
            case 3:
                TelaCadastrarProduto.mostrar();
                break;
            case 4:
                TelaCadastrarGerente.mostrar();
                break;
            case 5:
                TelaLogin.mostrar();
                break;
            default:
                Prompt.imprimir(Mensagem.OPCAO_INVALIDA);
                Prompt.linhaEmBranco();
                TelaPrincipal.mostrar();
                break;
        }
        
        leitor.close();
    }
}
