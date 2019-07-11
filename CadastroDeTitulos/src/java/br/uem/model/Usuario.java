package br.uem.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Usuario {
    private static AtomicInteger count = new AtomicInteger(0); 
    private int id;
    private String nome;
    private String senha;
    private boolean admin;
    
    public Usuario(String nome, String senha, boolean admin){
         this.id=count.incrementAndGet();
         this.nome = nome;
         this.senha = senha;
         this.admin = admin;
    }

    public static AtomicInteger getCount() {
        return count;
    }

    public static void setCount(AtomicInteger aCount) {
        count = aCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    
    
}
