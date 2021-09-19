package udp.bidirecional;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.JTextArea;

/**
 *
 * @author Wesley
 */
public class Server extends Thread {
    
    // Parametros de comunicacao
    private final String URL = "127.0.0.1";
    private final int PORTA_RECEBER = 12345;
    private final int PORTA_ENVIAR  = 54321;
    
    private JTextArea txt;
    
    public Server(JTextArea txt){
        this.txt = txt;
        
        System.out.println("-------------------------------------");
        System.out.println(" Servidor iniciado na porta " + PORTA_RECEBER);
        System.out.println("-------------------------------------");
    }
   
    public void send(String msg){
        try {
            // Converter a mensagem em bytes
            byte[] buffer = msg.getBytes();
            
            // Criar o pacote que será transmitido
            DatagramPacket pacote = new DatagramPacket(
                    buffer,                     // Conteudo
                    buffer.length,              // Tamanho
                    InetAddress.getByName(URL), // Endereco
                    PORTA_ENVIAR                // Porta
            );
            
            // Enviar o pacote
            new DatagramSocket().send(pacote);
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }    
    
    @Override
    public void run() {
        try {
            // Criar um socket do tipo UDP
            DatagramSocket srv = new DatagramSocket(PORTA_RECEBER);
            
            while(true) {
                // Definir o buffer para recebimento da mensagem
                byte[] buffer = new byte[256];
                
                // Definir o pacote que será recebido
                DatagramPacket pacote = new DatagramPacket(
                    buffer, buffer.length
                );
                
                // Receber o pacote
                srv.receive(pacote);
                
                // Transformar o pacote no tipo de dados esperado
                String msg = new String(pacote.getData()).trim();
                
                // Exibir a mensagem
                System.out.println("DE 'Client': " + pacote.getAddress().getHostAddress());
                System.out.println("MSG: " + msg);
                
                // Exibir a mensagem no Text Area
                txt.append("DE Client: " + pacote.getAddress().getHostAddress() + "\n");
                txt.append("MSG: " + msg + "\n\n");
            }
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }
    
    /*public static void main(String[] args) {
        new Servidor().start();
    }*/
}
