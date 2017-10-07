package br.com.app.challenge.br.com.app.challenge.model;

import java.util.List;

/**
 * Created by gvdambros on 10/7/17.
 */

public class Usuario {
    String nome;
    String telefone;
    String endereço;

    public Usuario(String nome, String telefone, String endereço) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereço = endereço;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }
}
