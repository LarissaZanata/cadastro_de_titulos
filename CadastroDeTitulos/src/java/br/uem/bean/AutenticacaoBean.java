
package br.uem.bean;

import br.uem.dao.DaoLogin;
import java.io.Serializable;
import static java.lang.System.out;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@Named(value = "autenticacaoBean")
@SessionScoped
public class AutenticacaoBean implements Serializable{
   private static final String USUARIO_CORRETO = "admin";
   private static final String SENHA_CORRETA = "admin";
   
   private DaoLogin daoLogin = new DaoLogin();
    
    private String login;
    private String senha;
    
    public AutenticacaoBean(){
        
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getSenha() {
        return senha;
    }


    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    public String entrar() throws Exception{
        boolean autentica = false;
        autentica = daoLogin.validarLogin(this.getLogin(), this.getSenha());
        
        if(autentica){
            return "/listarTitulosAdm";
        }else{
            FacesMessage msg = new FacesMessage("Usuário ou senha inválido!");
            FacesContext.getCurrentInstance().addMessage("erro", msg);
           return null; 
        }
        
    }
    
    
    public String cadastrarUsuario(){
        return "/novoUsuario";
    }
    
}
