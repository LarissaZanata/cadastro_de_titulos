package br.uem.controller;

import br.uem.dao.DaoLogin;
import br.uem.dao.DaoTitulo;
import br.uem.interfaceDao.InterfaceDaoLogin;
import br.uem.interfaceDao.InterfaceDaoTitulo;
import br.uem.model.Titulo;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


public class CadastroController{
    
    private static CadastroController instance;
    private InterfaceDaoTitulo daoTitulo = new DaoTitulo();
    private InterfaceDaoLogin daoLogin = new DaoLogin();


    public static CadastroController getInstance() {
        if (instance == null) {
            instance = new CadastroController();
        }
        return instance;
    }
    
    
    //Titulo
    public boolean cadastrarTitulo(String descricao, String dtVencimento, String valor, String status){
        return daoTitulo.gravarTitulo(descricao, dtVencimento, valor, status);
    }
    
    public boolean excluirTitulo(String titulo) throws SQLException{
        return daoTitulo.excluiTitulos(titulo);
    }
    
    public boolean salvarAlteracaoTitulo(Titulo titulo) throws SQLException{
        return daoTitulo.salvaAlteracaoTitulo(titulo);
    }
    
    public List<Titulo> recuperarTitulo() throws SQLException{
        return daoTitulo.recuperarTitulo();
    }
    
    
    //Usuário
    public boolean isAdm(String login) throws Exception{
        return daoLogin.isAdministrador(login);
    }
    
    public boolean validarLogin(String login, String senha) throws Exception{
        return daoLogin.validarLogin(login, senha);
    }
    
    public boolean cadastrarFuncionario(String login, String senha, String adm, String nome) throws Exception{
        return daoLogin.cadastrarFuncionario(login, senha, adm, nome);
    }
    
    
}
