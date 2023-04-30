package principal.modelos;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Gerente extends Pessoa {

	private LocalDate dataAdmissao;
	private BigDecimal salario;
	
	public Gerente(String nome, Integer CPF, String telefone, String sexo, String email, LocalDate dataAdmissao, BigDecimal salario) {
		super(nome, CPF, telefone, sexo, email);
		this.dataAdmissao = dataAdmissao;
		this.salario = salario;
	}
	//GETTERS e SETTERS
	
	//dataAdmissão
	public void setDataAdmissao(LocalDate admissaoExterno) {
		this.dataAdmissao = admissaoExterno;
	}
	
	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}
	
	//salario
	public void setSalario(BigDecimal salarioExterno) {
		this.salario = salarioExterno; 
	}
	
	public BigDecimal getSalario() {
		return salario;
	}
	
}