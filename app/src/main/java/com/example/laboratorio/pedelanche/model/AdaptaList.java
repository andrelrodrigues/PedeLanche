package com.example.laboratorio.pedelanche.model;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.UserDataHandler;

import java.security.PrivateKey;

///**
// * Created by Marcos   01/06/2017.
// */

public class AdaptaList extends ArrayAdapter {
    public AdaptaList(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }
//
//    @Override
//    public void add(@Nullable Object object) {
//        super.add(object);
//    }
//
//    @Override
//    public int getCount() {
//        return super.getCount();
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//
//        View row;
//
//        row = convertView;
//        DataHandler handler;
//
//        if (convertView == null){
//            LayoutInflater inflater =(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            row = inflater.inflate(R.layout.celula_lista, parent,false);
//            handler = new DataHandler();
//            handler.imageIcone =(ImageView).row.findViewById(R.id.imageIcone);
//            handler.descricao =(TextView).row.findViewById(R.id.descricao);
//            handler.preco =(TextView).row.findViewById(R.id.preco);
//        }else{
//            handler = (DataHandler)row.getTag();
//        }
//        DataProvider dataProvider;
//        dataProvider = (DataProvider) this.getItem(position);
//        handler.imageIcone.setImageResource(dataProvider.getIcone);
//        handler.descricao.setText(dataProvider.getDesc);
//        handler.preco.setText(dataProvider.getVal);
//
//        return row;
//
//
//    }
//    private class DataHandler{
//        ImageView imageIcone;
//        TextView descricao;
//        TextView preco;
//    }
}
