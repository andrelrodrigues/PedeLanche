package com.example.laboratorio.pedelanche;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.laboratorio.pedelanche.model.Produto;

import java.util.ArrayList;

/**
 * Created by laboratorio on 18/05/17.
 */

public class Pedido extends AppCompatActivity{
    public static ArrayList<Produto> produtoPedido = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedido);

        ArrayList<Produto> proutosPedido = Pedido.produtoPedido;

        Integer tamnanho = proutosPedido.size();
        Log.d("Tamanho", tamnanho.toString());

        for(int i=0;  i < proutosPedido.size();i++){
            Produto produto = proutosPedido.get(i);
            Log.d("Pedido ", produto.getProduto() + " " + produto.getValor());
        }

    }
}
