package com.example.laboratorio.pedelanche.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.session.PlaybackState;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.laboratorio.pedelanche.Login;
import com.example.laboratorio.pedelanche.model.Produto;
import com.example.laboratorio.pedelanche.model.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrerodrigues on 11/06/17.
 */

public class PedeLancheDB extends SQLiteOpenHelper {

    private  static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "pedelanche.db";

    public PedeLancheDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlTableProduto = "CREATE TABLE " + ProtutoContract.ProdutoEntry.TABLE_NAME + " ("+
               ProtutoContract.ProdutoEntry._IDPROD + " INTEGER PRIMARY KEY, " +
               ProtutoContract.ProdutoEntry.COLUMN_DESCRICAO + " TEXT NOT NULL, " +
                ProtutoContract.ProdutoEntry.COLUMN_VALOR + " REAL NOT NULL );";

        db.execSQL(sqlTableProduto);

        String sqlTableUsuario = "CREATE TABLE " + UsuarioContract.UsuarioEntry.TABLE_NAME + " ("+
                UsuarioContract.UsuarioEntry._IDUSER + " INTEGER PRIMARY KEY, " +
                UsuarioContract.UsuarioEntry.COLUMN_NOME + " TEXT NOT NULL, " +
                UsuarioContract.UsuarioEntry.COLUMN_TELEFONE + " TEXT NOT NULL, " +
                UsuarioContract.UsuarioEntry.COLUMN_SENHA + " TEXT NOT NULL);";

        db.execSQL(sqlTableUsuario);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public  void addProduto(Produto produto){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(ProtutoContract.ProdutoEntry._IDPROD, produto.getIdProduto());
        values.put(ProtutoContract.ProdutoEntry.COLUMN_DESCRICAO, produto.getProduto());
        values.put(ProtutoContract.ProdutoEntry.COLUMN_VALOR, produto.getValor());

        db.insert(ProtutoContract.ProdutoEntry.TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<Produto> listaProdutos(){

        ArrayList<Produto> listProdutos = new ArrayList<>();

        String query = "SELECT * FROM " + ProtutoContract.ProdutoEntry.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()){
            do {
                Produto produto = new Produto();

                produto.setIdProduto(Integer.parseInt(cursor.getString(0)));
                produto.setProduto(cursor.getString(1));
                produto.setValor(Double.parseDouble(cursor.getString(2)));

                listProdutos.add(produto);

            } while (cursor.moveToNext());
        }
        db.close();
        return listProdutos;

    }


    public void addUsuario(Usuario usuario){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(UsuarioContract.UsuarioEntry.COLUMN_NOME, usuario.getNome());
        values.put(UsuarioContract.UsuarioEntry.COLUMN_TELEFONE, usuario.getTelefone());
        values.put(UsuarioContract.UsuarioEntry.COLUMN_SENHA, usuario.getSenha());

        db.insert(UsuarioContract.UsuarioEntry.TABLE_NAME, null, values);
        db.close();

    }

    public String selecionaUsuario(String usuario){

        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "Select " + UsuarioContract.UsuarioEntry.COLUMN_NOME + ", " +
                UsuarioContract.UsuarioEntry.COLUMN_SENHA + " from "+
                UsuarioContract.UsuarioEntry.TABLE_NAME;

        Cursor cursor = db.rawQuery(sql,null);

        String usuario1, senha;

        senha ="Usuario inesistente";

        if(cursor.moveToFirst()){
            do {

                usuario1 = cursor.getString(0);
                Log.d("USUARIO: ", usuario1);

                if (usuario1.equals(usuario)){

                    senha = cursor.getString(1);
                    Log.d("SENHA: ", senha);


                    break;
                }


            }while (cursor.moveToNext());
        }


        return senha;
    }
}
