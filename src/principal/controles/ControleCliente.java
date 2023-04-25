package principal.controles;

import principal.db.Banco;
import principal.modelos.Cliente;

/*
* @version 1.0 Abr 2023
* @author Lucas Cardoso
*/
public class ControleCliente {

    public static void adicionar(Cliente cliente){
        Banco.clientes.add(cliente);
    }
    
}
