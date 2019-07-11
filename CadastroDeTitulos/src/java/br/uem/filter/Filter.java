/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.filter;

import br.uem.connection.SingleConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//essa classe intercepta as requisições entre o banco e a aplicação e também levanta a conexão com o banco
@WebFilter(urlPatterns = {"/*"}) //toda requisição é interceptada e passa por esse filter
public class Filter implements javax.servlet.Filter{
    
    private static Connection connection;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        connection = SingleConnection.getConectio();
       
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try{
            chain.doFilter(request, response);
            connection.commit();
        }catch(Exception e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
    }

    @Override
    public void destroy() {
        
    }
    
}
