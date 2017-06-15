package com.example.laboratorio.pedelanche;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.laboratorio.pedelanche.data.PedeLancheDB;
import com.example.laboratorio.pedelanche.model.Produto;
import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private GifImageView gifImageView;
    private ProgressBar progressBar;
    private static int SPLASH_TIME_OUT = 9000;

    PedeLancheDB db = new PedeLancheDB(this);

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent i = new Intent(MainActivity.this, Login.class);
//                startActivity(i);
//                finish();
//            }
//        },SPLASH_TIME_OUT);
//    }
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Setar ImageView

    gifImageView = (GifImageView) findViewById(R.id.gifImageView);


    try {
        InputStream inputStream = getAssets().open("splash.gif");
        byte[] bytes = IOUtils.toByteArray(inputStream);
        gifImageView.setBytes(bytes);
        gifImageView.startAnimation();

    }
    catch (IOException e)
    {

    }
    // Tempo de espera 3seg

    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            MainActivity.this.startActivity(new Intent(MainActivity.this, Login.class));
            MainActivity.this.finish();

            incluiProduto();

        }
    },SPLASH_TIME_OUT);
}

public void incluiProduto(){
    db.addProduto(new Produto(1,"Coxinha",3.00));
    db.addProduto(new Produto(2,"Empada de Frango",3.00));
    db.addProduto(new Produto(3,"Empada de Palmito",3.50));
    db.addProduto(new Produto(4,"Esfiha de Carne",3.00));
    db.addProduto(new Produto(5,"Esfiha de Calabresa",3.00));
    db.addProduto(new Produto(6,"Enrolado de Salsicha",3.00));
    db.addProduto(new Produto(7,"Enrolado de Presunto e Queijo",3.00));
    db.addProduto(new Produto(8,"Kibe",3.00));
    db.addProduto(new Produto(9,"Pão Pizza",3.00));
    db.addProduto(new Produto(10,"Pão de Queijo",1.50));
    db.addProduto(new Produto(11,"Pastel de Carne",3.00));
    db.addProduto(new Produto(12,"Pastel de Queijo",3.00));
    db.addProduto(new Produto(13,"Pastel de Presunto e Queijo",3.00));
    db.addProduto(new Produto(14,"Risole de Carne",3.00));
    db.addProduto(new Produto(15,"Risole de Franco c/ Catupiry",3.50));
    db.addProduto(new Produto(16,"Risole de Queijo",3.00));
    db.addProduto(new Produto(17,"Risole de Presunto e Queijo",3.00));
    db.addProduto(new Produto(18,"Refrigerante Colca-Cola",3.50));
    db.addProduto(new Produto(18,"Refrigerante Fanta Laranja",3.50));
    db.addProduto(new Produto(18,"Refrigerante Fanta Uva",3.50));
    db.addProduto(new Produto(18,"Refrigerante Guarana",3.50));
    db.addProduto(new Produto(18,"Refrigerante Sprite",3.50));
    db.addProduto(new Produto(18,"Suco de Acerola",3.50));
    db.addProduto(new Produto(18,"Suco de Goiaba",3.00));
    db.addProduto(new Produto(18,"Suco de Laranja",3.50));
    db.addProduto(new Produto(18,"Suco de Maracuja",3.50));
    db.addProduto(new Produto(18,"Suco de Uva",4.50));

    //Toast.makeText(MainActivity.this,"Inserindo produtos na tabela",Toast.LENGTH_LONG).show();
}
}
