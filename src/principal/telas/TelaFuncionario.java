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

        //opções ("menu")

		Prompt.linhaEmBranco();
		Prompt.separador();
		Prompt.imprimir(Mensagem.MENU_FUNCIONARIO);
		Prompt.separador();
		Prompt.linhaEmBranco();
		Prompt.imprimir("[1] - " + Mensagem.CREATE);
		Prompt.imprimir("[2] - " + Mensagem.READ);
		Prompt.imprimir("[3] - " + Mensagem.VOLTAR);
		Integer opcao = Prompt.lerInteiro();

			switch(opcao){
				case 1:
					TelaFuncionario.cadastrar();
					break;
				case 2:
                    TelaFuncionario.listar();
					break;
				default:
					Prompt.imprimir(Mensagem.OPCAO_INVALIDA);
					TelaPrincipal.mostrar();
					break;
			}
	}

    public static void cadastrar(){
        
		// Lendo e guardando os dados em variáveis

		Prompt.separador();
        Prompt.imprimir(Mensagem.MSG_CADASTRO_FUNCIONARIO);
		Prompt.separador();
        String nome = Prompt.lerLinha(Mensagem.INFORME_NOME);
        String CPF = Prompt.lerLinha(Mensagem.INFORME_CPF);
        String telefone = Prompt.lerLinha(Mensagem.INFORME_TELEFONE);
        String sexo = Prompt.lerLinha(Mensagem.INFORME_SEXO);
        String email = Prompt.lerLinha(Mensagem.INFORME_EMAIL);
        LocalDate dataAdmissao = Prompt.lerData(Mensagem.INFORME_DATA); //usar com - ( 2001-02-03 )
        LocalTime horarioEntrada = Prompt.lerHora(Mensagem.INFORME_HORA_ENTRADA); //usar com : ( hora:min:seg )
        LocalTime horarioSaida = Prompt.lerHora(Mensagem.INFORME_HORA_SAIDA);
		
        //verificar se o nome ta vazio e continuar

        if(!nome.isEmpty()) {
            //função adicionar na classe ControleFuncionario e as variáveis como parâmetro

            ControleFuncionario.adicionar(new Funcionario(nome, CPF, telefone, sexo, email, dataAdmissao, horarioEntrada, horarioSaida));

        }
        Prompt.pressionarEnter();
		TelaFuncionario.refazer();
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
				TelaFuncionario.cadastrar();
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

    public static void listar(){

		Prompt.separador();
		Prompt.imprimir(Mensagem.LISTA_DE_FUNCIONARIOS);
		Prompt.separador();
		Prompt.linhaEmBranco();
	
		if (Banco.funcionarios.isEmpty()) {
			Prompt.imprimir(Mensagem.NAO_HA_FUNCIONARIOS); 
		} else {
			for (Funcionario funcionario : Banco.funcionarios) {
				String infoFuncionario = "Nome: " + funcionario.getNome() + "\n"
									+ "CPF: " + funcionario.getCPF() + "\n"
									+ "Telefone: " + funcionario.getTelefone() + "\n"
                                    + "Sexo: " + funcionario.getSexo() + "\n"
									+ "Email: " + funcionario.getEmail() + "\n"
									+ "DataAdmissao: " + funcionario.getDataAdmissao() + "\n"
                                    + "HoraEntrada: " + funcionario.getHorarioEntrada() + "\n"
                                    + "HoraEntrada: " + funcionario.getHorarioSaida() + "\n";
				// mostrar as informações do funcionario
				Prompt.imprimir(infoFuncionario);
			}
		}
		Prompt.linhaEmBranco();
		Prompt.pressionarEnter();
		TelaFuncionario.mostrar();
	}

    
}
