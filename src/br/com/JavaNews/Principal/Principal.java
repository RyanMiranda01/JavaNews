package br.com.JavaNews.Principal;

import br.com.JavaNews.FuncionalidadeAPI.FuncionalidadeAPI;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        FuncionalidadeAPI funcionalidadeAPI = new FuncionalidadeAPI();
        Scanner digitar = new Scanner(System.in);
        int coamandNumero = 1;
        System.out.println("🌐 Bem-vindo ao JavaNews!");
        System.out.println("Aqui você pode explorar notícias com o tema que preferir,");
        System.out.println("ou escolher entre categorias prontas especialmente para você.");
        try {
            while (funcionalidadeAPI.getApi().getArtigosJava().getArticles() == null || funcionalidadeAPI.getApi().getHistoricoArtigo().isEmpty()) {
                System.out.println("(1) Tema próprio | (2) Temas pré definidos.");
                var opcao = digitar.nextInt();
                digitar.nextLine();
                funcionalidadeAPI.principalFun(opcao);

                if (funcionalidadeAPI.getApi().getHistoricoArtigo().size() != 0) {
                    System.out.println("Gostaria de salvar alguma notícia que viu!");
                    System.out.println("(1) Sim | (Qualquer Tecla) não.");
                    var simenao = digitar.next();
                    digitar.nextLine();

                    if (simenao.equalsIgnoreCase("1")) {
                        System.out.println("Escolha o número referente a notícia que gostaria salvar: ");
                        Integer numeroNoticia = digitar.nextInt();
                        digitar.nextLine();
                        funcionalidadeAPI.salvarArt(numeroNoticia);
                    }

                    System.out.println("Qual opção gostaria agora: (1) continuar| (2) ver histórico | (3) para sair| (4) ver artigos salvos. ");
                    coamandNumero = digitar.nextInt();
                    digitar.nextLine();
                    funcionalidadeAPI.funcPartDois(coamandNumero);
                }
            }
        } catch (InputMismatchException i) {
            System.out.println("Só é permitido Números! Reinicie o programa.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Numero não existe! Reinicie o programa.");
        }
    }
}