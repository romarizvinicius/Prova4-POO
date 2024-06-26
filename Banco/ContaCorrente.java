package Banco;

public class ContaCorrente extends Conta {
    private double taxaManutancao = 50;

    public ContaCorrente(int numeroDaAgencia, int numeroDaConta, double saldo, Cliente cliente, double taxaManutancao) {
        super(numeroDaAgencia, numeroDaConta, saldo, cliente);
        this.taxaManutancao = taxaManutancao;
    }

    public double getTaxaManutancao() {
        return taxaManutancao;
    }

    public void setTaxaManutancao(double taxaManutancao) {
        this.taxaManutancao = taxaManutancao;
    }

    public double simularOperacao(int mes) {
        /*
         * simularOperacao(): esse método deve receber como parâmetro um número inteiro,
         * representando
         * a quantidade de meses desejados para simular o valor de custo das operações
         * da conta corrente. O
         * método retorna o saldo final após o decrescimento da taxaManutencao mensal
         */
        double meuSaldo = getSaldo();
        for (int i = 0; i < mes; i++) {
            meuSaldo = meuSaldo - taxaManutancao;
        }
        return meuSaldo;
    }
    /*
     * public static void main(String[] args) {
     * 
     * Cliente cliente2 = new Cliente("joao", "palestras", "engenheiro");
     * ContaCorrente contaCorrente = new ContaCorrente(34, 01, 900, cliente2, 50);
     * 
     * int mes = 12;
     * double meuSaldo = contaCorrente.simularOperacao(mes);
     * 
     * System.out.println("saldo final: " + meuSaldo);
     * }
     */
}