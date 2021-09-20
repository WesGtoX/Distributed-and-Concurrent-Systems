package webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Wesley
 */
public class JavaWebServer extends Thread {
    
    private final int PORTA = 8081;
    
    public JavaWebServer(){
        System.out.println("--------------------");
        System.out.println("   JAVA WEBSERVER   ");
        System.out.println("--------------------");
        System.out.println("Iniciado na porta: " + PORTA + "\n") ;
    }
    
    @Override
    public void run(){
        try {
            ServerSocket srv = new ServerSocket(PORTA);
            
            for(;;){
                System.out.println("Aguardando conexão...");
                Socket con = srv.accept();
                
                // REQUISICAO HTTP
                BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream())
                );
                
                String requisicao = br.readLine();
                System.out.println("REQUISIÇÃO: " + requisicao);
                
                //RESPOSTA HTTP
                StringBuilder response = new StringBuilder();
                response.append("HTTP/1.1 200 OK\r\n");
                response.append("\r\n");
                response.append("<html>");
                response.append("<head>");
                response.append("<meta charset='utf-8' />");
                response.append("<title>JAVA WebServer</title>");
                response.append("</head>");
                response.append("<body>");
                response.append("<h1>Hello World !!</h1>");
                response.append("<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>");
                response.append("<img src='https://picsum.photos/200/300' />");
                response.append("<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>");
                response.append("<br/><br/><br/><br/>");
                response.append("<iframe src='https://www.unaerp.br/' height=300 width=500></iframe>");
                response.append("</body>");
                response.append("</html>");
                
                con.getOutputStream().write(response.toString().getBytes());
                
                
                con.close();
            }
            
        } catch (IOException e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }
    
    // EXECUTAR O JAVA WEBSERVER
    public static void main(String[] args) {
        new JavaWebServer().start();
    }
}
