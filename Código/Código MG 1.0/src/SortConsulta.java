import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class SortConsulta {
    public Iterator<Consulta> sort(Iterator<Consulta> consultas){
        List<Consulta> lista = new ArrayList<>();
        while(consultas.hasNext())
            lista.add(consultas.next());
        for(int i = 1;i < lista.size();i++){
            Consulta aux = lista.get(i);
            int j = i;
            while((j>0) && (compare(lista.get(j-1),aux))){
                lista.set(j, lista.get(j-1));
                j -= 1;
            }
            lista.set(j, aux);
        }
        return lista.iterator();
    }
    protected abstract boolean compare(Consulta a,Consulta b);
}
