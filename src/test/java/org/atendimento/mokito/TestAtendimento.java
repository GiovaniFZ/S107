package org.atendimento.mokito;

import org.atendimento.Atendimento;
import org.atendimento.AtendimentoService;
import org.atendimento.BuscaAtendimento;
import org.atendimento.HorariosConst;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestAtendimento {

    @Mock
    private AtendimentoService atendimentoService;
    @Mock
    private BuscaAtendimento buscaAtendimento;

    @Before
    public void setup(){
        buscaAtendimento = new BuscaAtendimento(atendimentoService);
    }

    @Test
    public void VerificarNomeDoProfessorNoPredioUm(){
        Mockito.when(atendimentoService.getAtendimento(2)).thenReturn(HorariosConst.PREDIO1);
        Atendimento at1 = buscaAtendimento.retornaAtendimento(2);
        assertEquals("Chris Lima", at1.getNomeProfessor());
    }

    @Test
    public void VerificarNomeDoProfessorNoPredioDois(){
        Mockito.when(atendimentoService.getAtendimento(8)).thenReturn(HorariosConst.PREDIO2);
        Atendimento at2 = buscaAtendimento.retornaAtendimento(8);
        assertEquals("Renzo Mesquita", at2.getNomeProfessor());
    }
    
    @Test
    public void verificarHorarioDeAtendimentoNoPredioUm() {
    Mockito.when(atendimentoService.getAtendimento(1)).thenReturn(HorariosConst.PREDIO1);
    Atendimento at3 = buscaAtendimento.retornaAtendimento(1);
    assertEquals("Segunda:17:30", at3.getHorarioAtendimento());
    }

    @Test
    public void verificarPeriodoDeAtendimentoNoPredioQuatro() {
    Mockito.when(atendimentoService.getAtendimento(5)).thenReturn(HorariosConst.PREDIO4);
    Atendimento at4 = buscaAtendimento.retornaAtendimento(5);
    assertEquals("integral", at4.getPeriodo());
}

    @Test
    public void verificarSalaDeAtendimentoNoPredioQuatro() {
    Mockito.when(atendimentoService.getAtendimento(5)).thenReturn(HorariosConst.PREDIO4);
    Atendimento at5 = buscaAtendimento.retornaAtendimento(5);
    assertEquals("18", at5.getSala());
}

    @Test
    public void verificarNumeroPredio() {
    Mockito.when(atendimentoService.getAtendimento(22)).thenReturn(HorariosConst.PREDIO6);
    Atendimento at6 = buscaAtendimento.retornaAtendimento(22);
    assertEquals("6", at6.getPredio());
}

}
