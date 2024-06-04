package Banco;

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
}