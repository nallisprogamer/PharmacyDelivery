package com.example.diskremedio.banco;

import android.content.Context;

import com.example.diskremedio.Pattern.MedicineItemPattern;
import com.example.diskremedio.Pattern.Produtopattern;
import com.example.diskremedio.Pattern.Vendedorpattern;

import java.util.ArrayList;
import java.util.List;

public class SyncAllDatabase {
    public static void pegando_dados_online(Context context) {
//        new Thread(() -> {
//            List<Campanhaout> listaCampanha = new ArrayList<>(SqlServer_connection.SqlServer_connection(context).getbyCampanha());
//            for (int i = 0; i < listaCampanha.size(); i++) {
//                sqlite.getINSTANCE(context).addCampanha(listaCampanha.get(i).nome_campanha, listaCampanha.get(i).tempo_duracao,
//                        listaCampanha.get(i).data_de_criacao, listaCampanha.get(i).progress, listaCampanha.get(i).notificarEm, listaCampanha.get(i).code);
//            }
//        }).start();






//        new Thread(() -> {
//            List<class_for_tree_things> listaCategoriasql = new ArrayList<>(sqlite.getINSTANCE(context).getRegisterbyCategoria());
//            List<class_for_tree_things> listaCategoria = new ArrayList<>(SqlServer_connection.SqlServer_connection(context).getbyCategoria());
//            if(listaCategoria.size()>0){
//                for (int i = 0; i < listaCategoria.size(); i++) {
//                    if(listaCategoriasql.size()<1){
//                        sqlite.getINSTANCE(context).addCategoria(listaCategoria.get(i).nome,listaCategoria.get(i).primerykey);
//                    }else{
//                        System.out.println("listaCategoria.get("+i+").primerykey -> "+listaCategoria.get(i).primerykey+
//                                " listaCategoriasql.get("+i+").primerykey -> "+listaCategoriasql.get(i).primerykey);
//                        if(!listaCategoria.get(i).primerykey.equals(listaCategoriasql.get(i).primerykey)){
//                            sqlite.getINSTANCE(context).addCategoria(listaCategoria.get(i).nome,listaCategoria.get(i).primerykey);
//                        }}
//                }}
//            listaCategoriasql.clear();
//            listaCategoria.clear();
//        }).start();


















//        new Thread(() -> {
//            List<Equipe> listaEquipe = new ArrayList<>(SqlServer_connection.SqlServer_connection(context).getAllEquipes());
//            for (int i = 0; i < listaEquipe.size(); i++) {
//                sqlite.getINSTANCE(context).addEquipe(listaEquipe.get(i).getNome_equipe(), listaEquipe.get(i).getPercent_progress_equipe());
//            }
//        }).start();
//
        //usar eventos para o agendamento
//        new Thread(() -> {
//            List<Events> listaEvents = new ArrayList<>(SqlServer_connection.SqlServer_connection(context).getByEvents());
//            for (int i = 0; i < listaEvents.size(); i++) {
//                sqlite.getINSTANCE(context).addEvento(listaEvents.get(i).getEVENT(), listaEvents.get(i).getID(), listaEvents.get(i).getTIME(),
//                        listaEvents.get(i).getDAY(), listaEvents.get(i).getMONTH(), listaEvents.get(i).getYEAR(), listaEvents.get(i).getWeekOfYear(),
//                        listaEvents.get(i).getFREQUENCIA(), listaEvents.get(i).getnotify());
//            }
//        }).start();

//        new Thread(() -> {
//            List<Registros.Fornecedor> listaFornecedor = new ArrayList<>(SqlServer_connection.SqlServer_connection(context).getbyForncedores());
//            for (int i = 0; i < listaFornecedor.size(); i++) {
//                sqlite.getINSTANCE(context).addForncedor(listaFornecedor.get(i).nomeForncedor, listaFornecedor.get(i).endereco);
//            }
//        }).start();
//
//        new Thread(() -> {
//            List<Level> listaLevel = new ArrayList<>(SqlServer_connection.SqlServer_connection(context).getbyNivel());
//            for (int i = 0; i < listaLevel.size(); i++) {
//                sqlite.getINSTANCE(context).addNivel(listaLevel.get(i).getNivel());
//            }
//        }).start();
//        new Thread(() -> {
//
//            List<Objetivo> listaObjetivo = new ArrayList<>(SqlServer_connection.SqlServer_connection(context).getObjetivos());
//            for (int i = 0; i < listaObjetivo.size(); i++) {
//                sqlite.getINSTANCE(context).addObjetivo(listaObjetivo.get(i).idinterno, listaObjetivo.get(i).nome_objetivo, listaObjetivo.get(i).quant_atual_objetivo, listaObjetivo.get(i).quant_total_objetivo, listaObjetivo.get(i).origem);
//            }
//        }).start();
        new Thread(() -> {
//            List<MedicineItemPattern> listaProduto = new ArrayList<>(SqlServer_connection.SqlServer_connection(context).getProduto());
//            for (int i = 0; i < listaProduto.size(); i++) {
//                sqlite.getINSTANCE(context).addProduto(listaProduto.get(i).nome, listaProduto.get(i).id, listaProduto.get(i).valor_compra, listaProduto.get(i).valor_venda,
//                        listaProduto.get(i).estoque_minimo, listaProduto.get(i).estoque_atual, listaProduto.get(i).observacoes,
//                        listaProduto.get(i).ifhasdiscount, listaProduto.get(i).discount, listaProduto.get(i).ifhasparcels, listaProduto.get(i).parcels,
//                        listaProduto.get(i).categoria, listaProduto.get(i).fornecedor);
//                    listaProduto.get(i).setNunComments();listaProduto.get(i).setStar();
//            }
        }).start();

        new Thread(() -> {
//            List<Vendedorpattern> listaVendedor = new ArrayList<>(SqlServer_connection.SqlServer_connection(context).getbyVendedor());
//            for (int i = 0; i < listaVendedor.size(); i++) {
//                sqlite.getINSTANCE(context).addVendedor(listaVendedor.get(i).getNomeVendedor(), listaVendedor.get(i).getComissao(),
//                        listaVendedor.get(i).getCodigo(), listaVendedor.get(i).getnivel());
//            }
        }).start();


    }

