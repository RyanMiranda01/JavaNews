# 📰 JavaNews – Portal de Notícias via Terminal

O **JavaNews** é um sistema em Java que consome a [NewsAPI](https://newsapi.org) para exibir notícias em tempo real diretamente no terminal. Com ele, você pode:

✅ Buscar notícias por temas personalizados  
✅ Escolher entre 15 categorias pré-definidas (Tecnologia, Política, Esportes etc.)  
✅ Salvar suas notícias favoritas em um arquivo `.txt`  
✅ Acessar o histórico de pesquisas e notícias salvas  
✅ Limpar o histórico de forma segura  
✅ Navegar de forma interativa por menus no terminal

---

## 🖼️ Demonstração

```bash
🌐 Bem-vindo ao JavaNews!
Aqui você pode explorar notícias com o tema que preferir,
ou escolher entre categorias prontas especialmente para você.

(1) Tema próprio | (2) Temas pré definidos.
1
Qual tema das notícia gostaria de ver hoje:
inteligência artificial

Aqui estão as notícias referente ao tema escolhido: inteligência artificial

Numero do artigo: 0
🔹 Notícia 🔹
Tema: inteligência artificial
📰 Título: OpenAI lança novo modelo de IA...
✍️ Autor: John Doe
📄 Descrição: A nova versão promete avanços...
📅 Publicado em: 2025-07-13
...

Gostaria de salvar alguma notícia que viu!
(1) Sim | (Qualquer Tecla) não.
1
Escolha o número referente a notícia que gostaria salvar:
0
Salvo com sucesso!
```
🔧 Tecnologias Utilizadas
---

Java 17+

NewsAPI

Gson (Google JSON)

Java HttpClient

Manipulação de arquivos .txt

Estrutura em pacotes organizada (MVC simplificado)

🧩 Estrutura dos Pacotes
---
```
Pacote	Conteúdo
br.com.JavaNews.API	Integração com a NewsAPI, conexão HTTP, deserialização com Gson

br.com.JavaNews.FuncionalidadeAPI	Lógica das funcionalidades do sistema (salvar, histórico, limpar, etc.)

br.com.JavaNews.Formatacao	Classes de modelo de dados: Artigo, ArtigoJava, LocalArtigo

br.com.JavaNews.Principal	Ponto de entrada do programa com menus e navegação
```
🔐 Configurando a Chave da API
---

É necessário cadastrar-se gratuitamente na NewsAPI para obter uma chave.

Acesse https://newsapi.org

Crie sua conta e copie a chave (API Key)

Vá até a classe API.java, no pacote br.com.JavaNews.API

Substitua o conteúdo da variável:
````
private String API_KEY = "SUA_CHAVE_AQUI";
````
✅ Sem essa chave o sistema não funcionará.

# ▶️ Como Executar o Projeto

✅ Usando IDE (IntelliJ ou NetBeans)
---

Importe o projeto como Projeto Java

Configure a biblioteca Gson:

No IntelliJ: File > Project Structure > Libraries

Ou adicione o .jar manualmente

Rode a classe br.com.JavaNews.Principal.Principal


✅ Via Terminal (sem IDE)
---

Compile:

bash
Copiar
Editar
javac -d bin src/br/com/JavaNews/**/*.java
Execute:

bash
Copiar
Editar
java -cp bin br.com.JavaNews.Principal.Principal

📦 Arquivos Gerados
---

NoticiasSalvas.txt: armazena os artigos que o usuário escolheu salvar.

Histórico de temas pesquisados é mantido em memória durante execução.

📁 Estrutura do Projeto
---
```
bash
Copiar
Editar
JavaNews/
├── src/
│   └── br/com/JavaNews/
│       ├── API/
│       │   └── API.java
│       ├── FuncionalidadeAPI/
│       │   └── FuncionalidadeAPI.java
│       ├── Formatacao/
│       │   ├── Artigo.java
│       │   ├── ArtigoJava.java
│       │   └── LocalArtigo.java
│       └── Principal/
│           └── Principal.java
├── NoticiasSalvas.txt
└── README.md
```
📌 Funcionalidades Completas
---

 Buscar notícias por tema personalizado

 Buscar notícias por tema pré-definido (15 categorias)

 Exibir artigos com título, autor, descrição, data, imagem, fonte

 Salvar artigos em arquivo .txt

 Visualizar histórico de temas pesquisados

 Visualizar artigos salvos

 Limpar o histórico de artigos salvos

 Navegação interativa por menus

 Tratamento de erros (input inválido, artigo inexistente, exceções)

👨‍💻 Desenvolvedor
---

Ryan Miranda Barbosa

🎓 Estudante de Análise e Desenvolvimento de Sistemas

📍 Santa Isabel – SP

📧 ryandilei17@gmail.com

📱 (11) 93095-5271
