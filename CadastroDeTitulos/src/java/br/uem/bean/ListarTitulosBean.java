
package br.uem.bean;

import br.uem.controller.CadastroController;
import br.uem.model.Titulo;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
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
    
    
    public List<Titulo> getTitulos() {
        return CadastroController.getInstance().listarTitulos();
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
    
    public String excluirTitulo(Titulo titulo){
      CadastroController.getInstance().excluirTitulo(titulo);
        return "/listarTitulos";
    }
    
    public String editarTitulo(Titulo titulo){
        this.setTitulo(titulo);
        CadastroController.getInstance().editarTitulo(titulo);
        return "/editarTitulo";
    }

    public String sair(){
        return "index";
    }
    

}
