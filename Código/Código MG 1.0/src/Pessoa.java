

import java.io.Serializable;
import java.sql.Date;

public class Pessoa implements Serializable{
    
    //Atributos
    private String codigo;
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String endereco;
    private String[] telefone;
    
    //Metodos
    public String getCodigo() {return codigo;}
    public void setCodigo(String codigo) {this.codigo = codigo;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getCpf() {return cpf;}
    public void setCpf(String cpf) {this.cpf = cpf;}
    public String getDataNascimento() {return dataNascimento;}
    public void setDataNascimento(String dataNascimento) {this.dataNascimento = dataNascimento;}
    public String getEndereco() {return endereco;}
    public void setEndereco(String endereco) {this.endereco = endereco;}
    public String[] getTelefone() {return telefone;}
    public void setTelefone(String[] telefone) {this.telefone = telefone;}
}
