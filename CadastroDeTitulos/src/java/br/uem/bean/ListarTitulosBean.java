
package br.uem.bean;

import br.uem.controller.CadastroController;
import br.uem.dao.DaoTitulo;
import br.uem.interfaceDao.InterfaceDaoTitulo;
import br.uem.model.Titulo;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@Named(value = "listarTitulos")
@SessionScoped
public class ListarTitulosBean implements Serializable{
    private Titulo titulo;
    private String descricao;
    private String dtVencimento;
    private String valor;
    private String status;
    
    
    public ListarTitulosBean() {
    }
    
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return descricao;
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

  
    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    public List<Titulo> getTitulos() throws SQLException {
    return CadastroController.getInstance().recuperarTitulo();
    }
    
    
    public Titulo getTitulo() {
        return titulo;
    }
    
    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }
    
    public String cadastrarNovoTitulo(){
        return "/cadastroTitulo";
    }
    
    public String excluirTitulo(String titulo) throws SQLException{
        boolean tituloExluido=  false;
        
        tituloExluido = CadastroController.getInstance().excluirTitulo(titulo);
        
        if(tituloExluido){
        FacesMessage msg = new FacesMessage("Título Excluido com Sucesso!");
        FacesContext.getCurrentInstance().addMessage("msg", msg);            
        }else{
        FacesMessage msg = new FacesMessage("Erro ao excluir titulo!");
        FacesContext.getCurrentInstance().addMessage("msg", msg);  
        }
        
        return "/listarTitulosAdm";
    }
    
    public String editarTitulo(Titulo titulo) throws SQLException{
        this.setTitulo(titulo);
        return "/editarTitulo";
    }

    public String sair(){
        return "index";
    }
    
    
    

}
