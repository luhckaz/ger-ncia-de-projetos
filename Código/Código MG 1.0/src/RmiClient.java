import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

public class RmiClient extends UnicastRemoteObject{
    
    private IObjetoRemoto obj;
    
    protected RmiClient() throws RemoteException {
        super();
        System.setProperty( "java.security.policy","RMISecurity.policy"); 
        if (System.getSecurityManager() == null)
            System.setSecurityManager(new SecurityManager());
        try {
            IObjetoRemoto r = (IObjetoRemoto) Naming.lookup("//localhost:9999/RmiService");
            obj = r;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar: "+ex.getMessage());  
        }
    }
    
    
    public Cliente getCliente(String valor) throws RemoteException{
        return obj.getCliente(valor);
    }
    
    public Funcionario getFuncionario(String valor) throws RemoteException{
        return obj.getFuncionario(valor);
    }
    
    public void setConsulta(Consulta novo) throws RemoteException{
        obj.setConsulta(novo);
    }
    
    public Consulta getConsultaAtual() throws RemoteException{
        Consulta c = obj.getConsultaAtual();
        return c;
    }
    
    public Iterator<Consulta> getConsultaHoje() throws RemoteException{
        List<Consulta> lista = obj.getConsultaHoje();
        System.out.println(lista.size());
        return lista.iterator();
    }
    
    public void setCliente(Cliente novo) throws RemoteException{
        obj.setCliente(novo);
    }
    
    public Iterator<Consulta> getConsultaCliente(String valor) throws RemoteException{
        Iterator<Consulta> r = obj.getConsultaCliente(valor).iterator();
        return r;
    }
    
    public Iterator<Consulta> getConsultaFuncionario(String valor) throws RemoteException{
        List<Consulta> lista = obj.getConsultaFuncionario(valor);
        return lista.iterator();
    }
    
    public void consultaDecricao(String codigo,String valor) throws RemoteException{
        obj.inserirDescricao(codigo, valor);
    }
    
    public String getDescricao(String codigo) throws RemoteException{
        return obj.getDescricao(codigo);
    }
}
