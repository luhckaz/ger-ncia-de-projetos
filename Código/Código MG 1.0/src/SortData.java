public class SortData extends SortConsulta{

    @Override
    protected boolean compare(Consulta a, Consulta b) {
        //DD/MM/AAAA HH:MM
        int diaA = Integer.parseInt(a.getInicio().substring(0,2));
        int mesA = Integer.parseInt(a.getInicio().substring(3,5));
        int anoA = Integer.parseInt(a.getInicio().substring(6,10));
        int horaA = Integer.parseInt(a.getInicio().substring(11,13));
        int minA = Integer.parseInt(a.getInicio().substring(14,16));
        
        int diaB = Integer.parseInt(b.getInicio().substring(0,2));
        int mesB = Integer.parseInt(b.getInicio().substring(3,5));
        int anoB = Integer.parseInt(b.getInicio().substring(6,10));
        int horaB = Integer.parseInt(b.getInicio().substring(11,13));
        int minB = Integer.parseInt(b.getInicio().substring(14,16));
        
        if(anoA > anoB){
            if(mesA > mesB){
                if(diaA > diaB){
                    if(horaA > horaB){
                        if(minA > minB)
                            return true;
                    }
                }
            }
        }
        return false;
    }
    
}
