import java.rmi.*;
import java.util.List;

public interface Conversao extends Remote {
    public float realParaDolar(float real) throws RemoteException;
    public float dolarParaReal(float dolar) throws RemoteException;
    public float realParaEuro(float real) throws RemoteException;
    public float euroParaReal(float euro) throws RemoteException;
}

