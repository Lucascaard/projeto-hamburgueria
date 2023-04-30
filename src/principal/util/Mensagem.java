package principal.util;

public interface Mensagem {


    //CRUD
    final static String CREATE = "CADASTRAR ";
    final static String READ = "LISTAR";
    final static String UPDATE = "ALTERAR";
    final static String DELETE = "DELETAR";

	//MENUS
    final static String MENU_PRINCIPAL = "               MENU PRINCIPAL";
    final static String OPCAO_INVALIDA = "OPÇÃO INVALIDA, TENTE NOVAMENTE";
    final static String MSG_ESCOLHA_UMA_OPÇÃO = "ESCOLHA UMA DAS OPÇÕES";
    final static String FINALIZADO = "PROGRAMA FINALIZADO";
    final static String EXCLUIR = "EXCLUIR";
    final static String VOLTAR = "VOLTAR";
    final static String SIM = "SIM";
    final static String FINALIZAR_PROGRAMA = "FINALIZAR PROGRAMA";

    //LOGIN
    final static String TELA_LOGIN = "                   TELA DE LOGIN";
    final static String MSG_INFORME_LOGIN = "INFORME O LOGIN: ";
    final static String MSG_INFORME_SENHA = "INFORME A SENHA: ";
    final static String MSG_LOGIN_OR_SENHA_INVALID = "LOGIN OU SENHA INVALIDO, TENTE NOVAMENTE!";

    //CADASTROS
    final static String TELA_DE_CADASTROS = "TELA DE CADASTROS";
    
    //PESSOA
    final static String INFORME_NOME = "NOME:";
    final static String INFORME_CPF = "CPF:";
    final static String INFORME_TELEFONE = "TELEFONE:";
    final static String INFORME_EMAIL = "EMAIL:";
    final static String INFORME_SEXO = "SEXO:";

    //CLIENTE
    final static String MSG_CADASTRO_CLIENTE = "CADASTRO DE CLIENTES"; 
    final static String MENU_CLIENTE = "MENU CLIENTE";
    final static String INFORME_ENDERECO = "ENDEREÇO: ";
    final static String NOVO_CLIENTE = "DESEJA CADASTRAR UM NOVO CLIENTE? ";
    final static String LISTA_DE_CLIENTES = "LISTA DE CLIENTES";
    final static String NAO_HA_CLIENTES = "NAÕ EXISTEM CLIENTES CADASTRADOS";
    final static String UPDATE_CLIENTE = "ALTERAR CLIENTE";
    final static String NOME_ORIGINAL = "INFORME O NOME DO CLIENTE QUE DESEJA ALTERAR: ";
    final static String NOME_EXCLUIR = "INFORME O NOME DO CLIENTE QUE DESEJA EXCLUIR: ";
    final static String NOVOS_DADOS = "INSIRA OS NOVOS DADOS DESTE CLIENTE";
    final static String ALTERADO_COM_SUCESSO = "CLIENTE ALTERADO COM SUCESSO";
    final static String CLIENTE_NAO_ENCONTRADO = "CLIENTE NÃO FOI ENCONTRADO";
    final static String EXCLUIR_CLIENTE = "EXCLUIR CLIENTE";
    final static String EXCLUIDO_COM_SUCESSO = "CLIENTE EXCLUIDO COM SUCESSO";


    //FUNCIONARIO 
    final static String MENU_FUNCIONARIO = "MENU FUNCIONÁRIO";
    final static String MSG_CADASTRO_FUNCIONARIO = "CADASTRO DE FUNCIONÁRIOS";
    final static String INFORME_DATA = "INFORME A DATA DE ADMISSÃO Ex(0000-00-00)";
    final static String INFORME_HORA_ENTRADA = "INFORME A HORA DA ENTRADA Ex(HH:mm:ss)";
    final static String INFORME_HORA_SAIDA = "INFORME A HORA DA SAÍDA Ex(HH:mm:ss)";
    final static String NOVO_FUNCIONARIO = "DESEJA CADASTRAR UM NOVO FUNCIONÁRIO? ";
    final static String LISTA_DE_FUNCIONARIOS = "LISTA DE FUNCIONÁRIOS";
    final static String NAO_HA_FUNCIONARIOS = "NAÕ EXISTEM FUNCIONÁRIOS CADASTRADOS";


    //GERENTE
    final static String MENU_GERENTE = "MENU GERENTE";

