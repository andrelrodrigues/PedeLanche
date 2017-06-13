package com.example.laboratorio.pedelanche.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
}
