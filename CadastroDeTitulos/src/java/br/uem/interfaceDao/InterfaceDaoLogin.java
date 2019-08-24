package br.uem.interfaceDao;

import java.sql.Connection;

public interface InterfaceDaoLogin {
    
    public boolean validarLogin(String login, String senha) throws Exception;
    public boolean cadastrarFuncionario(String login, String senha, String adm, String nome)throws Exception;
    public boolean isAdministrador(String login) throws Exception;
}
