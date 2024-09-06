package org.atendimento;

public class HorariosMock implements AtendimentoService{

    @Override
    public String getAtendimento(int numeroSala) {
        if(numeroSala <= 5 ){
            return HorariosConst.PREDIO1;
        }
        if(numeroSala < 10 ){
            return HorariosConst.PREDIO2;
        }
        if(numeroSala < 15){
            return HorariosConst.PREDIO3;
        }
        if(numeroSala < 20){
            return HorariosConst.PREDIO4;
        }
        return HorariosConst.PREDIO6;
    }
}
