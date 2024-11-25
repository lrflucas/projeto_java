package model;

import enums.Status;
import enums.TipoVeiculo;

public class Trem extends Veiculo {
    public Trem(int id, String modelo, TipoVeiculo tipo, Status status, Rota rota) {
        super(id, modelo, TipoVeiculo.TREM, Status.PARADO, rota);
    }

    @Override
    public String getDescricao() {
        return "Trem modelo " + getModelo();
    }
}
