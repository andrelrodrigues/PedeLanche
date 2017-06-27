package com.example.laboratorio.pedelanche;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AlertDialogLayout;
import android.util.Log;
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

    private AlertDialog alerta;

    PedeLancheDB db = new PedeLancheDB(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
       final  ListView listaMenu = (ListView) findViewById(R.id.list_menu);

        final ArrayList<Produto> listProdutos =  db.listaProdutos();
        final ArrayList<Produto> produtoPedido = new ArrayList<>();

        ProdutosAdapter adapter = new ProdutosAdapter(this, listProdutos);

        listaMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                //Pegando produto da Array listProdutos pela posição clicada atravez do position
                Produto produto = listProdutos.get(position);

                produtoPedido.add(produto);

                caixaAlerta(produto, produtoPedido);
            }

        });

        listaMenu.setAdapter(adapter);

    }

    private void caixaAlerta(Produto produto, final ArrayList<Produto> produtoPedido){

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("O Item:");

        builder.setMessage(produto.getProduto() +" foi adicionado!" + "\nDeseja adicionar mais algum item " +
                "ou fechar o pedido?");

        builder.setPositiveButton("Adicionar itens", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Menu.this,"Adicionar mais",Toast.LENGTH_SHORT).show();
            }

        });

        builder.setNegativeButton("Fechar Pedido", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Menu.this, "Fechando Pedio", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Menu.this, Pedido.class);
                Pedido.produtoPedido = produtoPedido;
                startActivity(intent);
            }
        });

        alerta = builder.create();

        alerta.show();
    }



}



