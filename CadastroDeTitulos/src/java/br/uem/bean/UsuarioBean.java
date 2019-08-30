package br.uem.bean;


import br.uem.controller.CadastroController;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import br.uem.dao.DaoLogin;
import br.uem.interfaceDao.InterfaceDaoLogin;

@Named(value = "usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable{
    private String usuario;
    private String senha;
    private String confirmaSenha;
    private String nome;
    private String adm;
    
   // private InterfaceDaoLogin daoLogin = new DaoLogin();

    
    public UsuarioBean(){
    
    }

    public String getSenha() {
        return senha;
    }


    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getAdm() {
        return adm;
    }


    public void setAdm(String adm) {
       this.adm = adm;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    public String novoUsuario() throws Exception{
        boolean cadastrado = false;
        
        if(verificaSenhas(this.getSenha(), this.getConfirmaSenha())){
           cadastrado = CadastroController.getInstance().cadastrarFuncionario(this.getUsuario(), this.getSenha(), this.getAdm(), this.getNome());
        }else{
            FacesMessage msg = new FacesMessage("Senhas diferentes!");
            FacesContext.getCurrentInstance().addMessage("erro", msg); 
        }

        //verifica se cadastro deu certo
        if(cadastrado){
            FacesMessage msg = new FacesMessage("Cadastrado com Sucesso!");
            FacesContext.getCurrentInstance().addMessage("sucesso", msg);
            Thread.sleep(1000);
            return "/index";
        }else{
            FacesMessage msg = new FacesMessage("Erro ao cadastrar usuário!");
            FacesContext.getCurrentInstance().addMessage("erro", msg);
           return null; 
        }
        
    }
    
    private boolean verificaSenhas(String senha1, String senha2){
        if(senha1.equals(senha2)){
            return true;
        }else{
            return false;
        }
    }


    public String CancelaCadastro(){
        return "/index";
    }
    
}
