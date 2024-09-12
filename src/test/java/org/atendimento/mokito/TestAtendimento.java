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

    // Testes de sucesso

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
    public void verificarHorarioDeAtendimentoNoPredioTres(){
        Mockito.when(atendimentoService.getAtendimento(13)).thenReturn(HorariosConst.PREDIO3);
        Atendimento at = buscaAtendimento.retornaAtendimento(13);
        assertEquals("Segunda:13:30", at.getHorarioAtendimento());
    }

    @Test
    public void verificarPeriodoDeAtendimentoNoPredioQuatro() {
        Mockito.when(atendimentoService.getAtendimento(5)).thenReturn(HorariosConst.PREDIO4);
        Atendimento at4 = buscaAtendimento.retornaAtendimento(5);
        assertEquals("integral", at4.getPeriodo());
    }

    @Test
    public void verificarPeriodoDeAtendimentoNoPredioSeis() {
        Mockito.when(atendimentoService.getAtendimento(23)).thenReturn(HorariosConst.PREDIO6);
        Atendimento at = buscaAtendimento.retornaAtendimento(23);
        assertEquals("noturno", at.getPeriodo());
    }

    @Test
    public void verificarSalaDeAtendimentoNoPredioQuatro() {
        Mockito.when(atendimentoService.getAtendimento(17)).thenReturn(HorariosConst.PREDIO4);
        Atendimento at5 = buscaAtendimento.retornaAtendimento(17);
        assertEquals(18, at5.getSala());
    }

    @Test
    public void verificarSalaDeAtendimentoNoPredioUm() {
        Mockito.when(atendimentoService.getAtendimento(5)).thenReturn(HorariosConst.PREDIO1);
        Atendimento at = buscaAtendimento.retornaAtendimento(5);
        assertEquals(1, at.getSala());
    }

    @Test
    public void verificarNumeroPredio() {
        Mockito.when(atendimentoService.getAtendimento(22)).thenReturn(HorariosConst.PREDIO6);
        Atendimento at6 = buscaAtendimento.retornaAtendimento(22);
        assertEquals(6, at6.getPredio());
    }

    @Test
    public void verificarMensagemDeSucesso(){
        Mockito.when(atendimentoService.getAtendimento(22)).thenReturn(HorariosConst.PREDIO6);
        Atendimento at6 = buscaAtendimento.retornaAtendimento(22);
        assertEquals("success", at6.getInfo());
    }

    // Testes falha
    @Test
    public void verificarNumeroGrande() {
        Mockito.when(atendimentoService.getAtendimento(30)).thenReturn(HorariosConst.NUMERO_MAIOR);
        Atendimento at7 = buscaAtendimento.retornaAtendimento(30);
        assertEquals("Número deve ser menor que 25!", at7.getInfo());
    }

    @Test
    public void verificarNumeroPequeno(){
        Mockito.when(atendimentoService.getAtendimento(-3)).thenReturn(HorariosConst.NUMERO_MENOR);
        Atendimento at = buscaAtendimento.retornaAtendimento(-3);
        assertEquals("Número deve ser maior que 1!", at.getInfo());
    }

    @Test(expected = java.lang.Exception.class)
    public void verificarNomeIncorreto() throws Exception {
        Mockito.when(atendimentoService.getAtendimento(2)).thenReturn(HorariosConst.PREDIO1);
        Atendimento at8 = buscaAtendimento.retornaAtendimento(2);

        // Verifica se o nome do professor é o esperado
        if (!"Carlos Lima".equals(at8.getNomeProfessor())){
            // Lança uma exceção se o nome estiver incorreto
            throw new Exception();
        }
    }

    @Test(expected = java.lang.Exception.class)
    public void verificarHorarioIncorreto() throws Exception  {
        Mockito.when(atendimentoService.getAtendimento(1)).thenReturn(HorariosConst.PREDIO1);
        Atendimento at9 = buscaAtendimento.retornaAtendimento(1);

        if (!"Terça:17:30".equals(at9.getHorarioAtendimento())) {
            // Lança uma exceção se o horário estiver incorreto
            throw new Exception();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void verificarJsonInvalido() {
        // Configura o mock para retornar um JSON malformado
        Mockito.when(atendimentoService.getAtendimento(1)).thenReturn("{\"nomeDoProfessor\": \"Chris Lima\", \"horarioDeAtendimento\": \"Segunda:17:30\"");

        // Chama o método que deve lançar IllegalArgumentException devido ao JSON inválido
        Atendimento at14 = buscaAtendimento.retornaAtendimento(1);
    }
}
