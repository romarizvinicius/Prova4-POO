package Banco;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class TesteOperacoes {
    /*
     * listaClientes: uma lista que deve armazenar todos os clientes criados
     * listaContas: uma lista que deve armazenar todas as contas criadas
     */
    private List<Cliente> listaDeClientes = new ArrayList<>();
    private List<Conta> listaDeContas = new ArrayList<>();

    public TesteOperacoes(List<Cliente> listaDeClientes, List<Conta> listaDeContas) {
        this.listaDeClientes = listaDeClientes;
        this.listaDeContas = listaDeContas;
    }

    public List<Cliente> getListaDeClientes() {
        return listaDeClientes;
    }

    public void setListaDeClientes(List<Cliente> listaDeClientes) {
        this.listaDeClientes = listaDeClientes;
    }

    public List<Conta> getListaDeContas() {
        return listaDeContas;
    }

    public void setListaDeContas(List<Conta> listaDeContas) {
        this.listaDeContas = listaDeContas;
    }

    public void criarConta() {
        /*
         * Esse método deve receber as strings: nome, endereço e profissão do cliente
         * por meio do
         * método Scanner. Em seguida, essas informações devem instanciar um objeto do
         * tipo Cliente e adicioná-lo no atributo listaClientes.
         * 
         * Receba uma string: tipoConta por meio do método Scanner, que deve informar
         * qual o tipo de conta que o usuário deseja criar (poupança ou corrente). 
         * Crie um objeto de acordo com a classe especificada.
         * 
         * Para preencher o objeto, receba dois números inteiros (número da agência e
         * conta) e um número flutuante: saldo, através do método Scanner. Adicione o objeto no
         * atributo listaContas.
         * 
         * Use o tratamento de exceções para evitar que o usuário informe números de
         * agência e conta como string, bem como para evitar que ele insira 
         * o valor do saldo menor do que zero.
         */
        Scanner s = new Scanner(System.in);

    try{

        System.out.println("digite o nome");
        String nome = s.nextLine();
        System.out.println("digite o endereço");
        String endereco = s.nextLine();
        System.out.println("digite a profissao");
        String profissao = s.nextLine();

        Cliente Cliente = new Cliente(nome, endereco, profissao);
        listaDeClientes.add(Cliente);

        System.out.println("digite o numero da agencia");
        int numeroDaAgencia = s.nextInt();
        System.out.println("digite o numero da conta");
        int numeroDaConta = s.nextInt();
        System.out.println("digite o saldo");
        float saudo = s.nextFloat();

        if (saudo < 0) {
            throw new IllegalArgumentException("PROBLEMA o saldo nao pode ser negativo");
        }

        System.out.println("digite 1 para conta poupança ou 2 para conta corrente");
        String pcConta = s.nextLine();

        if (pcConta.equals("1")){
            ContaPoupanca contaPoupanca = new ContaPoupanca(numeroDaAgencia, numeroDaConta, saudo, Cliente, 0.05);
            listaDeContas.add(contaPoupanca);
        }else if (pcConta.equals("2")){
            ContaCorrente contaCorrente = new ContaCorrente(numeroDaAgencia, numeroDaConta, saudo, Cliente, 50);
            listaDeContas.add(contaCorrente);
        }else{
            throw new IllegalArgumentException("PROBLEMA conta invalida");
        }
        
    } catch (NumberFormatException e) {
        System.out.println("Erro:");
    } catch (IllegalArgumentException e) {
        System.out.println("Erro: " + e.getMessage());
    }
    }
}