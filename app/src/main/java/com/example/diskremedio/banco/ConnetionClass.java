package com.example.diskremedio.banco;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnetionClass {
    public static Connection connectar() {
        Connection con = null;
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            String ip = "192.168.90.106";
            String database = "informacoesPh";
            String uname = "clientesefuncionario";
            String pass = "007@Mandela";
            String instance = "SMARTRESSELLDB";
            String ConnURL = "jdbc:jtds:sqlserver://" + ip + ";" + "instance=" + instance + ";databasename=" + database + ";user=" + uname + ";password=" + pass;
            con = DriverManager.getConnection(ConnURL);

        } catch (SQLException e) {
            System.out.println("erro na connexao -> "+e);
        } catch (ClassNotFoundException e) {
            System.out.println("erro na connexao2 -> "+e);
        }
        return con;
    }


}
