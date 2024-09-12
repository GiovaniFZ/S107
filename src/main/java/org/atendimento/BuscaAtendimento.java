package org.atendimento;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BuscaAtendimento {
    AtendimentoService atendimentoService;

    public BuscaAtendimento(AtendimentoService service) {
        this.atendimentoService = service;
    }

    public Atendimento retornaAtendimento(int numeroSala) {
        // Obtém a string JSON do serviço
        String atendimentoStr = atendimentoService.getAtendimento(numeroSala);

        if (atendimentoStr == null) {
            // Lança NullPointerException se a string JSON for null
            throw new NullPointerException();
        }

        try {
            // Transforma a string em JSON
            JsonObject jsonObject = JsonParser.parseString(atendimentoStr).getAsJsonObject();

            // Cria e retorna o objeto Atendimento
            return new Atendimento(jsonObject.get("nomeDoProfessor").getAsString(),
                    jsonObject.get("horarioDeAtendimento").getAsString(),
                    jsonObject.get("periodo").getAsString(),
                    jsonObject.get("sala").getAsInt(),
                    jsonObject.get("predio").getAsInt(),
                    jsonObject.get("info").getAsString()
            );
        
        }catch (com.google.gson.JsonSyntaxException e) {
            throw new IllegalArgumentException();
        }
    }
}
