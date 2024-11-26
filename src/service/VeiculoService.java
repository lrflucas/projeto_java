package service;

import model.Parada;

import java.util.ArrayList;

public class VeiculoService {
    private ArrayList<Parada> paradas = new ArrayList<>();

    public void cadastrarParada(Parada parada) {
        paradas.add(parada);
        System.out.println("Parada cadastrada com sucesso!");
    }

    public ArrayList<Parada>ler(){
        return paradas;
    }

    public void atualizar (int id, Parada novaParada) {
        for (int i = 0; i < paradas.size(); i++) {
            if (paradas.get(i).getId() == id) {
                paradas.set(i, novaParada);
                System.out.println("Parada atualizada com sucesso!");
                break;
            } else {
                System.out.println("Parada não foi encontrada.");
            }

        }
    }

    public void deletar (int id) {
        for (int i = 0; i < paradas.size(); i++) {
            if (paradas.get(i).getId() == id) {
                paradas.remove(i);
                System.out.println("Parada deletada com sucesso!");
            } else {
                System.out.println("Parada não foi encontrada.");
            }
        }
    }
}
