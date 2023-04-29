package principal.controles;

import principal.db.Banco;
import principal.modelos.Funcionario;

public class ControleFuncionario {
    
    public static void adicionar(Funcionario funcionario){
        Banco.funcionarios.add(funcionario);
    }


    public static Funcionario buscar(String nome) {
        Funcionario funcionarioRetorno = null;
        for (Funcionario funcionario : Banco.funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nome)) {
                funcionarioRetorno = funcionario;
                break;
            }
        }
        return funcionarioRetorno;
    }

    //duas funções com o mesmo nome porém com parametros diferentes ou seja, se os parametros passados
    //corresponderem aos parametros da primeira função se o índice do funcionario que deve ser atualizado é 
    //conhecido, a primeira função pode ser usada, mas se o nome original do funcionario for usado como referência, a segunda função pode ser usada.

    public static void atualizar(int indexAlterar, Funcionario funcionarioAlterado) {
		Banco.funcionarios.set(indexAlterar, funcionarioAlterado);
	}

	public static void atualizar(String nomeOriginal, Funcionario funcionarioAlterado) {
		for (int i = 0; i < Banco.funcionarios.size(); i++) {
			Funcionario funcionario = Banco.funcionarios.get(i);
			if (funcionario.getNome().equalsIgnoreCase(nomeOriginal)) {
				Banco.funcionarios.set(i, funcionarioAlterado);
			    break;
			}
		}
	}

    //recebe uma string nome que vai ser usada como parametro para exclusão
    //mas poderia ser um id, um cpf, algo especifico de um determinado funcionario
    public static boolean excluir(String nome) {
        //atribui o valor falso para indicar que ninguém foi excluido
		boolean funcionarioExcluido = false;
        //percorrer o banco de funcionarios em busca do q tenha o nome usado no parametro
		for (int i = 0; i < Banco.funcionarios.size(); i++) {
			Funcionario funcionario = Banco.funcionarios.get(i);
			if (funcionario.getNome().equalsIgnoreCase(nome)) {
				Banco.funcionarios.remove(i);
                //se o nome for encontrado na lista ele vai ser removido 
                //mostrando q algm foi excluido 
				funcionarioExcluido = true;
				break;
			}
		}
		return funcionarioExcluido;
	}
}

