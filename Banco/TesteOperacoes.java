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

        Scanner s = new Scanner(System.in);

        try {

            System.out.println("digite o nome");
            String nome = s.nextLine();
            System.out.println("digite o endereço");
            String endereco = s.nextLine();
            System.out.println("digite a profissao");
            String profissao = s.nextLine();

            Cliente Cliente = new Cliente(nome, endereco, profissao);
            listaDeClientes.add(Cliente);

            System.out.println("digite o numero da agencia");
            int numeroDaAgencia = Integer.parseInt(s.nextLine());
            System.out.println("digite o numero da conta");
            int numeroDaConta = Integer.parseInt(s.nextLine());
            System.out.println("digite o saldo");
            double saudo = Double.parseDouble(s.nextLine());

            if (saudo < 0) {
                throw new IllegalArgumentException("ERRO o saldo nao pode ser negativo");
            }

            System.out.println("digite 1 para conta poupança ou 2 para conta corrente");
            String pcConta = s.nextLine();

            if (pcConta.equals("1")) {
                ContaPoupanca contaPoupanca = new ContaPoupanca(numeroDaAgencia, numeroDaConta, saudo, Cliente, 0.05);
                listaDeContas.add(contaPoupanca);
            } else if (pcConta.equals("2")) {
                ContaCorrente contaCorrente = new ContaCorrente(numeroDaAgencia, numeroDaConta, saudo, Cliente, 50);
                listaDeContas.add(contaCorrente);
            } else {
                throw new IllegalArgumentException("ERRO conta invalida");
            }

        } catch (NumberFormatException e) {
            System.out.println("ERRO numero da conta ou da agencia invalido");
        } catch (IllegalArgumentException e) {
            System.out.println("ERRO: " + e.getMessage());
        }

    }

    public void realizarOperacoes(int numeroDaAgenciaEnviar, int numeroDaContaEnviar, int numeroDaAgenciaReceber,
            int numeroDaContaReceber, double quantia) {

        Conta contaEnviar = null;
        Conta contaReceber = null;

        for (Conta conta : listaDeContas) {
            if (conta.getNumeroDaAgencia() == numeroDaAgenciaEnviar
                    && conta.getNumeroDaConta() == numeroDaContaEnviar) {
                contaEnviar = conta;
                break;
            }
        }

        for (Conta conta : listaDeContas) {
            if (conta.getNumeroDaAgencia() == numeroDaAgenciaReceber
                    && conta.getNumeroDaConta() == numeroDaContaReceber) {
                contaReceber = conta;
                break;
            }
        }

        if (contaEnviar != null && contaReceber != null) {
            contaEnviar.transferencia(contaReceber, quantia);
        } else {
            System.out.println("ERRO: conta nao encontrada");
        }
    }

    public void exibirSaldo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("digite o numero da agencia da conta pesquisada");
        int agencia = Integer.parseInt(scanner.nextLine());
        System.out.println("digite o numero da conta pesquisada");
        int conta = Integer.parseInt(scanner.nextLine());

        Conta contaPesquisada = null;

        for (Conta c : listaDeContas) {
            if (c.getNumeroDaAgencia() == agencia && c.getNumeroDaConta() == conta) {
                contaPesquisada = c;
                break;
            }
        }

        if (contaPesquisada != null) {
            System.out.println("digite o numero de meses para o saldo");
            int meses = Integer.parseInt(scanner.nextLine());

            double saldoSimulado = ((ContaPoupanca) contaPesquisada).simularOperacao(meses);
            System.out.println("saldo simulado apos " + meses + " meses:" + saldoSimulado);
        }
    }

    public void apresentarMenu() {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("Escolha uma operação:");
            System.out.println("1. Criar Conta");
            System.out.println("2. Realizar Operação");
            System.out.println("3. Exibir Saldo");
            System.out.println("4. Sair");

            int escolha = Integer.parseInt(s.nextLine());
            switch (escolha) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    System.out.println("digite o numero da agencia de envio:");
                    int numeroDaAgenciaEnviar = Integer.parseInt(s.nextLine());
                    System.out.println("digite o numero da conta de envio:");
                    int numeroDaContaEnviar = Integer.parseInt(s.nextLine());
                    System.out.println("digite o numero da agencia de recebimento:");
                    int numeroDaAgenciaReceber = Integer.parseInt(s.nextLine());
                    System.out.println("digite o numero da conta de recebimento:");
                    int numeroDaContaReceber = Integer.parseInt(s.nextLine());
                    System.out.println("digite a quantia a ser transferida:");
                    double quantia = Double.parseDouble(s.nextLine());
                    realizarOperacoes(numeroDaAgenciaEnviar, numeroDaContaEnviar, numeroDaAgenciaReceber,
                            numeroDaContaReceber, quantia);
                    break;
                case 3:
                    exibirSaldo();
                    break;
                case 4:
                    System.out.println("SAIU");
                    s.close();
                    return;
                default:
                    System.out.println("Opçao invalida");
                    break;
            }
        }
    }
}
