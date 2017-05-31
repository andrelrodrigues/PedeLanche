package com.example.laboratorio.pedelanche.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.laboratorio.pedelanche.R;
import com.example.laboratorio.pedelanche.model.Produto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndreRodrigues on 30/05/2017.
 */

public class ProdutosAdapter extends ArrayAdapter<Produto> {

    public ProdutosAdapter(Context context, ArrayList<Produto> item){
        super(context, 0, (List<Produto>) item );
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //inflando o layout
        View itemView = convertView;

        //Verifica se itemView esta nula
        if (itemView == null) {
            //Infla o Layout
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.item_menu, parent, false);
        }

        //retornando item atraves da posição doparametro position
        Produto produto = getItem(position);

        TextView descricao = (TextView) itemView.findViewById(R.id.item_descricao);
        descricao.setText(produto.getProduto());

        TextView valor = (TextView) itemView.findViewById(R.id.item_valor);
        valor.setText(produto.getValor().toString());



        return itemView;
    }
}