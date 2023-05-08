package principal.controles;
import principal.db.Banco;
import principal.modelos.Cliente;
import principal.util.Mensagem;
import principal.util.Prompt;
import principal.telas.*;

/*
 * @Author Lucas Cardoso
 * @version 1.0 Abr 2023
 */

public class ControleCliente {

	public static void adicionar(Cliente cliente){
        Banco.clientes.add(cliente);
    }

    public static Cliente buscar(Integer cpf) {
		Cliente clienteRetorno = null;
		for (Cliente cliente : Banco.clientes) {
			if (cliente.getCPF().equals(cpf)) {
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

	public static void atualizar(Integer cpfOriginal, Cliente clienteAlterado) {
		for (int i = 0; i < Banco.clientes.size(); i++) {
			Cliente cliente = Banco.clientes.get(i);
			if (cliente.getCPF().equals(cpfOriginal)) {
				Banco.clientes.set(i, clienteAlterado);
			    break;
			}
		}
	}

    public static boolean delete(Integer CPF) {
		boolean clienteDelete = false;
		for (int i = 0; i < Banco.clientes.size(); i++) {
			Cliente cliente = Banco.clientes.get(i);
			if (cliente.getCPF().equals(CPF)) {
				Banco.clientes.remove(i);
				clienteDelete = true;
				break;
			}
		}
		return clienteDelete;
	}

	public static boolean clienteExiste(Integer CPF){
		for(Cliente cliente : Banco.clientes) {
			if(cliente.getCPF().equals(CPF)){
				return true;
			}
		}
		return false;
	}

	public static void menuDoCliente(){

	Prompt.linhaEmBranco();
	Prompt.separador();
	Prompt.imprimir(Mensagem.MENU_CLIENTE);
	Prompt.separador();
	Prompt.linhaEmBranco();
	Prompt.imprimir("[1] - " + Mensagem.CREATE);
	Prompt.imprimir("[2] - " + Mensagem.READ);
	Prompt.imprimir("[3] - " + Mensagem.UPDATE);
	Prompt.imprimir("[4] - " + Mensagem.DELETE);
	Prompt.imprimir("[5] - " + Mensagem.VOLTAR);
	Integer opcao = Prompt.lerInteiro();

		switch(opcao){
			case 1:
				TelaCliente.create();
				break;
			case 2:
				TelaCliente.read();
				break;
			case 3:
				TelaCliente.update();
				break;
			case 4:
				TelaCliente.delete();
				break;
			case 5:
				TelaPrincipal.mostrar();
				break;
			default:
				Prompt.imprimir(Mensagem.OPCAO_INVALIDA);
				TelaCliente.mostrar();
				break;
		}
}

}