package server;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import service.IDateTime;

/**
 *
 * @author Wesley
 */

// UnicastRemoteObject: torna os metodos da classe acessiveis remotamente
public class Server extends UnicastRemoteObject implements IDateTime {
    
    public Server() throws RemoteException{
        super();
    }

    @Override
    public String getDate() throws RemoteException {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return f.format(LocalDate.now());
    }

    @Override
    public String getTime() throws RemoteException {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("hh:mm:ss");
        return f.format(LocalTime.now());
    }

    @Override
    public String getAge(LocalDate birthDate) throws RemoteException {
        Period p = Period.between(birthDate, LocalDate.now());
        return String.format(
            "%s anos, %s meses e %s dias", 
            p.getYears(), p.getMonths(), p.getDays()
        );
    }
    
    // EXECUTAR O SERVIDOR
    public static void main(String[] args) {
        try {
            IDateTime srv = new Server();
            
            // Registrar a porta de comunicacao
            Registry rg = LocateRegistry.createRegistry(IDateTime.PORT);
            
            // Disponibilizar o servico
            rg.bind(IDateTime.SERVICE_NAME, srv);
            
            System.err.println("Servidor em execução...");
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }
}
