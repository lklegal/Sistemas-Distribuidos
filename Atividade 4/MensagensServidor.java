import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MensagensServidor extends UnicastRemoteObject implements Mensagens {
    private List<String> listaMensagens;

    protected MensagensServidor() throws RemoteException {
        super();
        this.listaMensagens = new ArrayList<>();
    }

    @Override
    public void guardarMensagem(String mensagem) throws RemoteException {
        listaMensagens.add(mensagem);
    }

    @Override
    public List<String> listarMensagens() throws RemoteException {
        return new ArrayList<>(listaMensagens);
    }

    @Override
    public String mostrarIP_Servidor() throws RemoteException {
        try {
            java.net.InetAddress localMachine = java.net.InetAddress.getLocalHost();
            return localMachine.getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao obter o IP do servidor.";
        }
    }

    @Override
    public String mostrarHoraServidor() throws RemoteException {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(new Date());
    }

    public static void main(String[] args) {
        try {
            MensagensServidor servidor = new MensagensServidor();
            java.rmi.Naming.rebind("rmi://127.0.0.1:11099/RMIInterface", servidor);
            System.out.println("Servidor pronto para receber chamadas remotas...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

