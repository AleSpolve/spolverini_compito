package com.example;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.BufferedReader;


public class ClientHandler extends Thread {

    private Socket s;
    private boolean a=true;
    // per parlare
    private PrintWriter pr=null;
    //per ascoltare
    private BufferedReader br=null;
    private static int biglietti=5;

    public ClientHandler(Socket s){
        this.s=s;
        try {
            pr=new PrintWriter(s.getOutputStream(), true);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        } catch (IOException e) {
            
            e.printStackTrace();
        }

    }

    public void run(){

        try {
            
            System.out.println(br.readLine());

        while(a){
            
            pr.println("Cosa vuoi fare?\n"); 
            String comando = br.readLine();
            
            if(comando.equals("D")){
               
                pr.println("Disponibilità di" + biglietti + "biglietti");

            }
            if(comando.equals("A")){

                if(biglietti == 0){
                    pr.println("Biglietti esauriti");
                    
                }else{
                pr.println("Biglietto acquistato");
                biglietti--;
                }

            }
            else if(comando.equals("Q")){

                pr.println("Disconnessione");
                break;
            }

        }
        pr.println("Grazie e ciao"); 

        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }


}