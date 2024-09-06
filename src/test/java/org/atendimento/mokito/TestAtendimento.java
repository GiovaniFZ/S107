package org.atendimento.mokito;

import org.atendimento.AtendimentoService;
import org.atendimento.BuscaAtendimento;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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
}
