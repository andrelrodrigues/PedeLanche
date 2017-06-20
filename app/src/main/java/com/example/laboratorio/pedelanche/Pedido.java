package com.example.laboratorio.pedelanche;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.laboratorio.pedelanche.adapter.ProdutosAdapter;
import com.example.laboratorio.pedelanche.model.Produto;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Created by laboratorio on 18/05/17.
 */

public class Pedido extends AppCompatActivity{
    NumberFormat formato = NumberFormat.getCurrencyInstance();
    public static ArrayList<Produto> produtoPedido = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedido);
        final ListView listaPedido = (ListView) findViewById(R.id.list_pedido);
        TextView valorTotal = (TextView) findViewById(R.id.tvValorTotal);

        ArrayList<Produto> proutosPedido = Pedido.produtoPedido;

        double totalPedido = 0.0;

        ProdutosAdapter adapter = new ProdutosAdapter(this, proutosPedido);
        listaPedido.setAdapter(adapter);

        Integer tamnanho = proutosPedido.size();
        Log.d("Tamanho", tamnanho.toString());

        for(int i=0;  i < proutosPedido.size();i++){
            Produto produto = proutosPedido.get(i);
            totalPedido = totalPedido + produto.getValor();
            Log.d("Pedido ", produto.getProduto() + " " + produto.getValor() + " soma: " + valorTotal);
        }

        valorTotal.setText(formato.format(totalPedido));


    }
}
