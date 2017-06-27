package com.example.laboratorio.pedelanche;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.laboratorio.pedelanche.data.PedeLancheDB;
import com.example.laboratorio.pedelanche.model.Usuario;

/**
 * Created by laboratorio on 18/05/17.
 */

public class Cadastro extends AppCompatActivity {

    EditText edtNome, edtFone, edtNewPassword,edUserName, edPassword, edtConfNewPassword;
    Button btCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtFone = (EditText) findViewById(R.id.edtFone);
        edtNewPassword = (EditText) findViewById(R.id.edtNewPassword);
        edtConfNewPassword = (EditText) findViewById(R.id.edtConfNewPassword);
        btCadastrar = (Button) findViewById(R.id.btCadastrar);

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                casdastraUsuario();

            }
        });

    }

    public void casdastraUsuario() {
        String nome = edtNome.getText().toString();
        String fone = edtFone.getText().toString();
        String newPass = edtNewPassword.getText().toString();
        String confNewPass = edtConfNewPassword.getText().toString();
        Boolean validacao = true;

        if (nome == null || nome.equals("")) {
            validacao = false;
            edtNome.setError("Nome Obrigatório");
        }
        if (fone == null || fone.equals("")) {
            validacao = false;
            edtFone.setError("Telefone Obrigatório");
        }
        if (newPass == null || newPass.equals("")) {
            validacao = false;
            edtNewPassword.setError("Senha Obrigatório");
        }
        if (confNewPass == null || confNewPass.equals("")) {
            validacao = false;
            edtConfNewPassword.setError("Confirmar senha é Obrigatório");
        }
        if (! newPass.equals(confNewPass)) {

            validacao = false;
            edtNewPassword.setError("Senhas não conferem");
            edtConfNewPassword.setError("Senhas não conferem");
        }


        if(validacao){
            Usuario usuario = new Usuario();

            usuario.setNome(nome);
            usuario.setTelefone(fone);
            usuario.setSenha(newPass);

            PedeLancheDB db = new PedeLancheDB(this);

            db.addUsuario(usuario);

            Toast.makeText(Cadastro.this,"Usuário cadastrado!", Toast.LENGTH_SHORT).show();

            limpaCampos();
        }

    }

    public void limpaCampos(){
        edtNome.setText("");
        edtFone.setText("");
        edtNewPassword.setText("");
        edtConfNewPassword.setText("");
    }
}
