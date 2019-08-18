package br.uem.controller;

import br.uem.model.Titulo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


public class CadastroController{
    
    private static CadastroController instance;


    public static CadastroController getInstance() {
        if (instance == null) {
            instance = new CadastroController();
        }
        return instance;
    }

}
