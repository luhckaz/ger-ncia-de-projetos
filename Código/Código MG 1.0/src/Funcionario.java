
import java.io.Serializable;
import java.sql.Date;

public class Funcionario extends Pessoa implements Serializable{

    private String matricula;
    private String dataInicio;
    private String crm;
    
    public String getMatricula() {return matricula;}
    public void setMatricula(String matricula) {this.matricula = matricula;}
    public String getDataInicio() {return dataInicio;}
    public void setDataInicio(String dataInicio) {this.dataInicio = dataInicio;}
    public String getCrm() {return crm;}
    public void setCrm(String crm) {this.crm = crm;}
}
