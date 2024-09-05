package org.atendimento;

public class Atendimento {
    public String nomeProfessor;
    public String horarioAtendimento;
    public int periodo;
    public int sala;
    public int predio;

    public Atendimento(String nomeProfessor, String horarioAtendimento, int periodo, int sala, int predio) {
        this.nomeProfessor = nomeProfessor;
        this.horarioAtendimento = horarioAtendimento;
        this.periodo = periodo;
        this.sala = sala;
        this.predio = predio;
    }
}
