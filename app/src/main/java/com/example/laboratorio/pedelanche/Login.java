package com.example.laboratorio.pedelanche;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laboratorio.pedelanche.data.PedeLancheDB;
import com.example.laboratorio.pedelanche.model.Produto;

import java.util.List;

/**
 * Created by laboratorio on 18/05/17.
 */

public class Login extends AppCompatActivity {

    EditText edUserName, edPassword;
    CheckBox ckLembrar;
    TextView tvCadastro;
    Button btLogin;

    PedeLancheDB db = new PedeLancheDB(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        edUserName = (EditText) findViewById(R.id.edUserName);
        edPassword = (EditText) findViewById(R.id.edPassword);
        ckLembrar = (CheckBox) findViewById(R.id.ckLembrar);
        tvCadastro = (TextView) findViewById(R.id.tvCadastro);
        btLogin = (Button) findViewById(R.id.btLogin);

        List<Produto> listaProduto = db.listaProdutos();
// Metodo que verifica se o campo usuário e senha foram preenchidos.

        btLogin.setOnClickListener(new View.OnClickListener() {
            Boolean valida = true;
            @Override
            public void onClick(View v) {

                if(edUserName.equals("")){
                    valida = false;
                    Toast.makeText(getApplicationContext(), "Digite o usuário",Toast.LENGTH_LONG).show();
                    edPassword.requestFocus();
                }if(edPassword.equals("")){
                    valida = false;
                    Toast.makeText(getApplicationContext(), "Digite o usuário",Toast.LENGTH_LONG).show();
                    edPassword.requestFocus();
                }if (edUserName!= null && edPassword != null){
                    Intent intent = new Intent(Login.this, Menu.class);
                    startActivity(intent);
                }
            }
        });

        tvCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Cadastro.class);
                startActivity(intent);
            }
        });

    }
}