    //PRODUTO
    final static String MSG_CADASTRO_PRODUTO = "CADASTRO DE PRODUTOS";
    final static String MENU_PRODUTO = "MENU PRODUTOS";
    final static String LISTA_DE_PRODUTOS = "LISTA DE PRODUTOS";
    final static String NOVO_PRODUTO = "DESEJA CADASTRAR UM NOVO PRODUTO?";
    final static String INFORME_NOME_PRODUTO = "NOME DO PRODUTO:";
    final static String INFORME_MARCA = "MARCA:";
    final static String INFORME_PRECO = "PREÇO:  Ex(4.99)";
    final static String INFORME_CODBARRA = "CÓDIGO DE BARRAS:";
    final static String NAO_HA_PRODUTOS = "NÃO EXISTEM PRODUTOS CADASTRADOS";
    final static String UPDATE_PRODUTO = "ALTERAR PRODUTO";
    final static String NOME_ORIGINAL_PRODUTO = "INFORME O NOME DO PRODUTO QUE DESEJA ALTERAR: ";
    final static String NOME_EXCLUIR_PRODUTO = "INFORME O NOME DO PRODUTO QUE DESEJA EXCLUIR: ";
    final static String NOVOS_DADOS_PRODUTO = "INSIRA OS NOVOS DADOS DESTE PRODUTO";
    final static String PRODUTO_ALTERADO_COM_SUCESSO = "PRODUTO ALTERADO COM SUCESSO";
    final static String INFORME_ID = "INFORME O ID DO PRODUTO: ";
    final static String ID_JA_EXISTE = "ID JÁ EXISTE";
    final static String MSG_EXCLUSAO_PRODUTO = "EXCLUSÃO DE PRODUTOS";
    final static String PRODUTO_EXCLUIDO_SUCESSO = "PRODUTO EXCLUÍDO COM SUCESSO";
    final static String PRODUTO_NAO_ENCONTRADO = "PRODUTO NÃO ENCONTRADO";
    
    //ESTOQUE
    final static String MENU_ESTOQUE = "MENU ESTOQUE";
    final static String MSG_CADASTRO_ESTOQUE = "CADASTRO DE ESTOQUE";
    final static String INFORME_PRODUTO = "INFORME O PRODUTO: ";
    final static String INFORME_QUANTIDADE = "INFORME A QUANTIDADE: ";
    final static String INFORME_ENDERECO_ESTOQUE = "INFORME O ENDEREÇO: ";
    final static String LISTA_ESTOQUE = "LISTA DO ESTOQUE";
    final static String ESTOQUE_VAZIO = "ESTOQUE VAZIO";
    final static String ID_INVALIDA = "ID INVÁLIDA";
    final static String UPDATE_ESTOQUE = "ATUALIZAR ESTOQUE";
    final static String QTDE_ESTOQUE = "QUANTIDADE EM ESTOQUE";
    final static String PRODUTO_NAO_ENCONTRADO = "PRODUTO NÃO ENCONTRADO";
    final static String NOVA_QTDE = "INSIRA QUANTIDADE DO PRODUTO NO ESTOQUE";
    final static String ESTOQUE_ALTERADO = "ESTOQUE ALTERADO COM SUCESSO";
    final static String EXCLUIR_ESTOQUE = "EXCLUIR PRODUTO DO ESTOQUE";
    final static String INFORME_ID_EXCLUIR_ESTOQUE = "INFORME O ID DO PRODUTO QUE DESEJA EXCLUIR DO ESTOQUE: ";
    final static String ESTOQUE_EXCLUIDO = "PRODUTO EXCLUIDO DO ESTOQUE COM SUCESSO";
    final static String PRODUTO_CADASTRADO_ESTOQUE = "PRODUTO CADASTRADO NO ESTOQUE";
    final static String PRODUTO_EXISTENTE_ESTOQUE = "NÃO É POSSÍVEL CADASTRAR UM PRODUTO JA EXISTENTE";
    final static String INFORME_ID_CADASTRO = "INFORME O ID DO PRODUTO QUE DESEJA CADASTRAR";
    final static String INFORME_ID_ALTERAR = "INFORME O ID DO PRODUTO QUE DESEJA ALTERAR";
    final static String CADASTRAR_OUTRO = "DESEJA CADASTRAR OUTRO PRODUTO?";
    final static String ALTERAR_OUTRO = "DESEJA ATUALIZAR OUTRO PRODUTO?";
    final static String DELETAR_OUTRO = "DESEJA DELETAR OUTRO PRODUTO?";




    

}
