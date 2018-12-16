

import java.io.Serializable;
import java.sql.Date;

public class Consulta implements Serializable{
    
    private String codigo;
    private String inicio;
    private String termino;
    private Funcionario profissional;
    private Cliente paciente;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getTermino() {
        return termino;
    }

    public void setTermino(String termino) {
        this.termino = termino;
    }

    public Funcionario getProfissional() {
        return profissional;
    }

    public void setProfissional(Funcionario profissional) {
        this.profissional = profissional;
    }

    public Cliente getPaciente() {
        return paciente;
    }

    public void setPaciente(Cliente paciente) {
        this.paciente = paciente;
    }
}
