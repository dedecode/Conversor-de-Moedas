package com.meuprojeto.conversordemoedas;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ConversorDeMoedas {

    public static void main(String[] args) throws IOException {

        Map<String, String> nomesSingulares = new HashMap<>();
        nomesSingulares.put("AUD", "Dólar Australiano");
        nomesSingulares.put("BGN", "Lev Búlgaro");
        nomesSingulares.put("BRL", "Real Brasileiro");
        nomesSingulares.put("CAD", "Dólar Canadense");
        nomesSingulares.put("CHF", "Franco Suíço");
        nomesSingulares.put("CNY", "Iuane Chinês");
        nomesSingulares.put("CZK", "Coroa Tcheca");
        nomesSingulares.put("DKK", "Coroa Dinamarquesa");
        nomesSingulares.put("EUR", "Euro");
        nomesSingulares.put("GBP", "Libra Esterlina");
        nomesSingulares.put("HKD", "Dólar de Hong Kong");
        nomesSingulares.put("HUF", "Florim Húngaro");
        nomesSingulares.put("IDR", "Rúpia Indonésia");
        nomesSingulares.put("ILS", "Novo Shekel Israelense");
        nomesSingulares.put("INR", "Rúpia Indiana");
        nomesSingulares.put("ISK", "Coroa Islandesa");
        nomesSingulares.put("JPY", "Iene Japonês");
        nomesSingulares.put("KRW", "Won Sul-Coreano");
        nomesSingulares.put("MXN", "Peso Mexicano");
        nomesSingulares.put("MYR", "Ringgit Malaio");
        nomesSingulares.put("NOK", "Coroa Norueguesa");
        nomesSingulares.put("NZD", "Dólar Neozelandês");
        nomesSingulares.put("PHP", "Peso Filipino");
        nomesSingulares.put("PLN", "Złoty Polonês");
        nomesSingulares.put("RON", "Leu Romeno");
        nomesSingulares.put("SEK", "Coroa Sueca");
        nomesSingulares.put("SGD", "Dólar de Singapura");
        nomesSingulares.put("THB", "Baht Tailandês");
        nomesSingulares.put("TRY", "Lira Turca");
        nomesSingulares.put("USD", "Dólar Americano");
        nomesSingulares.put("ZAR", "Rand Sul-Africano");

        Map<String, String> nomesPlurais = new HashMap<>();
        nomesPlurais.put("AUD", "Dólares Australianos");
        nomesPlurais.put("BGN", "Levs Búlgaros");
        nomesPlurais.put("BRL", "Reais Brasileiros");
        nomesPlurais.put("CAD", "Dólares Canadenses");
        nomesPlurais.put("CHF", "Francos Suíços");
        nomesPlurais.put("CNY", "Iuanes Chineses");
        nomesPlurais.put("CZK", "Coroas Tchecas");
        nomesPlurais.put("DKK", "Coroas Dinamarquesas");
        nomesPlurais.put("EUR", "Euros");
        nomesPlurais.put("GBP", "Libras Esterlinas");
        nomesPlurais.put("HKD", "Dólares de Hong Kong");
        nomesPlurais.put("HUF", "Florins Húngaros");
        nomesPlurais.put("IDR", "Rúpias Indonésias");
        nomesPlurais.put("ILS", "Novos Shekels Israelenses");
        nomesPlurais.put("INR", "Rúpias Indianas");
        nomesPlurais.put("ISK", "Coroas Islandesas");
        nomesPlurais.put("JPY", "Ienes Japoneses");
        nomesPlurais.put("KRW", "Wons Sul-Coreanos");
        nomesPlurais.put("MXN", "Pesos Mexicanos");
        nomesPlurais.put("MYR", "Ringgits Malaios");
        nomesPlurais.put("NOK", "Coroas Norueguesas");
        nomesPlurais.put("NZD", "Dólares Neozelandeses");
        nomesPlurais.put("PHP", "Pesos Filipinos");
        nomesPlurais.put("PLN", "Złotys Poloneses");
        nomesPlurais.put("RON", "Leus Romenos");
        nomesPlurais.put("SEK", "Coroas Suecas");
        nomesPlurais.put("SGD", "Dólares de Singapura");
        nomesPlurais.put("THB", "Bahts Tailandeses");
        nomesPlurais.put("TRY", "Liras Turcas");
        nomesPlurais.put("USD", "Dólares Americanos");
        nomesPlurais.put("ZAR", "Rands Sul-Africanos");

        Set<String> moedasValidas = nomesSingulares.keySet();
        Scanner scanner = new Scanner(System.in);

            System.out.println("\n       Bem vindo ao Conversor de Moedas!\nEssas são as moedas disponíveis para conversão:");

            for (String n : nomesSingulares.keySet()) {
                System.out.println(" " + nomesSingulares.get(n) + " - " + n);
            }

            boolean continuar = true;
            while (continuar) {
            
                String moedaOrigem;
            while (true) {
                System.out.println("\nConverter de (ex.: USD):");
                moedaOrigem = scanner.nextLine().toUpperCase();
                if (moedasValidas.contains(moedaOrigem)) {
                    break;
                }
                System.out.println("Moeda de origem inválida! Tente novamente.");
            }

            String moedaDestino;
            while (true) {
                System.out.println("Converter para (ex.: BRL):");
                moedaDestino = scanner.nextLine().toUpperCase();
                if (moedasValidas.contains(moedaDestino)) {
                    break;
                }
                System.out.println("Moeda de destino inválida! Tente novamente.");
            }

            BigDecimal quantidade;
            while (true) {
                try {
                    System.out.println("Digite a quantidade a converter:");
                    quantidade = scanner.nextBigDecimal();
                    scanner.nextLine(); 
                    break;
                } catch (Exception e) {
                    System.out.println("Quantidade inválida! Por favor, insira um número válido.");
                    scanner.nextLine(); 
                }
            }

            String urlString = "https://api.frankfurter.dev/v1/latest?base=" + moedaOrigem;
            OkHttpClient cliente = new OkHttpClient();
            Request requisicao = new Request.Builder().url(urlString).get().build();
            Response resposta = cliente.newCall(requisicao).execute();

            if (!resposta.isSuccessful()) {
                System.out.println("Erro ao acessar a API! Verifique sua conexão.");
                continue;
            }

            String respostaString = resposta.body().string();
            JSONObject objetoJson = new JSONObject(respostaString);
            JSONObject objetoTaxas = objetoJson.getJSONObject("rates");

            if (!objetoTaxas.has(moedaDestino)) {
                System.out.println("Moeda de destino não encontrada! Tente novamente.");
                continue;
            }

            BigDecimal taxa = objetoTaxas.getBigDecimal(moedaDestino);
            BigDecimal resultado = taxa.multiply(quantidade);

            String nomeMoedaDestino;
            if (resultado.compareTo(BigDecimal.ONE) == 0) {
                nomeMoedaDestino = nomesSingulares.get(moedaDestino);
            } else {
                nomeMoedaDestino = nomesPlurais.get(moedaDestino);
            }

            Currency moeda = Currency.getInstance(moedaDestino);
            Locale locale = new Locale("en", "US");
            NumberFormat formatador = NumberFormat.getCurrencyInstance(locale);
            formatador.setCurrency(moeda);
            
            System.out.println();
            System.out.println("Resultado da conversão: " + formatador.format(resultado) + " " + nomeMoedaDestino + "\n");
            
            String respostaUsuario;
            while (true) {
                System.out.println("\nDeseja realizar outra conversão? (sim/nao):");
                respostaUsuario = scanner.nextLine().trim().toLowerCase();
                if (respostaUsuario.equals("sim")) {
                    continuar = true;
                    break;
                } else if (respostaUsuario.equals("nao")) {
                    continuar = false;
                    System.out.println("Obrigado por usar o Conversor de Moedas! Até a próxima.");
                    break;
                } else {
                    System.out.println("Resposta inválida! Digite sim ou nao.");
                }
            }
        }
    }
}
