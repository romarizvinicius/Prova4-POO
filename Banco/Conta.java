package Banco;

public class Conta {
    private int numeroDaAgencia;
    private int numeroDaConta;
    private double saldo;
    private Cliente cliente;

    public Conta(int numeroDaAgencia, int numeroDaConta, double saudo, Cliente cliente) {
        this.numeroDaAgencia = numeroDaAgencia;
        this.numeroDaConta = numeroDaConta;
        this.saldo = saudo;
        this.cliente = cliente;
    }

    public int getNumeroDaAgencia() {
        return numeroDaAgencia;
    }

    public void setNumeroDaAgencia(int numeroDaAgencia) {
        this.numeroDaAgencia = numeroDaAgencia;
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public double getSaudo() {
        return saldo;
    }

    public void setSaudo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void deposito(double quantia) {
        // recebe uma quantia de dinheiro e salva nosaldo da conta
        if (quantia > 0) {
            this.saldo = this.saldo + quantia;
        }
    }

    public void saque(double quantia) {
        // remove uma quantia de dinheiro e retira do saldo da conta
        if (quantia > 0 && this.saldo >= quantia) {
            this.saldo = this.saldo - quantia;
        }
    }

    public void transferencia(Conta contaTransferencia, double quantia) {
        /*
         * recebe como parâmetro um objeto do tipo conta; transfere uma quantia do
         * saldo da conta atual para o saldo da conta que foi recebida como parâmetro.
         * Garanta que exista saldo suficiente para isso
         */
        if (quantia > 0 && this.saldo >= quantia) {
            this.saldo = this.saldo - quantia;
            contaTransferencia.deposito(quantia);
        } else {
            System.out.println("saldo insufiente");
        }
    }

    public void exibirSaldo() {
        /*
         * apresenta uma mensagem de texto informando o nome do usuário e o quanto ele
         * possui na conta
         */
        System.out.println("usuario: " + cliente.getNome() + " saldo: " + this.saldo);
    }

    /*
     * public class Main {
     * public static void main(String[] args) {
     * Cliente cliente1 = new Cliente("Vinicius", "Tijurupinga", "agricultor");
     * cliente1.exibirAtributos();
     * 
     * Cliente cliente2 = new Cliente("joao", "palestras", "engenheiro");
     * cliente2.exibirAtributos();
     * 
     * Conta conta1 = new Conta(12, 90, 1000.0, cliente1);
     * Conta conta2 = new Conta(34, 01, 500.0, cliente2);
     * 
     * conta1.exibirSaldo();
     * conta2.exibirSaldo();
     * 
     * conta1.deposito(200);
     * conta1.exibirSaldo();
     * 
     * conta1.saque(300);
     * conta1.exibirSaldo();
     * 
     * conta1.transferencia(conta2, 400);
     * conta1.exibirSaldo();
     * conta2.exibirSaldo();
     * }
     * }
     */
}
