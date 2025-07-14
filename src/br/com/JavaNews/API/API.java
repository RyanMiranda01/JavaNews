package br.com.JavaNews.API;

import br.com.JavaNews.Formatacao.Artigo;
import br.com.JavaNews.Formatacao.ArtigoJava;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class API {
    //COLOQUE SUA CHAVE API AQUI PARA FUNCIONAR
    private String API_KEY = "SUA_CHAVE_AQUI";


    private String dataAtual = LocalDate.now().minusDays(5).toString();
    ArtigoJava artigosJava = new ArtigoJava();
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();
    private List<Artigo> artigosSalvos;
    private List<Artigo> historicoArtigo;
    private List<String> historicoTema;

    public List<Artigo> getHistoricoArtigo() {
        return historicoArtigo;
    }

    public API() {
        this.historicoArtigo = new ArrayList<Artigo>();
        this.artigosSalvos = new ArrayList<Artigo>();
        this.historicoTema = new ArrayList<String>();
    }

    public ArtigoJava getArtigosJava() {
        return artigosJava;
    }


    public List<String> getHistoricoTema() {
        return historicoTema;
    }

    public List<Artigo> getArtigosSalvos() {
        return artigosSalvos;
    }


    public void apiJavaNews(String temaNoticia) throws IOException, InterruptedException {
        historicoArtigo.clear();
        int numeroArtigo = 0;
        historicoTema.add(temaNoticia);
        var endereco = "https://newsapi.org/v2/everything?q=" + temaNoticia.replace(" ", "+") + "&from="+ dataAtual +"&sortBy=publishedAt&apiKey="+ API_KEY;
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        var json = response.body();

        this.artigosJava = gson.fromJson(json, ArtigoJava.class);

        if (artigosJava.getArticles() == null || artigosJava.getArticles().isEmpty()) {
            System.out.println("Sem notícias refente ao tema: " + temaNoticia);
            System.out.println("Escolha outro tema: ");
        }   else{
            for (Artigo artigo : artigosJava.getArticles()) {
                artigo.setTema(temaNoticia);
                System.out.println("Numero do artigo: " + numeroArtigo++);
                System.out.println(artigo.toString());
                this.historicoArtigo.add(artigo);
            }
        }
    }

}