package model;

import enums.Status;
import enums.TipoVeiculo;

public class Onibus extends Veiculo {
    public Onibus(int id, String modelo, TipoVeiculo tipo, Status status, Rota rota) {
        super(id, modelo, TipoVeiculo.ONIBUS, Status.PARADO, rota);
    }

    public String getDescricao() {
        return "Ônibus modelo " + getModelo();
    }
}
