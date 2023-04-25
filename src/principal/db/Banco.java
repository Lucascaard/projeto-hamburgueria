package principal.db;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import principal.modelos.*;

/*
* @version 1.0 Abr 2023
* @author Lucas Cardoso
*/
public class Banco {

    public static List<Cliente> clientes = new ArrayList<>();
    public static List<Produto> produtos = new ArrayList<>();
    public static List<Gerente> gerentes = new ArrayList<>();

    public static void inserindoDados(){

    Cliente cliente = new Cliente("Lucas Cardoso", "123456", "7894456", "Masculino", "email@exemplo.com","Rua 1" );
    clientes.add(cliente);

    Produto produto = new Produto("Pão", "Viscotti", new BigDecimal(4.99), 0326);
    produtos.add(produto);

    Gerente gerente = new Gerente("Geucemar", "15151", "98989", "Masculino", "email@exemplo.com",LocalDate.of(2020, 1, 1), new BigDecimal(5.000));
    gerentes.add(gerente);
    }
}
