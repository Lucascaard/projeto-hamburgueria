package principal.telas;
import principal.controles.ControleProduto;
import principal.db.Banco;
import principal.modelos.Produto;
import principal.util.Mensagem;
import principal.util.Prompt;

public class TelaProduto {
	
	public static void mostrar(){
        
		Prompt.linhaEmBranco();
		Prompt.separador();
		Prompt.imprimir(Mensagem.MENU_PRODUTO);
		Prompt.separador();
		Prompt.linhaEmBranco();
		Prompt.imprimir("[1] - " + Mensagem.CREATE);
		Prompt.imprimir("[2] - " + Mensagem.READ);
		Prompt.imprimir("[3] - " + Mensagem.DELETE);
		Prompt.imprimir("[4] - " + Mensagem.VOLTAR);
		Integer opcao = Prompt.lerInteiro();
		
		switch(opcao){
		case 1:
			TelaProduto.cadastrar();
			break;
		case 2:
			TelaProduto.listar();
			break;
		case 3:
			TelaProduto.excluir();
			break;
		default:
			Prompt.imprimir(Mensagem.OPCAO_INVALIDA);
			TelaPrincipal.mostrar();
			break;
			}
		
    	}
	
	public static void cadastrar(){

		Prompt.separador();
        Prompt.imprimir(Mensagem.MSG_CADASTRO_PRODUTO);
		Prompt.separador();
		Integer id = Prompt.lerInteiro(Mensagem.INFORME_ID);
        String nome = Prompt.lerLinha(Mensagem.INFORME_NOME_PRODUTO);
        String marca = Prompt.lerLinha(Mensagem.INFORME_MARCA);
        double preco  = Prompt.lerDecimal(Mensagem.INFORME_PRECO);
        int codBarra = Prompt.lerInteiro(Mensagem.INFORME_CODBARRA);
        

        if(!nome.isEmpty()) {
			 
        	ControleProduto.adicionar(new Produto(id, nome, marca, preco, codBarra));
        }
		Prompt.pressionarEnter();
		TelaProduto.refazer();
		
	}
	
	public static void refazer(){

		Prompt.separador();
		Prompt.imprimir(Mensagem.NOVO_PRODUTO);
		Prompt.separador();
		Prompt.imprimir("[1] - " + Mensagem.SIM);
		Prompt.imprimir("[2] - " + Mensagem.VOLTAR);
		Prompt.imprimir("[3] - " + Mensagem.FINALIZAR_PROGRAMA);
		Integer op = Prompt.lerInteiro();
		switch (op) {
			case 1:
				TelaProduto.cadastrar();
				break;
			case 2:
				TelaProduto.mostrar();
				break;
			case 3:
				Prompt.imprimir(Mensagem.FINALIZADO);
			default:
				Prompt.imprimir(Mensagem.OPCAO_INVALIDA);
				TelaProduto.refazer();
				break;
		}
    }
	
	public static void listar(){

		Prompt.separador();
		Prompt.imprimir(Mensagem.LISTA_DE_PRODUTOS);
		Prompt.separador();
		
		Prompt.linhaEmBranco();
		
		if (Banco.produtos.isEmpty()) {
			
			Prompt.imprimir(Mensagem.NAO_HA_PRODUTOS); 
		} else {
			
			for (Produto produto : Banco.produtos) {
				String infoProduto = "ID: " + produto.getId() + "\n"
									+ "Nome: " + produto.getNome() + "\n"  
									+ "Marca: " + produto.getMarca() + "\n"
									+ "Preço: " + produto.getPreco() + "\n"
									+ "Código de Barras: " + produto.getCodBarra() + "\n";
				Prompt.imprimir(infoProduto);
			}
		}
		Prompt.linhaEmBranco();
		Prompt.pressionarEnter();
		TelaProduto.mostrar();
	}

	public static void excluir() {
		Prompt.separador();
		Prompt.imprimir(Mensagem.MSG_EXCLUSAO_PRODUTO);
		Prompt.separador();
		Integer id = Prompt.lerInteiro(Mensagem.INFORME_ID);
		boolean excluiu = ControleProduto.excluir(id);
		if(excluiu) {
		Prompt.imprimir(Mensagem.PRODUTO_EXCLUIDO_SUCESSO);
		} else {
		Prompt.imprimir(Mensagem.PRODUTO_NAO_ENCONTRADO);
		}
		Prompt.pressionarEnter();
		TelaProduto.refazer();
		}

}
