package br.com.alura.screenmatch2.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obterTraducao(String texto) {
        OpenAiService service = new OpenAiService("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");


        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("traduza para o português o texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();


        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}
