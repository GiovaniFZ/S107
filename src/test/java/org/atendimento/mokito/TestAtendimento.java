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
}
