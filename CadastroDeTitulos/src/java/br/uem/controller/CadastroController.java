package br.uem.controller;

import br.uem.model.ListaDeTitulosDAO;
import br.uem.model.Titulo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


public class CadastroController{
    private ListaDeTitulosDAO titulos;
    
    private static CadastroController instance;

    private CadastroController() {
        this.titulos.setTitulos(new ArrayList<>());
    }

    public static CadastroController getInstance() {
        if (instance == null) {
            instance = new CadastroController();
        }
        return instance;
    }

    
    //******************************
    
    public void salvarTitulo(Titulo titulo) {
        this.titulos.getTitulos().add(titulo);
    }

    public List<Titulo> listarTitulos() {
        return titulos.getTitulos();
    }
    
     public void excluirTitulo(Titulo titulo){
        this.titulos.excluir(titulo);
    }
    
    public void editarTitulo(Titulo titulo){
        this.titulos.editar(titulo);
    }
}
