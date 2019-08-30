package br.uem.bean;

import br.uem.controller.CadastroController;
import br.uem.dao.DaoLogin;
import br.uem.dao.DaoTitulo;
import br.uem.interfaceDao.InterfaceDaoLogin;
import br.uem.interfaceDao.InterfaceDaoTitulo;
import br.uem.model.Titulo;
import br.uem.utils.ReplicaUsuarioAtual;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
        boolean cadastrado = false;
        cadastrado = CadastroController.getInstance().cadastrarTitulo(this.getDescricao(), this.getDtVencimento(), this.getValor(), this.getStatus());
                
        if(cadastrado){
        FacesMessage msg = new FacesMessage("Título Cadastrado com Sucesso!");
        FacesContext.getCurrentInstance().addMessage("msg", msg);            
        }else{
        FacesMessage msg = new FacesMessage("Erro ao cadastrar titulo!");
        FacesContext.getCurrentInstance().addMessage("msg", msg);  
        }
        
        
        return "/cadastroTitulo";
    }
    
    public String voltarParaTitulos() throws Exception{ 
        String usuarioAtual = ReplicaUsuarioAtual.usuarioAtual;
        boolean isAdm = false;
        
        isAdm = CadastroController.getInstance().isAdm(usuarioAtual);
        
        if(isAdm){
            return "/listarTitulosAdm";
        }else{
           return "/listarTitulos"; 
        }
        
        
    }

    
}
