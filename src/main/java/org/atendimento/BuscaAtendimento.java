package org.atendimento;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BuscaAtendimento {
    AtendimentoService atendimentoService;

    public BuscaAtendimento(AtendimentoService service) {
        this.atendimentoService = service;
    }

    public Atendimento retornaAtendimento(int numeroSala) {
        // Transformando o String em JSON
        String atendimentoStr = atendimentoService.getAtendimento(numeroSala);
        JsonObject jsonObject = JsonParser.parseString(atendimentoStr).getAsJsonObject();
        return new Atendimento(jsonObject.get("nomeDoProfessor").getAsString(),
                jsonObject.get("horarioDeAtendimento").getAsString(),
                jsonObject.get("periodo").getAsString(),
                jsonObject.get("sala").getAsInt(),
                jsonObject.get("predio").getAsInt(),
                jsonObject.get("info").getAsString()
        );
    }
}