package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Wesley
 */
public class Client {
    // Parametros de comunicacao
    private final String URL = "127.0.0.1";
    private final int PORTA = 12345;
    
    public Client() {}
    
    public void send(String msg){
        try {
            // Converter a mensagem em bytes
            byte[] buffer = msg.getBytes();
            
            //Criar o pacote que sera transmitido
            DatagramPacket pacote = new DatagramPacket(
                    buffer,                     // Conteudo
                    buffer.length,              // Tamanho
                    InetAddress.getByName(URL), // Endereco
                    PORTA                       // Porta
            );
            
            // Envias o pacote
            new DatagramSocket().send(pacote);
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }
}
