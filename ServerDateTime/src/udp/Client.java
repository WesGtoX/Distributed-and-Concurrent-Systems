package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.JTextArea;

/**
 *
 * @author Wesley
 */
public class Client extends Thread {
    
    // Parametros de comunicacao
    private final String URL = "127.0.0.1";
    private final int PORT_RECEIVE = 54321;
    private final int PORT_SEND = 12345;
    
    private JTextArea txt;
    
    public Client(JTextArea txt) {
        this.txt = txt;

        System.out.println("------------------------------");
        System.out.println(" Client running on port " + PORT_RECEIVE);
        System.out.println("------------------------------");
    }
    
    public void send(String message){
        try {
            // Converter a mensagem em bytes
            byte[] buffer = message.getBytes();
            
            // Criar o pacote que sera transmitido
            DatagramPacket packet = new DatagramPacket(
                    buffer,                     // Conteudo
                    buffer.length,              // Tamanho
                    InetAddress.getByName(URL), // Endereco
                    PORT_SEND                   // Porta
            );
            
            // Enviar o pacote
            new DatagramSocket().send(packet);
        } catch (IOException e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }
    
    @Override
    public void run() {
        try {
            // Criar um socket do tipo UDP
            DatagramSocket srv = new DatagramSocket(PORT_RECEIVE);
            
            while(true) {
                // Definir o buffer para recebimento da mensagem
                byte[] buffer = new byte[256];
                
                // Definir o pacote que sera recebido
                DatagramPacket packet = new DatagramPacket(
                    buffer, buffer.length
                );
                
                // Receber o pacote
                srv.receive(packet);
                
                // Transformar o pacote no tipo de dados esperado
                String message = new String(packet.getData()).trim();
                
                // Exibir a mensagem
                System.out.println(
                    "Server: " + packet.getAddress().getHostAddress() + 
                    ":" + packet.getPort() + "\n" +
                    "Message: " + message + "\n"
                );
                
                // Exibir a mensagem no Text Area
                txt.append(
                    "Server: " + packet.getAddress().getHostAddress() + 
                    ":" + packet.getPort() + "\n"
                );
                txt.append("Message: " + message + "\n\n");
            }
        } catch (IOException e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }
}