    public static void local_to_on(Context context) {
//        new Thread(() -> {
//            List<Campanhaout> listaCampanha = new ArrayList<>(sqlite.getINSTANCE(context).getRegisterbyCampanha());
//            for (int i = 0; i < listaCampanha.size(); i++) {
//                SqlServer_connection.SqlServer_connection(context).addCampanha(listaCampanha.get(i).nome_campanha, listaCampanha.get(i).tempo_duracao,
//                        listaCampanha.get(i).data_de_criacao, listaCampanha.get(i).progress,
//                        listaCampanha.get(i).notificarEm, listaCampanha.get(i).code);
//            }
//        }).start();
//        new Thread(() -> {
//            List<class_for_tree_things> listaCategoria = new ArrayList<>(sqlite.getINSTANCE(context).getRegisterbyCategoria());
//            for (int i = 0; i < listaCategoria.size(); i++) {
//                SqlServer_connection.SqlServer_connection(context).addCategoria(listaCategoria.get(i).primerykey,listaCategoria.get(i).nome);
//            }
//        }).start();
//        new Thread(() -> {
//            List<Equipe> listaEquipe = new ArrayList<>(sqlite.getINSTANCE(context).getAllEquipes());
//            for (int i = 0; i < listaEquipe.size(); i++) {
//                SqlServer_connection.SqlServer_connection(context).addEquipe(listaEquipe.get(i).getNome_equipe(),
//                        listaEquipe.get(i).getPercent_progress_equipe());
//            }
//        }).start();
//
//        new Thread(() -> {
//            List<Events> listaEvents = new ArrayList<>(sqlite.getINSTANCE(context).getAllEvento());
//            for (int i = 0; i < listaEvents.size(); i++) {
//                SqlServer_connection.SqlServer_connection(context).addEvento(listaEvents.get(i).getEVENT(), listaEvents.get(i).getTIME(),
//                        listaEvents.get(i).getDAY(), listaEvents.get(i).getMONTH(), listaEvents.get(i).getYEAR(), listaEvents.get(i).getnotify(),
//                        listaEvents.get(i).getFREQUENCIA(), listaEvents.get(i).getWeekOfYear(), listaEvents.get(i).getID());
//            }
//        }).start();
//
//        new Thread(() -> {
//            List<Registros.Fornecedor> listaFornecedor = new ArrayList<>(sqlite.getINSTANCE(context).getRegisterbyForncedores());
//            for (int i = 0; i < listaFornecedor.size(); i++) {
//                SqlServer_connection.SqlServer_connection(context).addForncedor(listaFornecedor.get(i).nomeForncedor, listaFornecedor.get(i).endereco);
//            }
//        }).start();
//
//        new Thread(() -> {
//            List<Level> listaLevel = new ArrayList<>(sqlite.getINSTANCE(context).getRegisterbyNivel());
//            for (int i = 0; i < listaLevel.size(); i++) {
//                SqlServer_connection.SqlServer_connection(context).addNivel(listaLevel.get(i).getNivel());
//            }
//        }).start();
//        new Thread(() -> {
//
//            List<Objetivo> listaObjetivo = new ArrayList<>(sqlite.getINSTANCE(context).getRegisterObjetivos());
//            for (int i = 0; i < listaObjetivo.size(); i++) {
//                SqlServer_connection.SqlServer_connection(context).addObjetivo(listaObjetivo.get(i).idinterno, listaObjetivo.get(i).nome_objetivo,
//                        listaObjetivo.get(i).quant_atual_objetivo, listaObjetivo.get(i).quant_total_objetivo, listaObjetivo.get(i).origem);
//
//            }
//        }).start();
//        new Thread(() -> {
//            List<Registros.Produto> listaProduto = new ArrayList<>(sqlite.getINSTANCE(context).getallProduto());
//            for (int i = 0; i < listaProduto.size(); i++) {
//                SqlServer_connection.SqlServer_connection(context).addProduto(listaProduto.get(i).nome, listaProduto.get(i).id, listaProduto.get(i).valor_compra, listaProduto.get(i).valor_venda,
//                        listaProduto.get(i).estoque_minimo, listaProduto.get(i).estoque_atual, listaProduto.get(i).observacoes,
//                        listaProduto.get(i).ifhasdiscount, listaProduto.get(i).discount, listaProduto.get(i).ifhasparcels, listaProduto.get(i).parcels,
//                        listaProduto.get(i).categoria, listaProduto.get(i).fornecedor);
//            }
//        }).start();
//
        new Thread(() -> {
//            List<Vendedorpattern> listaVendedor = new ArrayList<>(sqlite.getINSTANCE(context).getRegisterbyVendedor());
//            for (int i = 0; i < listaVendedor.size(); i++) {
//                SqlServer_connection.SqlServer_connection(context).addVendedor(listaVendedor.get(i).getNomeVendedor(), listaVendedor.get(i).getComissao(),
//                        listaVendedor.get(i).getCodigo(), listaVendedor.get(i).getnivel());
//}

        }).start();
//
//
    }
}
