package br.com.JavaNews.Formatacao;

public class Artigo{
    private LocalArtigo localArtigos;
    private String tema;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;


    public LocalArtigo getLocalArtigos() {
        return localArtigos;
    }

    public void setLocalArtigos(LocalArtigo localArtigos) {
        this.localArtigos = localArtigos;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    @Override
    public String toString() {
        return "\n🔹 Notícia 🔹\n" +
                "Tema: " + tema + "\n" +
                "📰 Título: " + title + "\n" +
                "✍️ Autor: " + (author != null ? author : "Desconhecido") + "\n" +
                "📄 Descrição: " + (description != null ? description : "Sem descrição disponível") + "\n" +
                "🖼️ Imagem: " + (urlToImage != null ? urlToImage : "Sem imagem") + "\n" +
                "📅 Publicado em: " + publishedAt + "\n" +
                "🧾 Conteúdo: " + (content != null ? content : "Sem conteúdo") + "\n" +
                "🏷️ Fonte: " + (localArtigos != null ? localArtigos.getName() : "Sem fonte") + "\n" +
                "----------------------------------------";

    }
}
