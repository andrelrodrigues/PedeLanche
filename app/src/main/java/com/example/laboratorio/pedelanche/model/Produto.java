package com.example.laboratorio.pedelanche.model;

/**
 * Created by AndreRodrigues on 30/05/2017.
 */

public class Produto {

    private int idProduto;
    private String produto;
    private double valor;

    public  Produto(int idProduto, String produto, double valor){
        this.idProduto = idProduto;
        this.produto = produto;
        this.valor = valor;
    }

    public Produto() {

    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
