package br.unisul.aula.dtos;

public class ClienteCidadeDTO {
    long id;
    String nome;

    public ClienteCidadeDTO(){}

    public ClienteCidadeDTO(long id, String nome){
        setId(id);
        setNome(nome);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
