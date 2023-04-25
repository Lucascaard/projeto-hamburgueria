package principal.controles;

/*
* @version 1.0 Abr 2023
* @author Lucas Cardoso
*/
public class LoginAutenticacao {

    public static boolean autenticar(String login, String senha){
        if(login.equals("gerente")  && senha.equals("senha")){
            return true;
        } else{
            return false;
        }
    }
}
