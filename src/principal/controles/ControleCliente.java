package principal.controles;

import principal.db.Banco;
import principal.modelos.Cliente;

/*
 * @Author Lucas Cardoso
 * @version 1.0 Abr 2023
 */

public class ControleCliente {

	public static void adicionar(Cliente cliente){
        Banco.clientes.add(cliente);
    }

    public static Cliente buscar(String nome) {
		Cliente clienteRetorno = null;
		for (Cliente cliente : Banco.clientes) {
			if (cliente.getNome().equalsIgnoreCase(nome)) {
				clienteRetorno = cliente;
				break;
			}
		}
		return clienteRetorno;
	}

    /*Essas duas funções têm o mesmo nome, "atualizar", mas parâmetros diferentes. 
	A primeira função recebe um índice e o objeto "Cliente" que deve ser atualizado na lista. 
	A segunda função recebe uma string que é o nome original do cliente e o objeto "Cliente" atualizado.

    Quando a função é chamada, o Java determina qual das funções será chamada baseado nos parâmetros 
	que foram passados. Se os parâmetros correspondem aos da primeira função, ela é chamada; 
	se correspondem aos da segunda, a segunda é chamada.

    Por exemplo, se o índice do cliente que deve ser atualizado é conhecido, 
	a primeira função pode ser usada, mas se o nome original do cliente for usado como referência, 
	a segunda função pode ser usada. Isso permite maior flexibilidade no uso da função, 
	dependendo das informações disponíveis no momento em que é chamada. */
	
    public static void atualizar(int indexAlterar, Cliente clienteAlterado) {
		Banco.clientes.set(indexAlterar, clienteAlterado);
	}

	public static void atualizar(String nomeOriginal, Cliente clienteAlterado) {
		for (int i = 0; i < Banco.clientes.size(); i++) {
			Cliente cliente = Banco.clientes.get(i);
			if (cliente.getNome().equalsIgnoreCase(nomeOriginal)) {
				Banco.clientes.set(i, clienteAlterado);
			    break;
			}
		}
	}

    public static boolean excluir(String nome) {
		boolean clienteExcluido = false;
		for (int i = 0; i < Banco.clientes.size(); i++) {
			Cliente cliente = Banco.clientes.get(i);
			if (cliente.getNome().equalsIgnoreCase(nome)) {
				Banco.clientes.remove(i);
				clienteExcluido = true;
				break;
			}
		}
		return clienteExcluido;
	}
}

