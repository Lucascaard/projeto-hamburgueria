package principal.telas;

import java.time.LocalDate;
import java.time.LocalTime;

import principal.controles.ControleFuncionario;
import principal.db.Banco;
import principal.modelos.Funcionario;
import principal.util.Mensagem;
import principal.util.Prompt;

public class TelaFuncionario {

    public static void mostrar(){ 

        //opções ("menu funcionario")

		Prompt.linhaEmBranco();
		Prompt.separador();
		Prompt.imprimir(Mensagem.MENU_FUNCIONARIO);
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
					TelaFuncionario.create();
					break;
				case 2:
					TelaFuncionario.read();
					break;
				case 3:
					TelaFuncionario.update();
					break;
				case 4:
					TelaFuncionario.delete();
					break;
				case 5:
					TelaPrincipal.mostrar();
					break;
				default:
					Prompt.imprimir(Mensagem.OPCAO_INVALIDA);
					TelaFuncionario.mostrar();
					break;
			}
	}

    public static void create(){
		// Lendo e guardando os dados em variáveis

		Prompt.separador();
        Prompt.imprimir(Mensagem.MSG_CADASTRO_FUNCIONARIO);
		Prompt.separador();
		Prompt.linhaEmBranco();

		Integer CPF = Prompt.lerInteiro(Mensagem.INFORME_CPF);
		//verificando se o cpf ja existe
		if(ControleFuncionario.funcionarioExiste(CPF)){
			Prompt.separador();
			Prompt.imprimir(Mensagem.FUNCIONARIO_EXISTE);
			Prompt.separador();
			Prompt.linhaEmBranco();
			for(Funcionario funcionario : Banco.funcionarios){
				if(funcionario.getCPF().equals(CPF)){
					//mostra as informaçoes do funcionario com este cpf cadastrado
					String infoFuncionario = "Nome: " + funcionario.getNome() + "\n"
											+ "CPF: " + funcionario.getCPF() + "\n"
					 						+ "Telefone: " + funcionario.getTelefone() + "\n"
											+ "Sexo: " + funcionario.getSexo() + "\n"
					 						+ "Email: " + funcionario.getEmail() + "\n"
					 						+ "DataAdmissao: " + funcionario.getDataAdmissao() + "\n"
											+ "HoraEntrada: " + funcionario.getHorarioEntrada() + "\n"
											+ "HoraEntrada: " + funcionario.getHorarioSaida() + "\n";
					Prompt.imprimir(infoFuncionario);						
				}
			}
			TelaFuncionario.refazer();
			return;
		}

        String nome = Prompt.lerLinha(Mensagem.INFORME_NOME);
        String telefone = Prompt.lerLinha(Mensagem.INFORME_TELEFONE);
        String sexo = Prompt.lerLinha(Mensagem.INFORME_SEXO);
        String email = Prompt.lerLinha(Mensagem.INFORME_EMAIL);
        LocalDate dataAdmissao = Prompt.lerData(Mensagem.INFORME_DATA); //usar com - ( 2001-02-03 )
        LocalTime horarioEntrada = Prompt.lerHora(Mensagem.INFORME_HORA_ENTRADA); //usar com : ( hora:min:seg )
        LocalTime horarioSaida = Prompt.lerHora(Mensagem.INFORME_HORA_SAIDA);
		
        //verificar se o nome ta vazio e continuar

        if(!nome.isEmpty()) {
          
			//adicionar no ControleFuncionario e variaveis como parametro

            ControleFuncionario.adicionar(new Funcionario(nome, CPF, telefone, sexo, email, dataAdmissao, horarioEntrada, horarioSaida));

        }
        Prompt.pressionarEnter();
		TelaFuncionario.refazer();
	}

	public static void read(){
		//separador: -------
		Prompt.separador();
		//mensagem da lista de funcionários
		Prompt.imprimir(Mensagem.LISTA_DE_FUNCIONARIOS);
		Prompt.separador();
		Prompt.linhaEmBranco();

		//se a lista de funcionários estiver vazia uma mensagem irá aparecer
		//caso a lista tenha funcionários ela vai ser percorrida

		if(Banco.funcionarios.isEmpty()) {
			Prompt.imprimir(Mensagem.NAO_HA_FUNCIONARIOS);
		} else {
			//percorrendo no banco de dados a lista de funcionarios cadastrados caso exista
			for (Funcionario funcionario : Banco.funcionarios) { 
				String infoFuncionario = "Nome: " + funcionario.getNome() + "\n"
										+ "CPF: " + funcionario.getCPF() + "\n"
			 							+ "Telefone: " + funcionario.getTelefone() + "\n"
			                            + "Sexo: " + funcionario.getSexo() + "\n"
			 							+ "Email: " + funcionario.getEmail() + "\n"
			 							+ "DataAdmissao: " + funcionario.getDataAdmissao() + "\n"
			                            + "HoraEntrada: " + funcionario.getHorarioEntrada() + "\n"
			                            + "HoraEntrada: " + funcionario.getHorarioSaida() + "\n";
			Prompt.imprimir(infoFuncionario);
			}
		}
		
		Prompt.linhaEmBranco();
		Prompt.pressionarEnter();
		TelaFuncionario.mostrar();
	}

	public static void update(){
		Prompt.linhaEmBranco();
		Prompt.separador();
		Prompt.imprimir(Mensagem.UPDATE_FUNCIONARIO);
		Prompt.separador();

		String nomeOriginal = Prompt.lerLinha(Mensagem.NOME_ORIGINAL_FUNCIONARIO);

		if(!nomeOriginal.isEmpty()){
			Funcionario funcionarioAlterado = ControleFuncionario.buscar(nomeOriginal);

			if(funcionarioAlterado != null) {
				Prompt.imprimir(Mensagem.NOVOS_DADOS_FUNCIONARIO);
				Prompt.linhaEmBranco();
				String nome = Prompt.lerLinha(Mensagem.INFORME_NOME);
        		Integer CPF = Prompt.lerInteiro(Mensagem.INFORME_CPF);
        		String telefone = Prompt.lerLinha(Mensagem.INFORME_TELEFONE);
        		String sexo = Prompt.lerLinha(Mensagem.INFORME_SEXO);
        		String email = Prompt.lerLinha(Mensagem.INFORME_EMAIL);
        		LocalDate dataAdmissao = Prompt.lerData(Mensagem.INFORME_DATA); //usar com - ( 2001-02-03 )
        		LocalTime horarioEntrada = Prompt.lerHora(Mensagem.INFORME_HORA_ENTRADA); //usar com : ( hora:min:seg )
        		LocalTime horarioSaida = Prompt.lerHora(Mensagem.INFORME_HORA_SAIDA);
				
				if(!nome.isEmpty() && !CPF.equals(null)){
					funcionarioAlterado.setNome(nome);
					funcionarioAlterado.setCPF(CPF);
					funcionarioAlterado.setTelefone(telefone);
					funcionarioAlterado.setSexo(sexo);
					funcionarioAlterado.setEmail(email);
					funcionarioAlterado.setDataAdmissao(dataAdmissao);
					funcionarioAlterado.setHorarioEntrada(horarioEntrada);
					funcionarioAlterado.setHorarioSaida(horarioSaida);
					
					ControleFuncionario.atualizar(nomeOriginal, funcionarioAlterado);
					Prompt.linhaEmBranco();
					Prompt.imprimir(Mensagem.ALTERADO_FUNCIONARIO_SUCESSO);
				}

			} else {
				Prompt.linhaEmBranco();
				Prompt.imprimir(Mensagem.FUNCIONARIO_NAO_ENCONTRADO);
				TelaFuncionario.read();
			}

			Prompt.linhaEmBranco();
			Prompt.pressionarEnter();
			TelaFuncionario.mostrar();
		}
	}


	public static void delete(){

		Prompt.linhaEmBranco();
		Prompt.separador();
		Prompt.imprimir(Mensagem.DELETAR_FUNCIONARIO);
		Prompt.separador();
		Prompt.linhaEmBranco();

		Integer CPF = Prompt.lerInteiro(Mensagem.FUNCIONARIO_CPF_DELETE);
		
		if(!CPF.equals(null)) {
			boolean funcionarioDeletado = ControleFuncionario.excluir(CPF);
			Prompt.linhaEmBranco();
			if(funcionarioDeletado) {
				Prompt.imprimir(Mensagem.FUNCIONARIO_EXCLUIDO);
				TelaFuncionario.read();
			} else {
				Prompt.imprimir(Mensagem.FUNCIONARIO_NAO_ENCONTRADO);
				TelaFuncionario.read();
			}
		Prompt.linhaEmBranco();
		Prompt.pressionarEnter();

		}
	TelaFuncionario.mostrar();

	}



    public static void refazer(){

		// Menu pra escolher o que deseja fazer a seguir com recursão em caso de opção invalida
		Prompt.separador();
		Prompt.imprimir(Mensagem.NOVO_FUNCIONARIO);
		Prompt.separador();
		Prompt.imprimir("[1] - " + Mensagem.SIM);
		Prompt.imprimir("[2] - " + Mensagem.VOLTAR);
		Prompt.imprimir("[3] - " + Mensagem.FINALIZAR_PROGRAMA);
		Integer op = Prompt.lerInteiro();
		switch (op) {
			case 1:
				TelaFuncionario.create();
				break;
			case 2:
                TelaFuncionario.mostrar();
				break;
			case 3:
				Prompt.imprimir(Mensagem.FINALIZADO);
			default:
				Prompt.imprimir(Mensagem.OPCAO_INVALIDA);
				TelaFuncionario.refazer();
				break;
		}
    }
}
    // public static void listar(){

	// 	Prompt.separador();
	// 	Prompt.imprimir(Mensagem.LISTA_DE_FUNCIONARIOS);
	// 	Prompt.separador();
	// 	Prompt.linhaEmBranco();
	
	// 	if (Banco.funcionarios.isEmpty()) {
	// 		Prompt.imprimir(Mensagem.NAO_HA_FUNCIONARIOS); 
	// 	} else {
	// 		for (Funcionario funcionario : Banco.funcionarios) {
	// 			String infoFuncionario = "Nome: " + funcionario.getNome() + "\n"
	// 								+ "CPF: " + funcionario.getCPF() + "\n"
	// 								+ "Telefone: " + funcionario.getTelefone() + "\n"
    //                                 + "Sexo: " + funcionario.getSexo() + "\n"
	// 								+ "Email: " + funcionario.getEmail() + "\n"
	// 								+ "DataAdmissao: " + funcionario.getDataAdmissao() + "\n"
    //                                 + "HoraEntrada: " + funcionario.getHorarioEntrada() + "\n"
    //                                 + "HoraEntrada: " + funcionario.getHorarioSaida() + "\n";
	// 			// mostrar as informações do funcionario
	// 			Prompt.imprimir(infoFuncionario);
	// 		}
	// 	}
	// 	Prompt.linhaEmBranco();
	// 	Prompt.pressionarEnter();
	// 	TelaFuncionario.mostrar();
	// }