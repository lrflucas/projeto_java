package model;

import java.util.ArrayList;

public class Rota {
    private int id;
    private String nome;
    private ArrayList<Parada> paradas = new ArrayList<>();

    public Rota(int id, String nome, ArrayList<Parada> paradas) {
        this.id = id;
        this.nome = nome;
        this.paradas = paradas;
    }

    public void adicionarParada(Parada parada) {
        paradas.add(parada);
    }

    @Override
    public String toString() {
        return "Rota{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", paradas=" + paradas.size() +
                '}';
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

    public ArrayList<Parada> getParadas() {
        return paradas;
    }

    public void setParadas(ArrayList<Parada> paradas) {
        this.paradas = paradas;
    }
}
