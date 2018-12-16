

import java.rmi.Remote;
import java.rmi.RemoteException; 
import java.util.List;

public interface IObjetoRemoto extends Remote{
    public Pessoa getPessoa(int busca, String valor) throws RemoteException;
    public Cliente getCliente(String valor) throws RemoteException;
    public Funcionario getFuncionario(String valor )throws RemoteException;
    public List<Consulta> getConsultaHoje() throws RemoteException;
    public List<Consulta> getConsulta(int tipo,String valor) throws RemoteException;
    public Consulta getConsultaAtual() throws RemoteException;
    public void setCliente (Cliente novo) throws RemoteException;
    public void setFuncionario (Funcionario novo) throws RemoteException;
    public void setConsulta (Consulta novo) throws RemoteException;
    public List<Consulta> getConsultaCliente(String codigo) throws RemoteException;
    public List<Consulta> getConsultaFuncionario(String codigo) throws RemoteException;
    public void inserirDescricao(String codigo,String texto ) throws RemoteException;
    public String getDescricao(String codigo) throws RemoteException;
}
