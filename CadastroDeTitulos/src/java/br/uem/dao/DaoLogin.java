
package br.uem.dao;

import br.uem.connection.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DaoLogin {
    
    private Connection connection;
    
    public DaoLogin(){
        //recebe nossa conexão com o banco de dados
        connection = SingleConnection.getConectio();
    }
    
    public boolean validarLogin(String login, String senha) throws Exception{
        String sql = "select * from usuarios where login = '" +login+"' and senha = '" + senha + "'";
        //pega os dados do banco passando o sql q a gente criou:
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        
        if(resultSet.next()){
            return true;  //possui usuario
        }else{
            return false;  //não validou usuario;
        }
    }
    
    public boolean cadastrarFuncionario(String login, String senha, String adm, String nome)throws Exception{
        //String sql = "insert into usuarios values ('" +login+"', '" + senha + "', '" + adm + "', '" + nome + "')";
        try{
            String sql = " insert into usuarios (login, senha, adm, nome)"
                + " values (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            statement.setString(2, senha);
            statement.setString(3, adm);
            statement.setString(4, nome);
            statement.execute(); 
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
