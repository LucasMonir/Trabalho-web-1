package br.unisul.aula.modelo;

import br.unisul.aula.dtos.ClienteCidadeDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CidadeCLiente {
    String cidade;
    UnidadeFederativa uf;
    List<ClienteCidadeDTO> clientes;

    public CidadeCLiente() {}

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public UnidadeFederativa getUf() {
        return uf;
    }

    public void setUf(UnidadeFederativa uf) {
        this.uf = uf;
    }

    public List<ClienteCidadeDTO> getClientes() {
        return clientes;
    }

    public void setClientes(List<ClienteCidadeDTO> clientes) {
        this.clientes = clientes;
    }
}

