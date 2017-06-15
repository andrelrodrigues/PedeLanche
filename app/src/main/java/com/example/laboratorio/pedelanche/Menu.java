package com.example.laboratorio.pedelanche;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.laboratorio.pedelanche.adapter.ProdutosAdapter;
import com.example.laboratorio.pedelanche.data.PedeLancheDB;
import com.example.laboratorio.pedelanche.model.Produto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laboratorio on 18/05/17.
 */

public class Menu extends AppCompatActivity{

    PedeLancheDB db = new PedeLancheDB(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        ListView listaMenu = (ListView) findViewById(R.id.list_menu);

        ArrayList<Produto> listProdutos =  db.listaProdutos();

        ProdutosAdapter adapter = new ProdutosAdapter(this, listProdutos);

        listaMenu.setAdapter(adapter);

    }



}



