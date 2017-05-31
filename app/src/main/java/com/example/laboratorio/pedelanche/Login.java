package com.example.laboratorio.pedelanche;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by laboratorio on 18/05/17.
 */

public class Login extends AppCompatActivity {

    EditText edUserName, edPassword;
    CheckBox ckLembrar;
    TextView tvCadastro;
    Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        edUserName = (EditText) findViewById(R.id.edUserName);
        edPassword = (EditText) findViewById(R.id.edPassword);
        ckLembrar = (CheckBox) findViewById(R.id.ckLembrar);
        tvCadastro = (TextView) findViewById(R.id.tvCadastro);
        btLogin = (Button) findViewById(R.id.btLogin);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
