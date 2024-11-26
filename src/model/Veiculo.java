package model;

import enums.Status;
import enums.TipoVeiculo;

public abstract class Veiculo implements Operavel {
    private int id;
    private String modelo;
    private TipoVeiculo tipo;
    private Status status;
    private Rota rota;

    public Veiculo(int id, String modelo, TipoVeiculo tipo, Status status, Rota rota) {
        this.id = id;
        this.modelo = modelo;
        this.tipo = tipo;
        this.status = Status.FORA_DE_OPERACAO;
        this.rota = rota;
    }

    public abstract String getDescricao();

    @Override
    public void iniciarOperacao() {
        if (status == Status.FORA_DE_OPERACAO) {
            status = Status.EM_MOVIMENTO;
            System.out.println(tipo + " " + modelo + " agora está em operação.");
        } else {
            System.out.println(tipo + " " + modelo + " já está em operação.");
        }
    }

    @Override
    public void pararOperacao() {
        if (status == Status.EM_MOVIMENTO) {
            status = Status.FORA_DE_OPERACAO;
            System.out.println(tipo + " " + modelo + " parou de operar.");
        } else {
            System.out.println(tipo + " " + modelo + " não está em operação.");
        }
    }

    @Override
    public void voltarOperacao() {
        if (status == Status.PARADO) {
            status = Status.EM_MOVIMENTO;
            System.out.println(tipo + " " + modelo + " voltou a se movimentar.");
        } else {
            System.out.println(tipo + " " + modelo + " está ou não em operação.");
        }
    }


    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", tipo=" + tipo +
                ", status=" + status +
                ", rota=" + rota +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public TipoVeiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVeiculo tipo) {
        this.tipo = tipo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }
}
