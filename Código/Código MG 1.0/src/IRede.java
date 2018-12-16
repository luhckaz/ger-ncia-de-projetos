
import java.util.Iterator;

public interface IRede {
    public Iterator<Consulta> consulta(String matricula);
    public Iterator<Consulta> buscarConsulta(String nomeCliente,String medico);
    public void addDescricao(Consulta c,String texto);
    public String getDescricao(Consulta c);
}
