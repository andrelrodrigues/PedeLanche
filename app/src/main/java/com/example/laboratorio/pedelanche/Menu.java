package com.example.laboratorio.pedelanche;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.laboratorio.pedelanche.adapter.ProdutosAdapter;
import com.example.laboratorio.pedelanche.model.Produto;

import java.util.ArrayList;

/**
 * Created by laboratorio on 18/05/17.
 */

public class Menu extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        ListView listaMenu = (ListView) findViewById(R.id.list_menu);

        ArrayList<Produto> arrayList = new ArrayList<>();

        arrayList.add(new Produto("Coxinha", 2.00f));
        arrayList.add(new Produto("Torta de Frango",5.00f));
        arrayList.add(new Produto("Torta de Calabresa", 5.00f));
        arrayList.add(new Produto("Torta Mista", 5.00f));
        arrayList.add(new Produto("Hot Dog na Chapa", 5.00f));
        arrayList.add(new Produto("Bolo no Pote",3.00f));
        arrayList.add(new Produto("Tapioca Recheada", 5.00f));
        arrayList.add(new Produto("Cuscus com Manteiga", 3.00f));

        ProdutosAdapter adapter = new ProdutosAdapter(this, arrayList);

        listaMenu.setAdapter(adapter);

    }




}



