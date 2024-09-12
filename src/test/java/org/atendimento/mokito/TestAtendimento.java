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
    public void setup() {
        buscaAtendimento = new BuscaAtendimento(atendimentoService);
    }

    @Test
    public void VerificarNomeDoProfessorNoPredioUm() {
        Mockito.when(atendimentoService.getAtendimento(2)).thenReturn(HorariosConst.PREDIO1);
        Atendimento at1 = buscaAtendimento.retornaAtendimento(2);
        assertEquals("Chris Lima", at1.getNomeProfessor());
    }

    @Test
    public void VerificarNomeDoProfessorNoPredioDois() {
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

    @Test
    public void verificarNumeroGrande() {
        Mockito.when(atendimentoService.getAtendimento(30)).thenReturn(HorariosConst.NUMERO_MAIOR);
        Atendimento at7 = buscaAtendimento.retornaAtendimento(30);
        assertEquals("Número deve ser menor que 25!", at7.getInfo());
    }

    @Test(expected = java.lang.Exception.class)
    public void verificarNomeIncorretoNoPredioUm() throws Exception {
        Mockito.when(atendimentoService.getAtendimento(2)).thenReturn(HorariosConst.PREDIO1);
        Atendimento at8 = buscaAtendimento.retornaAtendimento(2);

        // Verifica se o nome do professor é o esperado
        if (!"Carlos Lima".equals(at8.getNomeProfessor())){
            // Lança uma exceção se o nome estiver incorreto
            throw new Exception();
        }
    }

    @Test(expected = java.lang.Exception.class)
    public void verificarNomeIncorretoNoPredioDois() throws Exception {
        Mockito.when(atendimentoService.getAtendimento(8)).thenReturn(HorariosConst.PREDIO2);
        Atendimento at8 = buscaAtendimento.retornaAtendimento(8);

        // Verifica se o nome do professor é o esperado
        if (!"João Mesquita".equals(at8.getNomeProfessor())){
            // Lança uma exceção se o nome estiver incorreto
            throw new Exception();
        }
    }

    @Test(expected = java.lang.Exception.class)
    public void verificarHorarioIncorretoNoPredioUm() throws Exception  {
        Mockito.when(atendimentoService.getAtendimento(1)).thenReturn(HorariosConst.PREDIO1);
        Atendimento at9 = buscaAtendimento.retornaAtendimento(1);

        if (!"Terça:17:30".equals(at9.getHorarioAtendimento())) {
            // Lança uma exceção se o horário estiver incorreto
            throw new Exception();
        }
    }

    @Test(expected = java.lang.Exception.class)
    public void verificarHorarioIncorretoNoPredioTres() throws Exception  {
        Mockito.when(atendimentoService.getAtendimento(14)).thenReturn(HorariosConst.PREDIO3);
        Atendimento at10 = buscaAtendimento.retornaAtendimento(14);

        if (!"Terça:15:30".equals(at10.getHorarioAtendimento())) {
            // Lança uma exceção se o horário estiver incorreto
            throw new Exception();
        }
    }

    @Test(expected = java.lang.Exception.class)
    public void verificarPeriodoIncorretoNoPredioQuatro() throws Exception {
        Mockito.when(atendimentoService.getAtendimento(18)).thenReturn(HorariosConst.PREDIO4);
        Atendimento at11 = buscaAtendimento.retornaAtendimento(18);

        if (!"noturno".equals(at11.getPeriodo())) {
            // Lança uma exceção se o período estiver incorreto
            throw new Exception();
        }
    }

    @Test(expected = java.lang.Exception.class)
    public void verificarPeriodoIncorretoNoPredioSeis() throws Exception {
        Mockito.when(atendimentoService.getAtendimento(22)).thenReturn(HorariosConst.PREDIO6);
        Atendimento at12 = buscaAtendimento.retornaAtendimento(22);

        if (!"integral".equals(at12.getPeriodo())) {
            // Lança uma exceção se o período estiver incorreto
            throw new Exception();
        }
    }

    @Test(expected = UnsupportedOperationException.class)
    public void verificarHorarioNulo() throws Exception {
        Mockito.when(atendimentoService.getAtendimento(2)).thenReturn("{\"nomeDoProfessor\": \"Chris Lima\", \"horarioDeAtendimento\": null, \"periodo\": \"noturno\", \"sala\": \"1\", \"predio\": [\"1\"]}");
        Atendimento at13 = buscaAtendimento.retornaAtendimento(2);

        // Verifica se o horário de atendimento é null
        if (at13.getHorarioAtendimento() == null) {
            // Lança uma UnsupportedOperationException se o horário de atendimento for null
            throw new Exception();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void verificarJsonInvalido() {
        // Configura o mock para retornar um JSON inválido
        Mockito.when(atendimentoService.getAtendimento(1)).thenReturn("{\"nomeDoProfessor\": \"Chris Lima\", \"horarioDeAtendimento\": \"Segunda:17:30\"");

        // Chama o método que deve lançar IllegalArgumentException devido ao JSON inválido
        Atendimento at14 = buscaAtendimento.retornaAtendimento(1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void verificarNomeProfessorNulo() throws Exception {
        Mockito.when(atendimentoService.getAtendimento(2)).thenReturn("{\"nomeDoProfessor\": null, \"horarioDeAtendimento\": \"Segunda:17:30\", \"periodo\": \"noturno\", \"sala\": \"1\", \"predio\": [\"1\"]}");
        Atendimento at15 = buscaAtendimento.retornaAtendimento(2);

        // Verifica se o nome do professor é null
        if (at15.getNomeProfessor() == null) {
            // Lança uma UnsupportedOperationException se o nome for null
            throw new Exception();
        }
    }
}
