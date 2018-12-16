
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdapterRede implements IRede{
    
    private RmiClient rmi;
    
    public AdapterRede(){
        try {
            rmi = new RmiClient();
        } catch (RemoteException ex) {
            Logger.getLogger(AdapterRede.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Iterator<Consulta> consulta(String nome) {
        Iterator<Consulta> l = null;
        try {
            Funcionario f = rmi.getFuncionario(nome);
            l = rmi.getConsultaFuncionario(f.getCodigo());
        } catch (RemoteException ex) {
            Logger.getLogger(AdapterRede.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    @Override
    public Iterator<Consulta> buscarConsulta(String nomeCliente,String medico) {
        Iterator<Consulta> r = null;
        r = consulta(medico);
        List<Consulta> l = new ArrayList<>();
        while(r.hasNext()){
            Consulta c = r.next();
            if(c.getPaciente().getNome().equals(nomeCliente)){
                l.add(c);
            }
        }
        System.out.println(l.size());
        return l.iterator();
    }

    @Override
    public void addDescricao(Consulta c, String texto) {
        try {
            rmi.consultaDecricao(c.getCodigo(), texto);
        } catch (RemoteException ex) {
            Logger.getLogger(AdapterRede.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getDescricao(Consulta c){
        String r = null;
        try {
            r = rmi.getDescricao(c.getCodigo());
        } catch (RemoteException ex) {
            Logger.getLogger(AdapterRede.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    
}
