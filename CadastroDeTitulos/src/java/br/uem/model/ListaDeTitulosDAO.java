
package br.uem.model;

import java.util.List;

public class ListaDeTitulosDAO{
    private static List<Titulo> titulos;


    public  static List<Titulo> getTitulos() {
        return titulos;
    }


    public static void setTitulos(List<Titulo> aTitulos) {
        titulos = aTitulos;
    }
    
    

    public static void excluir(Titulo titulo){
       if(getTitulos().contains(titulo)){
           int index = getTitulos().indexOf(titulo);
           getTitulos().remove(index);
       }
    }

    public  static void editar(Titulo titulo){
          if(getTitulos().contains(titulo)){
            int index = getTitulos().indexOf(titulo);
            getTitulos().get(index).setDescricao(titulo.getDescricao());
            getTitulos().get(index).setDtVencimento(titulo.getDtVencimento());
            getTitulos().get(index).setValor(titulo.getValor());           
            getTitulos().get(index).setStatus(titulo.getStatus());        
            }
   }
  
}
