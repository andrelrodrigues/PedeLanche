package com.example.laboratorio.pedelanche;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by laboratorio on 18/05/17.
 */

public class Menu extends AppCompatActivity{
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        ListView listaMenu = (ListView) findViewById(R.id.list_menu);
        String[] dados = new String[] { "Café R$0,50", "Coxinha R$2,00", "Torta de Frango R$5,00", "Torta de Calabresa R$5,00", "Torta Mista R$5,00", "Hot Dog na Chapa R$5,00", "Bolo no Pote R$3,00", "Tapioca Recheada R$5,00", "Cuscus com Manteiga R$2,00", "Pingado 300ml R$1,00", "Pingado Grande 500 R$2,00", "Bolo Fatia R$2,00" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dados);
        listaMenu.setAdapter(adapter);
    }


}



