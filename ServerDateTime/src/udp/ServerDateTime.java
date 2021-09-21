package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Wesley
 */
public class ServerDateTime extends Thread {
    
    // Parametros de comunicacao
    private final String URL = "127.0.0.1";
    private final int PORT_RECEIVE = 12345;
    private final int PORT_SEND = 54321;
    
    enum DateTimeFormat { DATE, TIME, DATETIME, DEFAULT }
    
    public ServerDateTime(){
        System.out.println("------------------------------");
        System.out.println(" Server running on port " + PORT_RECEIVE);
        System.out.println("------------------------------");
    }
   
    public int datetimeParser(String message) {
        switch (message) {
            case "date" -> {
                return 0;
            }
            case "time" -> {
                return 1;
            }
            case "realtime" -> {
                return 2;
            }
        }
        return 3;
    }
    
    public void clock() {
        Thread clock = new Thread() {
            public void run() {
                try {
                    for (;;) {
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                        LocalDateTime CurrDatetime = LocalDateTime.now();
                        dtf.format(CurrDatetime);
                        sleep(1000);
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        
        clock.start();
    }
    
    public String datetimeFormat(String dtFormat) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dtFormat);
        LocalDateTime CurrDatetime = LocalDateTime.now();
        return dtf.format(CurrDatetime);
    }
    
    public String getResponse(String message) {
        int datetimeType = datetimeParser(message);
        
        DateTimeFormat whichView = DateTimeFormat.values()[datetimeType];
        switch (whichView) {
            case DATE -> {
                return datetimeFormat("dd/MM/yyyy");
            }
            case TIME -> {
                return datetimeFormat("HH:mm:ss");
            }
            case DATETIME -> {
                return datetimeFormat("dd/MM/yyyy HH:mm:ss");
            }
            case DEFAULT -> {
                return "Ops, opção inválida!";
            }
        }
        
        return "Ops, opção inválida!";
    }
    
    public void response(String message){
        String messageRes = getResponse(message);
        
        try {
            // Converter a mensagem em bytes
            byte[] buffer = messageRes.getBytes();
            
            // Criar o pacote que será transmitido
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
                
                // Definir o pacote que será recebido
                DatagramPacket packet = new DatagramPacket(
                    buffer, buffer.length
                );
                
                // Receber o pacote
                srv.receive(packet);
                
                // Transformar o pacote no tipo de dados esperado
                String messageReq = new String(packet.getData()).trim();
               
                if (messageReq.length() > 0) {
                    // Resquets log
                    System.out.println(
                        "From: " + packet.getAddress().getHostAddress() + 
                        ":" + packet.getPort() + "\n" +
                        "Message: " + messageReq + "\n"
                    );

                    // Response
                    response(messageReq);
                }
            }
        } catch (IOException e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new ServerDateTime().start();
    }
}
