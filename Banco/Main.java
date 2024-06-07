package Banco;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Cliente> listaDeClientes = new ArrayList<>();
        List<Conta> listaDeContas = new ArrayList<>();
        TesteOperacoes testeOperacoes = new TesteOperacoes(listaDeClientes, listaDeContas);
        testeOperacoes.apresentarMenu();
    }
}
