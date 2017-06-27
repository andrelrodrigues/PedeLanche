package com.example.laboratorio.pedelanche.data;

import android.provider.BaseColumns;

/**
 * Created by andrerodrigues on 11/06/17.
 */

//Classe de contrato, com cosntantes da tabela Produto
public final class ProtutoContract {

    public static abstract class ProdutoEntry implements BaseColumns{

        public static final String TABLE_NAME = "produto";

        public static final String _IDPROD = "_idProd";
        public static final String COLUMN_DESCRICAO = "descricao";
        public static final String COLUMN_VALOR = "valor";

    }
}
