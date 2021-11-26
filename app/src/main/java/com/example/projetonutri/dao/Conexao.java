package com.example.projetonutri.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Conexao implements Runnable {

    private Connection connection;

    private String host = "192.168.1.12";
    private String database = "nutry";
    private int port = 5432;
    private String user = "postgres";
    private String pass = "postgres";
    private String url = "jdbc:postgresql://%s:%d/%s";
    private boolean status;

    public Conexao() {
        this.url = String.format(this.url, this.host, this.port, this.database);
        this.conectar();
        this.descontectar();
    }

    @Override
    public void run() {
        try{
            Class.forName("org.postgresql.Driver");
            String user = "postgres";
            String pass = "postgres";
            String url = "jdbc:postgresql://192.168.1.12:5432/nutry";
            this.connection = DriverManager.getConnection(url, user, pass);
        }catch (Exception e){
            e.getMessage();
        }
    }

    public void conectar(){
        Thread thread = new Thread(this);
        thread.start();
        try{
            thread.join();
        }catch (Exception e){
            e.getMessage();
        }
    }

    public void descontectar(){
        if(this.connection !=null){
            try{
                this.connection.close();
            }catch (Exception e){

            }finally {
                this.connection = null;
            }
        }
    }

}

