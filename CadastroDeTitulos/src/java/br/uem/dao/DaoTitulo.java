package br.uem.dao;

import br.uem.connection.SingleConnection;
import br.uem.interfaceDao.InterfaceDaoTitulo;
import br.uem.model.Titulo;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class DaoTitulo implements InterfaceDaoTitulo {
       
    private Connection connection;
    
    public DaoTitulo(){
        //recebe nossa conexão com o banco de dados
        connection = SingleConnection.getConectio();
    }
    
    
    public boolean gravarTitulo(String descricao, String dtVencimento, String valor, String status){
        long codigo = (long) (000001 + Math.random() * 100000);
        
        try{
            String sql = " insert into titulos (codigo, descricao, dtvencimento, valor, status)"
                + " values (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(codigo));
            statement.setString(2, descricao);
            statement.setString(3, dtVencimento);
            statement.setString(4, valor);
            statement.setString(5, status);
            statement.execute(); 
            return true; 
        }
        catch (SQLException e){
            return false;
        }
    }
    
    
    public ArrayList<Titulo> recuperarTitulo() throws SQLException{
        ArrayList<Titulo> titulos = new ArrayList();
        String sql = "SELECT codigo, descricao, dtvencimento, valor, status FROM titulos;";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()){
            String codigo = resultSet.getString("codigo");
            String descricao = resultSet.getString("descricao");
            String dtvencimento = resultSet.getString("dtvencimento");
            String valor = resultSet.getString("valor");
            String status = resultSet.getString("status");
            
            Titulo titulo = new Titulo(codigo, descricao, dtvencimento, valor, status);
            titulos.add(titulo);
        }
        
        resultSet.close();
        statement.close();
        
        return titulos;
    }
    
    
    public boolean excluiTitulos(String codigo) throws SQLException{
        String sql = "DELETE from titulos where codigo = '" + codigo + "'";
        
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
        
            statement.execute();

            return true;
        }catch (SQLException e){
            return false;
        }
    }
    
    
    public Titulo buscarTitulo(Titulo titulo) throws SQLException{
          
        String sql = "SELECT codigo, descricao, dtvencimento, valor, status FROM titulos WHERE codigo = '" + titulo.getId() + "'";

        
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        resultSet.next();
        
            String codigo = resultSet.getString("codigo");
            String descricao = resultSet.getString("descricao");
            String dtvencimento = resultSet.getString("dtvencimento");
            String valor = resultSet.getString("valor");
            String status = resultSet.getString("status"); 
            
            Titulo tituloAtual = new Titulo(codigo, descricao, dtvencimento, valor, status);
            
            resultSet.close();
            statement.close();

        return tituloAtual;
    }
    
    public boolean salvaAlteracaoTitulo(Titulo titulo) throws SQLException{
        
        try{
            String sql ="UPDATE titulos SET descricao = ?,dtvencimento = ?,valor =?,status =? WHERE codigo = ? ";
         
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, titulo.getDescricao());
            statement.setString(2, titulo.getDtVencimento());
            statement.setString(3, titulo.getValor());
            statement.setString(4, titulo.getStatus());
            statement.setString(5, titulo.getId());
            statement.execute();
            return true;
        }catch (SQLException e){
            return false;
        } 
    }
}
