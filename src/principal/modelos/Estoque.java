package principal.modelos;
import java.util.ArrayList;
import java.util.List;

import principal.db.Banco;

public class Estoque {
	
		//private List<ItemEstoque> itensEstoque = new ArrayList<ItemEstoque>(); comentado pra teste
		private String enderecoEstoque;
		
		public void adicionarItem(ItemEstoque item) {
			Banco.itensEstoque.add(item);
		}

		public void removerItem(ItemEstoque item) {
			Banco.itensEstoque.remove(item);
		}
		
		public Estoque() {
			
		}
		
		//Setters
			public void setEnderecoEstoque(String enderecoEstoque) {
				this.enderecoEstoque = enderecoEstoque;
			}
			
			// public void setItensEstoque(List<ItemEstoque> itensEstoque) {
			// 	this.itensEstoque = itensEstoque;
			// } comentado pra teste
		
		//Getters
			public String getEnderecoEstoque() {
				return enderecoEstoque;
			}

	
			// public List<ItemEstoque> getItensEstoque() {
			// 	return itensEstoque;
			// } comentado pra teste
	
	}