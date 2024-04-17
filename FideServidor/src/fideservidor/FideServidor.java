
package fideservidor;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class FideServidor {

    public static void main(String[] args) {
        ServerThread[] threads = new ServerThread[200000];
        int threadCount = 0;
        
        
        ServerSocket serverSock  = null;
        try{
            serverSock = new ServerSocket(3030);
        }catch(IOException e){
            System.out.println("Error del server socket 's'");
        }
        
        
        while(true){
            Socket s1 = null;
            
            try{
                s1 = serverSock.accept();
                threads[threadCount] = new ServerThread(s1);
                threads[threadCount].start();
                threadCount++;
                
                System.out.println("Hilo Servidor Creado "+threadCount);                               
            }catch(IOException e){
                System.out.println("Error crear Hilo Servidor");
            }
            
            if(threadCount==199999){
                threadCount =0;
            }
        }
        
        
            
    
    }
    
}
