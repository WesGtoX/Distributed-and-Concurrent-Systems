package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

/**
 *
 * @author Wesley
 */
public interface IDateTime extends Remote {
    // Propriedades do Servico
    public static final int PORT = 1099;
    public static final String SERVICE_NAME = "date_time";
    public static final String SERVICE_HOST = "localhost";
    
    // Assinaturas dos metodos que fazem parte do Servico
    public abstract String getDate() throws RemoteException;
    public abstract String getTime() throws RemoteException;
    public abstract String getAge(LocalDate birthDate) throws RemoteException;
}
