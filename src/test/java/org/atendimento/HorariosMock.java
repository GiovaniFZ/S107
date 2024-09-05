package org.atendimento;

public class HorariosMock implements AtendimentoService{

    @Override
    public String getAtendimento(int numeroSala) {
        return HorariosConst.ATENDIMENTO;
    }
}
