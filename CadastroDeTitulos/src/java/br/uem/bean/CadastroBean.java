package br.uem.bean;

import br.uem.controller.CadastroController;
import br.uem.model.Titulo;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.swing.JOptionPane;


@Named(value = "cadastroBean")
@SessionScoped
public class CadastroBean implements Serializable {
    
    private String descricao;
    private String dtVencimento;
    private String valor;
    private String status;

    
    public CadastroBean(){
        
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
    
    
    public String cadastrar() {
        CadastroController.getInstance().salvarTitulo(new Titulo(descricao, dtVencimento, valor, status));
        return "/cadastroTitulo";
    }
    
    public String voltarParaTitulos() {      
        return "/listarTitulosAdm";
    }

    
}
