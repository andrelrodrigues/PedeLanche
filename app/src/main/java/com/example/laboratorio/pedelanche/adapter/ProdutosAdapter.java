package com.example.laboratorio.pedelanche.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.laboratorio.pedelanche.R;
import com.example.laboratorio.pedelanche.model.Produto;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndreRodrigues on 30/05/2017.
 */

public class ProdutosAdapter extends ArrayAdapter<Produto> {

    NumberFormat formato = NumberFormat.getCurrencyInstance();

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
        valor.setText(formato.format(produto.getValor()));

        ImageView imageView = (ImageView) itemView.findViewById(R.id.item_salgado);
        imageView.setImageDrawable(ContextCompat.getDrawable(getContext(),
                itemView.getResources().getIdentifier("salgado" + String.valueOf(produto.getIdProduto()),"drawable",
                        getContext().getPackageName())));



        return itemView;
    }
}
