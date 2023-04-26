package principal.telas;

import principal.controles.ControleCliente;
import principal.db.Banco;
import principal.modelos.Cliente;
import principal.util.Mensagem;
import principal.util.Prompt;

public class TelaCliente {
	
	public static void mostrar(){

		Prompt.linhaEmBranco();
		Prompt.separador();
		Prompt.imprimir(Mensagem.MENU_CLIENTE);
		Prompt.separador();
		Prompt.linhaEmBranco();
		Prompt.imprimir("[1] - " + Mensagem.CADASTRAR);
		Prompt.imprimir("[2] - " + Mensagem.LISTAR);
		Prompt.imprimir("[3] - " + Mensagem.VOLTAR);
		Integer opcao = Prompt.lerInteiro();

			switch(opcao){
				case 1:
					TelaCliente.cadastrar();
					break;
				case 2:
					TelaCliente.listar();
					break;
				default:
					Prompt.imprimir(Mensagem.OPCAO_INVALIDA);
					TelaPrincipal.mostrar();
					break;
			}
	}

	public static void cadastrar(){
        
		// Lendo e guardando dados em variáveis

		Prompt.separador();
        Prompt.imprimir(Mensagem.MSG_CADASTRO_CLIENTE);
		Prompt.separador();
        String nome = Prompt.lerLinha(Mensagem.INFORME_NOME);
        String CPF = Prompt.lerLinha(Mensagem.INFORME_CPF);
        String telefone = Prompt.lerLinha(Mensagem.INFORME_TELEFONE);
        String email = Prompt.lerLinha(Mensagem.INFORME_EMAIL);
        String sexo = Prompt.lerLinha(Mensagem.INFORME_SEXO);
        String endereco = Prompt.lerLinha(Mensagem.INFORME_ENDERECO);

		// Verificando se nome esta vazio

        if(!nome.isEmpty()) {

			/* Chamando a função adicionar da Classe ControleCliente, criando um objeto e passando
			 as variáveis como parâmetro para a criação do novo Cliente */
			 
        	ControleCliente.adicionar(new Cliente(nome, CPF, telefone, sexo, email, endereco));
        }
		Prompt.pressionarEnter();
		TelaCliente.refazer();
		
	}

	public static void refazer(){

		// Menu pra escolher o que deseja fazer a seguir com recursão em caso de opção invalida
		Prompt.separador();
		Prompt.imprimir(Mensagem.NOVO_CLIENTE);
		Prompt.separador();
		Prompt.imprimir("[1] - " + Mensagem.SIM);
		Prompt.imprimir("[2] - " + Mensagem.VOLTAR);
		Prompt.imprimir("[3] - " + Mensagem.FINALIZAR_PROGRAMA);
		Integer op = Prompt.lerInteiro();
		switch (op) {
			case 1:
				TelaCliente.cadastrar();
				break;
			case 2:
				TelaCliente.mostrar();
				break;
			case 3:
				Prompt.imprimir(Mensagem.FINALIZADO);
				break;
			default:
				Prompt.imprimir(Mensagem.OPCAO_INVALIDA);
				TelaCliente.refazer();
				break;
		}
    }

	public static void listar(){

		// Imprime uma mensagem de cabeçalho
		Prompt.separador();
		Prompt.imprimir(Mensagem.LISTA_DE_CLIENTES);
		Prompt.separador();
		
		// Adiciona uma linha em branco
		Prompt.linhaEmBranco();
		
		// Verifica se a lista de clientes está vazia
		if (Banco.clientes.isEmpty()) {
			// Se a lista de clientes estiver vazia, imprime uma mensagem informando que não há clientes
			Prompt.imprimir(Mensagem.NAO_HA_CLIENTES); 
		} else {
			// Se houver clientes na lista, percorre a lista com um laço 'for'
			for (Cliente cliente : Banco.clientes) {
				// Monta uma string com as informações do cliente
				String infoCliente = "Nome: " + cliente.getNome() + "\n"
									+ "CPF: " + cliente.getCPF() + "\n"
									+ "Telefone: " + cliente.getTelefone() + "\n"
									+ "Email: " + cliente.getEmail() + "\n"
									+ "Sexo: " + cliente.getSexo() + "\n"
									+ "Endereço: " + cliente.getEndereco() + "\n";
				// Imprime as informações do cliente
				Prompt.imprimir(infoCliente);
			}
		}
		Prompt.linhaEmBranco();
		Prompt.pressionarEnter();
		TelaCliente.mostrar();
	}
	
}
