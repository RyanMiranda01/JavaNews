package br.com.JavaNews.FuncionalidadeAPI;

import br.com.JavaNews.API.API;
import br.com.JavaNews.Formatacao.Artigo;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class FuncionalidadeAPI {
    API api = new API();
    Scanner digitar = new Scanner(System.in);

    public API getApi() {
        return api;
    }

    public void principalFun(Integer opcao) throws IOException, InterruptedException {
        while (true) {
            if (opcao == 1) {

                System.out.println("Qual tema das notícia gostaria de ver hoje: ");
                var temaNoticia = digitar.nextLine();
                System.out.println("Aqui estão as notícias referente ao tema escolhido: " + temaNoticia);
                System.out.println();
                api.apiJavaNews(temaNoticia);
                break;

            } else if (opcao == 2) {
                System.out.println("Aqui estão os temas pré definidos: ");
                System.out.println("1- Tecnologia");
                System.out.println("2- Política");
                System.out.println("3- Esportes");
                System.out.println("4- Economia");
                System.out.println("5- Entretenimento");
                System.out.println("6- Saúde");
                System.out.println("7- Ciência");
                System.out.println("8- Mundo");
                System.out.println("9- Educação");
                System.out.println("10- Cultura");
                System.out.println("11- Clima/Tempo");
                System.out.println("12- Segurança Pública");
                System.out.println("13- Negócios ");
                System.out.println("14- Trânsito/Transportes ");
                System.out.println("15- Curiosidades");
                System.out.println("Escolha o numero referente ao temas que gostaria de ver as notícias!");
                var tema = digitar.nextInt();
                digitar.nextLine();
                switch (tema) {
                    case 1:
                        System.out.println("Tema escolhido: Tecnologia");
                        api.apiJavaNews("Tecnologia");
                        return;
                    case 2:
                        System.out.println("Tema escolhido: Política");
                        api.apiJavaNews("Política");
                        return;
                    case 3:
                        System.out.println("Tema escolhido: Esportes");
                        api.apiJavaNews("Esportes");
                        return;
                    case 4:
                        System.out.println("Tema escolhido: Economia");
                        api.apiJavaNews("Economia");
                        return;
                    case 5:
                        System.out.println("Tema escolhido: Entretenimento");
                        api.apiJavaNews("Entretenimento");
                        return;
                    case 6:
                        System.out.println("Tema escolhido: Saúde");
                        api.apiJavaNews("Saúde");
                        return;
                    case 7:
                        System.out.println("Tema escolhido: Ciência");
                        api.apiJavaNews("Ciência");
                        return;
                    case 8:
                        System.out.println("Tema escolhido: Mundo");
                        api.apiJavaNews("Mundo");
                        return;
                    case 9:
                        System.out.println("Tema escolhido: Educação");
                        api.apiJavaNews("Educação");
                        return;
                    case 10:
                        System.out.println("Tema escolhido: Cultura");
                        api.apiJavaNews("Cultura");
                        return;
                    case 11:
                        System.out.println("Tema escolhido: Clima");
                        api.apiJavaNews("Clima");
                        return;
                    case 12:
                        System.out.println("Tema escolhido: Segurança Pública");
                        api.apiJavaNews("SegurançaPública");
                        return;
                    case 13:
                        System.out.println("Tema escolhido: Negócios");
                        api.apiJavaNews("Negócios");
                        return;
                    case 14:
                        System.out.println("Tema escolhido: Transportes");
                        api.apiJavaNews("Transportes");
                        return;
                    case 15:
                        System.out.println("Tema escolhido: Curiosidades");
                        api.apiJavaNews("Curiosidades");
                        return;
                    default:
                        System.out.println("Numero inexistente!");
                        break;
                }
            } else {
                System.out.println("Opção inválida, tente (1) ou (2).");
                opcao = digitar.nextInt();
                digitar.nextLine();
            }
        }
    }


    public void salvarArt(Integer numeroArtigo) throws IOException, InterruptedException {
        while (true) {
            System.out.println(api.getHistoricoArtigo().get(numeroArtigo));
            System.out.println("Se for esse artigo que gostaria de salvar digite (1) sim ou (2) não.");
            var opcao = digitar.nextInt();
            digitar.nextLine();
            if (opcao == 1) {
                String dataAtual = LocalDate.now().toString();
                api.getArtigosSalvos().add(api.getHistoricoArtigo().get(numeroArtigo));
                try(FileWriter arquivo = new FileWriter("NoticiasSalvas.txt", true)) {
                    Artigo artigoSelecionado = api.getHistoricoArtigo().get(numeroArtigo);
                    arquivo.write("Data de salvamento: " + dataAtual + artigoSelecionado.toString() + "\n");
                }catch (IOException e){
                    System.out.println("Erro ao salvar o artigo: " + e.getMessage());
                }
                System.out.println("Salvo com sucesso!");
                break;
            } else if (opcao == 2) {
                digitar.nextLine();
                System.out.println("Tente o numero navamente!");
                numeroArtigo = digitar.nextInt();
                digitar.nextLine();
            } else {
                System.out.println("Opção inválida, tente novamente!");
            }
        }
    }

    public void historicoDetemas(){
        System.out.println("Aqui está o histórico de temas pesquisados: ");
        System.out.println(api.getHistoricoTema());
    }

    public void limparHistórico(){
        try(FileWriter arquivo = new FileWriter("NoticiasSalvas.txt", false)){
            System.out.println("Arquivo limpo com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao limpar o arquivo: " + e.getMessage());
        }
    }

    public void artigosSalvos(){
        try {
            List<String> linhas = Files.readAllLines(Paths.get("NoticiasSalvas.txt"));
            for (String linha : linhas) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public void funcPartDois(Integer comandoNumero){
        while (true) {
            if (comandoNumero == 1) {
                System.out.println("Qual opção gostaria agora:");
                break;
            } else if (comandoNumero == 2) {
                historicoDetemas();
                System.out.println("Qual opção gostaria agora: (1) continuar| (3) para sair | (4) ver artigos salvos.");
                comandoNumero = digitar.nextInt();
                digitar.nextLine();
            } else if (comandoNumero == 3) {
                System.out.println("Obrigado por usar o JavaNews, Até a Próxima!");
                System.exit(0);
            } else if (comandoNumero == 4) {
                System.out.println("Aqui está seus artigos salvos: ");
                artigosSalvos();
                System.out.println("Qual opção gostaria agora: (1) continuar| (2) ver histórico | (3) para sair | (5) para Limpar artigos salvos.");
                comandoNumero = digitar.nextInt();
                digitar.nextLine();
                if(comandoNumero == 5) {
                    limparHistórico();
                    System.out.println("Qual opção gostaria agora: (1) continuar| (2) ver histórico | (3) para sair.");
                    comandoNumero = digitar.nextInt();
                    digitar.nextLine();
                }
        }else{
            System.out.println("Numero inexistente, escolha as opções acima.");
            comandoNumero = digitar.nextInt();
            digitar.nextLine();
        }
    }
}


}
