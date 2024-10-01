package moldels;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {
    private String cep;

    public Endereco buscaEndereco(String cep) {
        URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json/");


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException |InterruptedException e) {
            throw new RuntimeException("Não consegui buscar esse cep.");
        }

        return new Gson().fromJson(response.body(), Endereco.class);
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    @Override
    public String toString() {
        Endereco endereco = buscaEndereco(this.cep);
        return "Seu cep é: " + endereco.cep() +
                "\nSeu bairro é: " + endereco.bairro() +
                "\nQue fica em: " + endereco.localidade() + ", " + endereco.uf();
    }
}
