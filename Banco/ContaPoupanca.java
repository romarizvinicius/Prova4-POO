package Banco;

public class ContaPoupanca extends Conta {
    private double taxaRendimento = 0.05;

    public ContaPoupanca(int numeroDaAgencia, int numeroDaConta, double saudo, Cliente cliente, double taxaRendimento) {
        super(numeroDaAgencia, numeroDaConta, saudo, cliente);
        this.taxaRendimento = taxaRendimento;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    public void simularOperacao() {
        /*
         * esse método deve receber como parâmetro um número inteiro, representando
         * a quantidade de meses desejados para simular o rendimento da conta poupança.
         * O método deve retornar o rendimento do saldo atual de acordo com a 
         * taxaRendimento da conta. O rendimento ocorre a cada mês a partir da seguinte 
         * fórmula: saldo + (taxaRendimento * saldo)
         */
    }
}