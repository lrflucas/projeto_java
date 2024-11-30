package service;

import model.Parada;
import model.Rota;

import java.util.ArrayList;

public class VeiculoService {
    private ArrayList<Parada> paradas = new ArrayList<>();
    private ArrayList<Rota> rotas = new ArrayList<>();

    public void cadastrarParada(Parada parada) {
        paradas.add(parada);
        System.out.println("Parada cadastrada com sucesso!");
    }

    public ArrayList<Parada>lerParada(){
        return paradas;
    }

    public void atualizarParada (int id, Parada novaParada) {
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

    public void deletarParada (int id) {
        for (int i = 0; i < paradas.size(); i++) {
            if (paradas.get(i).getId() == id) {
                paradas.remove(i);
                System.out.println("Parada deletada com sucesso!");
            } else {
                System.out.println("Parada não foi encontrada.");
            }
        }
    }


    public void cadastrarRota(Rota rota) {
        rotas.add(rota);
        System.out.println("Rota cadastrada com sucesso!");
    }

    public ArrayList<Rota>lerRota(){
        return rotas;
    }

    public void atualizarRota (int id, Rota novaRota) {
        for (int i = 0; i < rotas.size(); i++) {
            if (rotas.get(i).getId() == id) {
                rotas.set(i, novaRota);
                System.out.println("Rota atualizada com sucesso!");
                break;
            } else {
                System.out.println("Rota não foi encontrada.");
            }

        }
    }

    public void deletarRota (int id) {
        for (int i = 0; i < rotas.size(); i++) {
            if (rotas.get(i).getId() == id) {
                rotas.remove(i);
                System.out.println("Rota deletada com sucesso!");
            } else {
                System.out.println("Rota não foi encontrada.");
            }
        }
    }




}
