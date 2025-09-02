
package school.sptech;

import org.apache.commons.lang3.IntegerRange;

import java.net.HttpRetryException;
import java.sql.PreparedStatement;

public class Turma {
    private String nome;
    private Double mensalidade;
    private Integer qtdAluno;
    private Boolean ativa;

    public Turma(String nome, Double mensalidade){
        this.nome=nome;
        this.mensalidade=mensalidade;
        qtdAluno=0;
        ativa=true;
    }

    public void matricular(Integer qtd){
        if(qtd!=null && qtd>0 && ativa==true){
            qtdAluno=qtd;
        }
    }
    public Integer cancelar(Integer qtd){
        if(qtd!=null && qtd>0 && qtd<=qtdAluno && ativa==true){
         qtdAluno-=qtd;
         return qtdAluno;
        }
        return null;
    }
    public Integer desativar(){
        if (ativa==true) {
            ativa=false;
            this.qtdAluno=0;
            return qtdAluno;
        }else{
           return null;
        }
    }
    public void transferir(Turma destino, Integer qtdATransferir){
        if(ativa==true && destino!= null && qtdATransferir!=null && destino.ativa==true && qtdATransferir>0 && qtdATransferir<=qtdAluno){
            qtdAluno-=qtdATransferir;
            destino.qtdAluno+=qtdATransferir;
        }
    }
    public Boolean reajustarMensalidade(Double reajuste){
        if(reajuste!=null && reajuste>0){
            mensalidade+=mensalidade*reajuste;
            return true;
        }
        return false;
    }
    public String getNome(){
        return nome;
    }
    public Double getMensalidade(){
        return mensalidade;
    }
    public Integer getQtdAluno(){
        return qtdAluno;
    }
    public Boolean getAtiva(){
        return ativa;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
}
