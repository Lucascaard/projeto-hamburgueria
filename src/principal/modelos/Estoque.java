package principal.modelos;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
	
		private List<Produto> itensEstoque = new ArrayList<Produto>();
		private int qtde;
		private String enderecoEstoque;
		
		public void adicionarItem(Produto produto) {
			this.itensEstoque.add(produto);
		}
		
		public Estoque() {
			
		}
		
		public Estoque(Produto produto, int qtde, String enderecoEstoque) {
			this.itensEstoque.add(produto);
			this.qtde = qtde;
			this.enderecoEstoque = enderecoEstoque;
		}
		
		//Setters
			public void setEnderecoEstoque(String enderecoEstoque) {
				this.enderecoEstoque = enderecoEstoque;
			}
			
			public void setQtde( int qtdeExterno ) {
				this.qtde = qtdeExterno;
			}
		
		//Getters
			public String getEnderecoEstoque() {
				return enderecoEstoque;
			}
			
			public int getQtde() {
				return qtde;
			}
	
			public List<Produto> getItensEstoque() {
				return itensEstoque;
			}
	
			public void setItensEstoque(List<Produto> itensEstoque) {
				this.itensEstoque = itensEstoque;
			}
	}