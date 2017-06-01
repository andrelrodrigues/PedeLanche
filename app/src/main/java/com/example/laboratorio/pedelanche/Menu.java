package com.example.laboratorio.pedelanche;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.laboratorio.pedelanche.model.AdaptaList;

/**
 * Created by laboratorio on 18/05/17.
 */

public class Menu extends AppCompatActivity{
    ListView listaMenu;
    String[] dados = new String[] { "Café",
            "Coxinha",
            "Torta de Frango",
            "Torta de Calabresa",
            "Torta Mista",
            "Hot Dog na Chapa",
            "Bolo no Pote",
            "Tapioca Recheada",
            "Cuscus com Manteiga",
            "Pingado 300ml",
            "Pingado Grande 500",
            "Bolo Fatia" };
    String[] valor = new String[] { "R$0,50",
            "R$2,00",
            "R$5,00",
            "R$5,00",
            "R$5,00",
            "R$5,00",
            "R$3,00",
            "R$5,00",
            "R$2,00",
            "R$1,00",
            "R$2,00",
            "R$2,00" };
    int[] listaIcon = {R.drawable.coxinha,
            R.drawable.coxinha,
            R.drawable.coxinha,
            R.drawable.coxinha,
            R.drawable.coxinha,
            R.drawable.coxinha,
            R.drawable.coxinha,
            R.drawable.coxinha,
            R.drawable.coxinha,
            R.drawable.coxinha,
            R.drawable.coxinha,
            R.drawable.coxinha};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        listaMenu = (ListView) findViewById(R.id.list_menu);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                dados
                );
        listaMenu.setAdapter(adapter);
        listaMenu.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),Integer.toString(position), Toast.LENGTH_LONG).show();
            }
        });
        AdaptaList adapterList;
    }




}



