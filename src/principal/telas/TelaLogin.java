package principal.telas;

import principal.util.Mensagem;
import principal.util.Prompt;
import principal.controles.*;

public class TelaLogin {
    
    public static void mostrar(){

        Prompt.imprimir(Mensagem.TELA_LOGIN);
        String login = Prompt.lerLinha(Mensagem.MSG_INFORME_LOGIN);
        String senha = Prompt.lerLinha(Mensagem.MSG_INFORME_SENHA);

        if(LoginAutenticacao.autenticar(login, senha)){
            TelaPrincipal.mostrar();
        } else{
            Prompt.linhaEmBranco();
            Prompt.imprimir(Mensagem.MSG_LOGIN_OR_SENHA_INVALID);
            TelaLogin.mostrar();
        }
    }
}
