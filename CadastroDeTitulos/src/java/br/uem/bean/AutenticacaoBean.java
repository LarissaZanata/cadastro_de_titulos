
package br.uem.bean;

import br.uem.dao.DaoLogin;
import br.uem.interfaceDao.InterfaceDaoLogin;
import br.uem.utils.ReplicaUsuarioAtual;
import java.io.Serializable;
import static java.lang.System.out;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@Named(value = "autenticacaoBean")
@SessionScoped
public class AutenticacaoBean implements Serializable{
   
    private InterfaceDaoLogin daoLogin = new DaoLogin();
    
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
        setaUsuarioAtual(this.getLogin());
        
        boolean autentica = false;
        boolean isAdm = false;
        autentica = daoLogin.validarLogin(this.getLogin(), this.getSenha());
        isAdm = daoLogin.isAdministrador(this.getLogin());
        if(autentica){
            if(isAdm){
                return "/listarTitulosAdm";
            }else{
                return "/listarTitulos";
            } 
        }else{
            FacesMessage msg = new FacesMessage("Usuário ou senha inválido!");
            FacesContext.getCurrentInstance().addMessage("erro", msg);
           return null; 
        }
        
    }
    
    private void setaUsuarioAtual(String login){
        //vem da classe gemerica somente para manter o usuário em memória
        ReplicaUsuarioAtual usuarioAtual = new ReplicaUsuarioAtual();
        usuarioAtual.usuarioAtual = login;
    }
    
    
    public String cadastrarUsuario(){
        return "/novoUsuario";
    }
    
}
