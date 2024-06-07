package Banco;

public class ContaPoupanca extends Conta {
    private double taxaRendimento = 0.05;

    public ContaPoupanca(int numeroDaAgencia, int numeroDaConta, double saldo, Cliente cliente, double taxaRendimento) {
        super(numeroDaAgencia, numeroDaConta, saldo, cliente);
        this.taxaRendimento = taxaRendimento;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    public double simularOperacao(int mes) {
        /*
         * esse método deve receber como parâmetro um número inteiro, representando
         * a quantidade de meses desejados para simular o rendimento da conta poupança.
         * O método deve retornar o rendimento do saldo atual de acordo com a
         * taxaRendimento da conta. O rendimento ocorre a cada mês a partir da seguinte
         * fórmula: saldo + (taxaRendimento * saldo)
         */
        double meuSaldo = getSaldo();
        for (int i = 0; i < mes; i++) {
            meuSaldo = meuSaldo + (taxaRendimento * meuSaldo);
        }
        return meuSaldo;
    }
    
    /*
     * public static void main(String[] args) {
     * 
     * Cliente cliente2 = new Cliente("joao", "palestras", "engenheiro");
     * 
     * ContaPoupanca contaPoupanca = new ContaPoupanca(34, 01, 900, cliente2, 0.05);
     * int mes = 12;
     * 
     * double meuSaldo = contaPoupanca.simularOperacao(mes);
     * System.out.println("saldo final: " + meuSaldo);
     * }
     */
}