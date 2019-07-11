
package br.uem.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Titulo {
    private static final AtomicInteger count = new AtomicInteger(0); 
    private int id;
    private String descricao;
    private String dtVencimento;
    private String valor;
    private String status;

    
    public Titulo(String descricao, String dtVenc, String valor, String status){
        this.id=count.incrementAndGet();
        this.descricao = descricao;
        this.dtVencimento = dtVenc;
        this.valor = valor;
        this.status = status;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(String dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    
}
