package principal.controles;

import principal.db.Banco;
import principal.modelos.Funcionario;

public class ControleFuncionario {
    
    public static void adicionar(Funcionario funcionario){
        Banco.funcionarios.add(funcionario);
    }
}
