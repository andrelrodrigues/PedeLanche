package com.example.laboratorio.pedelanche.data;

import android.provider.BaseColumns;
/**
 * Created by andrerodrigues on 13/06/17.
 */

//Classe de contrato, com cosntantes da tabela Produto
public final class UsuarioContract {

    public static abstract class UsuarioEntry implements BaseColumns {

        public static final String TABLE_NAME = "usuario";

        public static final String _IDUSER = "_idUser";
        public static final String COLUMN_NOME = "nome";
        public static final String COLUMN_TELEFONE = "telefone";
        public static final String COLUMN_SENHA = "senha";
    }

}
