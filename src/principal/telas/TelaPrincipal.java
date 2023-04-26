package principal.telas;

import principal.util.Mensagem;
import principal.util.Prompt;

public class TelaPrincipal {

    
public static void mostrar(){
        
        Prompt.linhaEmBranco();
        Prompt.separador();
        Prompt.imprimir(Mensagem.MENU_PRINCIPAL);
        Prompt.separador();
        Prompt.imprimir(Mensagem.MSG_ESCOLHA_UMA_OPÇÃO);
        Prompt.linhaEmBranco();
        Prompt.imprimir("[1] " + Mensagem.MENU_CLIENTE);
        Prompt.imprimir("[2] " + Mensagem.MENU_FUNCIONARIO);
        Prompt.imprimir("[3] " + Mensagem.MENU_PRODUTO);
        Prompt.imprimir("[4] " + Mensagem.MENU_GERENTE);
        Prompt.imprimir("[5] " + Mensagem.VOLTAR);
        Integer opcao = Prompt.lerInteiro();

        switch (opcao) {
            case 1:
                TelaCliente.mostrar();
                break;
            case 2:
                TelaFuncionario.mostrar();
                break;
            case 3:
                TelaProduto.mostrar();
                break;
            case 4:
                TelaEstoque.mostrar(); // alterado para teste
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
    }
}
