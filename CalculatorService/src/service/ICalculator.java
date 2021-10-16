package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Wesley
 */
public interface ICalculator extends Remote {
    // Propriedades do Servico
    public static final int PORT = 2121;
    public static final String SERVICE_NAME = "calculator";
    public static final String SERVICE_HOST = "localhost";
    
    // Assinaturas dos metodos que fazem parte do Servico
    public abstract double getSum(double x, double y) throws RemoteException;
    public abstract double getSubtraction(double x, double y) throws RemoteException;
    public abstract double getMultiplication(double x, double y) throws RemoteException;
    public abstract double getDivision(double x, double y) throws RemoteException;
    public abstract double getSquareRoot(double n) throws RemoteException;
    public abstract double getPotentiation(double b, double e) throws RemoteException;
    public abstract double getLogarithm(double n) throws RemoteException;
    public abstract double getFahrenheitToCelsius(double n) throws RemoteException;
    public abstract double getCelsiusToFahrenheit(double n) throws RemoteException;
}
