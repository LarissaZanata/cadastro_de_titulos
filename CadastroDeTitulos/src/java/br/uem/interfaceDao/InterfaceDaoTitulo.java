package br.uem.interfaceDao;

import br.uem.model.Titulo;
import java.sql.SQLException;
import java.util.ArrayList;

public interface InterfaceDaoTitulo {
    public boolean gravarTitulo(String descricao, String dtVencimento, String valor, String status);
    public ArrayList<Titulo> recuperarTitulo() throws SQLException;
    public boolean excluiTitulos(String codigo) throws SQLException;
    public Titulo buscarTitulo(Titulo titulo) throws SQLException;
    public boolean salvaAlteracaoTitulo(Titulo titulo) throws SQLException;
}
