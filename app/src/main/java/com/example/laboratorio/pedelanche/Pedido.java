package com.example.laboratorio.pedelanche;


import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.*;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laboratorio.pedelanche.adapter.PedidoAdapter;
import com.example.laboratorio.pedelanche.model.Produto;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Created by laboratorio on 18/05/17.
 */

public class Pedido extends AppCompatActivity{

    ListView listaPedido;
    TextView valorTotal;
    Button btCancela, btFinaliza;

    NumberFormat formato = NumberFormat.getCurrencyInstance();

    public static ArrayList<Produto> produtoPedido = new ArrayList<>();
    String produtosDoPedido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedido);

        listaPedido = (ListView) findViewById(R.id.list_pedido);
        btCancela = (Button) findViewById(R.id.btnCancelaPedido);
        btFinaliza = (Button) findViewById(R.id.btnFinalizaPedido);
        valorTotal = (TextView) findViewById(R.id.tvValorTotal);

        double totalPedido = 0.0;

        final ArrayList<Produto> proutosPedido = Pedido.produtoPedido;


        PedidoAdapter adapter = new PedidoAdapter(this, proutosPedido);
        listaPedido.setAdapter(adapter);

        Integer tamnanho = proutosPedido.size();
        Log.d("Tamanho", tamnanho.toString());

        for(int i=0;  i < proutosPedido.size();i++){
            Produto produto = proutosPedido.get(i);

            totalPedido = totalPedido + produto.getValor();
            if(produtosDoPedido == null){
                produtosDoPedido = produto.getProduto() + "\n ";
            }else {
                produtosDoPedido = produtosDoPedido + produto.getProduto() + "\n";
            }

            Log.d("Pedido ", produto.getProduto() + " " + produto.getValor() + " soma: " + valorTotal);
        }

        valorTotal.setText(formato.format(totalPedido));

        //Evento de Click do botão Finalizar Pedido.
        final double finalTotalPedido = totalPedido;
        btFinaliza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double tl = finalTotalPedido;
                enviaPedido(proutosPedido, tl);

            }
        });

        //Evento de Click do botão Cancelar Pedido.
        btCancela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                setResult(1,intent);
                produtoPedido.clear();
                finish();


            }
        });


    }
    //Metodo que envia pedido por WhatsApp
    public void enviaPedido(ArrayList pd, Double tl) {
        PackageManager pm = getPackageManager();
        try {

            Intent waIntent = new Intent(Intent.ACTION_SEND);
            waIntent.setType("text/plain");
             Double total = tl;

            PackageInfo info = pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
            waIntent.setPackage("com.whatsapp");



            waIntent.putExtra(Intent.EXTRA_TEXT, produtosDoPedido + "\n Total: " + tl.toString());
            startActivity(waIntent);

        } catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(this, "WhatsApp não instalado", Toast.LENGTH_SHORT).show();
        }
    }
}
