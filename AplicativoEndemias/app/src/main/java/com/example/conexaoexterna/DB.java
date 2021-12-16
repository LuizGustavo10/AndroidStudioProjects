package com.example.conexaoexterna;

import java.security.spec.ECField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.xml.transform.Result;

public class DB extends _Default implements Runnable {

    private Connection conn;
    //private String host = "192.168.2.104"; //casa
    private String host = "192.168.1.9";//infomania
    private String db = "android";
    private int port = 5432;
//    private String user = "android";
//    private String pass = "*android*";
    private String user = "postgres";
    private String pass = "postgres";
    private String url = "jdbc:postgresql://%s:%d/%s";

    public DB() {
        super();
        this.url = String.format(this.url, this.host, this.port, this.db);

        this.conecta();
        this.disconecta();
    }

    @Override
    public void run() {
        try {
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection(this.url, this.user, this.pass);

        }catch (Exception e) {
            this._mensagem = e.getMessage();
            this._status = false;
        }
    }

    private void conecta(){
        //A thread roda o que tem no método run
        Thread thread = new Thread(this);
        thread.start();
        try {
            thread.join(); //espera a conclusão do métod run
        }catch (Exception e){
            this._mensagem = e.getMessage();
            this._status = false;
//            e.printStackTrace();
        }
    }

    private void disconecta(){
        if(this.conn!= null) {
            try {
                this.conn.close();
            }catch (Exception e){

            }finally {
                this.conn = null;
            }
        }
    }

    public ResultSet select(String query){
        this.conecta();
        ResultSet resultSet = null;
        try {
            resultSet = new executeDB(this.conn, query).execute().get();
        }catch (Exception e){
            this._status = false;
            this._mensagem = e.getMessage();
        }
        return resultSet;
    }

    public ResultSet execute(String query){
        this.conecta();
        ResultSet resultSet = null;
        try {
            resultSet = new executeDB(this.conn, query).execute().get();
        }catch (Exception e){
            this._status = false;
            this._mensagem = e.getMessage();
//            e.printStackTrace();
        }
        return resultSet;
    }
}
