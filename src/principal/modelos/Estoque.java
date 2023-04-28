package principal.modelos;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
	
		private List<ItemEstoque> itensEstoque = new ArrayList<ItemEstoque>();
		private String enderecoEstoque;
		
		public void adicionarItem(ItemEstoque item) {
			this.itensEstoque.add(item);
		}
		
		public Estoque() {
			
		}
		
		//Setters
			public void setEnderecoEstoque(String enderecoEstoque) {
				this.enderecoEstoque = enderecoEstoque;
			}
			
		
		//Getters
			public String getEnderecoEstoque() {
				return enderecoEstoque;
			}

	
			public List<ItemEstoque> getItensEstoque() {
				return itensEstoque;
			}
	
			public void setItensEstoque(List<ItemEstoque> itensEstoque) {
				this.itensEstoque = itensEstoque;
			}
	}