package com.example.laboratorio.pedelanche.model;

/**
 * Created by AndreRodrigues on 30/05/2017.
 */

public class Usuario {

    private int idUsuario;
    private String nome;
    private String telefone;
    private String senha;

    public Usuario(){

    }

    public  Usuario(int idUsuario, String nome, String telefone, String senha ){

        this.idUsuario = idUsuario;
        this.nome = nome;
        this.telefone = telefone;
        this.senha = senha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
