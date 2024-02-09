import java.rmi.*;
import java.util.List;

public interface Mensagens extends Remote {
    public void guardarMensagem(String mensagem) throws RemoteException;
    public List<String> listarMensagens() throws RemoteException;
    public String mostrarIP_Servidor() throws RemoteException;
    public String mostrarHoraServidor() throws RemoteException;
}

