import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ConversaoServidor extends UnicastRemoteObject implements Conversao {

    protected ConversaoServidor() throws RemoteException {
        super();
    }

    @Override
    public float realParaDolar(float real) throws RemoteException{
        return real * (1.0f/4.96f);
    }

    @Override
    public float dolarParaReal(float dolar) throws RemoteException{
        return dolar * 4.96f;
    }

    @Override
    public float realParaEuro(float real) throws RemoteException{
        return real * (1.0f/5.35f);
    }

    @Override
    public float euroParaReal(float euro) throws RemoteException{
        return euro * 5.35f;
    }

    public static void main(String[] args) {
        try {
            ConversaoServidor servidor = new ConversaoServidor();
            java.rmi.Naming.rebind("rmi://127.0.0.1:11099/RMIInterface", servidor);
            System.out.println("Servidor pronto para receber chamadas remotas...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

