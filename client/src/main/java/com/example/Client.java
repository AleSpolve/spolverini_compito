package com.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class Client {
    public static void main( String[] args ) throws Exception {
        Socket s = new Socket("localhost", 3000);
        boolean c=true;

        PrintWriter pr = new PrintWriter(s.getOutputStream(), true);
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));

        pr.println("Eccomi");

        while(c){

            System.out.println(br.readLine());
            String comando=tastiera.readLine();
            pr.println(comando);

            if(comando.equals("Q")){

                break;
            }
        }
        
        s.close();
    }
}
