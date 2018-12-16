public class SortNome extends SortConsulta{

    @Override
    protected boolean compare(Consulta a, Consulta b) {
        int c = a.getPaciente().getNome().compareTo(b.getPaciente().getNome());
        return c < 0;
    }
    
}
