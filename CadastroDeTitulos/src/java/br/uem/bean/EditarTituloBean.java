package br.uem.bean;

import br.uem.controller.CadastroController;
import br.uem.model.Titulo;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@Named(value = "editarTitulo")
@SessionScoped
public class EditarTituloBean implements Serializable {
    
    private String descricao;
    private String dtVencimento;
    private String valor;
    private boolean status;

    
    public EditarTituloBean(){
        
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

  
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    public String salvar() throws InterruptedException {
        return "/listarTitulos";
    }   
    
}
