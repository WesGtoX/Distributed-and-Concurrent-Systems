package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDate;
import java.time.Month;
import service.IDateTime;

/**
 *
 * @author Wesley
 */
public class ClientTest {
    
    public static void main(String[] args) {
        try {
            // Registrar o Servico que sera acessado
            Registry srv = LocateRegistry.getRegistry(
                IDateTime.SERVICE_HOST,
                IDateTime.PORT
            );
            
            // Descobrir quais metodos remotos estao disponiveis
            IDateTime op = (IDateTime)srv.lookup(IDateTime.SERVICE_NAME);
            
            System.out.println("Data = " + op.getDate());
            System.out.println("Hora = " + op.getTime());
            System.out.println("Idade = " + op.getAge(
                LocalDate.of(2000, Month.JANUARY, 1)
            ));
        } catch (NotBoundException | RemoteException e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }
}
