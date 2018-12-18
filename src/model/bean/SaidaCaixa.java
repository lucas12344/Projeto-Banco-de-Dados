package model.bean;

import java.util.Date;


public class SaidaCaixa {
    
   private int id;
   private String tipo;
   private String descricao;
   private String dataregistro;
   private double valor;


    public String getDataregistro() {
        return dataregistro;
    }

    public void setDataregistro(String dataregistro) {
        this.dataregistro = dataregistro;
    }
 


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
