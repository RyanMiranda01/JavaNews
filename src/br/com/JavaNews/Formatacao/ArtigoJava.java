package br.com.JavaNews.Formatacao;

import java.util.List;

public class ArtigoJava {
    private String totalResults;

    private List<Artigo> articles;

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public List<Artigo> getArticles() {
        return articles;

    }

    public void setArticles(List<Artigo> articles) {
        this.articles = articles;
    }
}


