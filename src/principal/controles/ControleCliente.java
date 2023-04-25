package principal.controles;

import principal.db.Banco;
import principal.modelos.Cliente;

public class ControleCliente {

    public static void adicionar(Cliente cliente){
        Banco.clientes.add(cliente);
    }
    
}
