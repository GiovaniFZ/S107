package org.atendimento;

public class Atendimento {
    public String nomeProfessor;
    public String horarioAtendimento;
    public String periodo;
    public String sala;
    public int predio;
    public String info;

    public Atendimento(String nomeProfessor, String horarioAtendimento, String periodo, String sala, int predio, String info) {
        this.nomeProfessor = nomeProfessor;
        this.horarioAtendimento = horarioAtendimento;
        this.periodo = periodo;
        this.sala = sala;
        this.predio = predio;
        this.info = info;
    }

    public int getPredio() {
        return predio;
    }

    public String getSala() {
        return sala;
    }

    public String getPeriodo() {
        return periodo;
    }

    public String getHorarioAtendimento() {
        return horarioAtendimento;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public String getInfo(){
        return info;
    }
}
