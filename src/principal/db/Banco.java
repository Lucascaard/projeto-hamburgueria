package principal.db;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import principal.modelos.*;
public class Banco {

    public static List<Cliente> clientes = new ArrayList<>();
    public static List<Produto> produtos = new ArrayList<>();
    public static List<Gerente> gerentes = new ArrayList<>();
    public static Estoque estoque = new Estoque();
    public static List<Estoque> produtoEstoques = new ArrayList<>();
    public static List<Funcionario> funcionarios = new ArrayList<>();

    public static void inserindoDados(){

    Cliente cliente = new Cliente("Lucas Cardoso", "123456", "7894456", "Masculino", "email@exemplo.com","Rua 1" );
    clientes.add(cliente);

    Produto produto = new Produto(1, "Pão", "Viscotti", 4.99, 0326);
    produtos.add(produto);

    Gerente gerente = new Gerente("Geucemar", "15151", "98989", "Masculino", "email@exemplo.com",LocalDate.of(2020, 1, 1), new BigDecimal(5.000));
    gerentes.add(gerente);

    Funcionario funcionario = new Funcionario("Tair", "4565", "545545", "M", "@gmail.com", LocalDate.of(2023, 2, 6), LocalTime.of(10, 15, 20), LocalTime.of(5, 10, 30));
    funcionarios.add(funcionario);

    }
}