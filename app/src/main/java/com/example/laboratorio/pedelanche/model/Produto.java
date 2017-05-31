package com.example.laboratorio.pedelanche.model;

/**
 * Created by AndreRodrigues on 30/05/2017.
 */

public class Produto {

    private int idProduto;
    private String produto;
    private Float valor;

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

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
}
