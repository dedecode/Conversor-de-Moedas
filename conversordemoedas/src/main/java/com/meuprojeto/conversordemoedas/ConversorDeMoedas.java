package com.meuprojeto.conversordemoedas;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class ConversorDeMoedas {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        Set<String> moedasValidas = Set.of("USD", "BRL", "EUR", "JPY", "GBP", "AUD");

        System.out.println("Converter de (ex.: USD):");
        String moedaOrigem = scanner.nextLine().toUpperCase();

        if (!moedasValidas.contains(moedaOrigem)) {
            System.out.println("Moeda de origem inválida! Tente novamente.");
            return;
        }

        System.out.println("Converter para (ex.: BRL):");
        String moedaDestino = scanner.nextLine().toUpperCase();
        
        
        if (!moedasValidas.contains(moedaDestino)) {
            System.out.println("Moeda de destino inválida! Tente novamente.");
            return;
        }

        BigDecimal quantidade;
        try {
            System.out.println("Digite a quantidade a converter:");
            quantidade = scanner.nextBigDecimal();
        } catch (Exception e) {
            System.out.println("Quantidade inválida! Por favor, insira um número válido.");
            return;
        }

        String urlString = "https://api.frankfurter.dev/v1/latest?base=" + moedaOrigem;
        OkHttpClient cliente = new OkHttpClient();
        Request requisicao = new Request.Builder().url(urlString).get().build();
        Response resposta = cliente.newCall(requisicao).execute();

        if (!resposta.isSuccessful()) {
            System.out.println("Erro ao acessar a API! Verifique sua conexão.");
            return;
        }

        String respostaString = resposta.body().string();
        JSONObject objetoJson = new JSONObject(respostaString);
        JSONObject objetoTaxas = objetoJson.getJSONObject("rates");

        if (!objetoTaxas.has(moedaDestino)) {
            System.out.println("Moeda de destino não encontrada! Tente novamente.");
            return;
        }

        BigDecimal taxa = objetoTaxas.getBigDecimal(moedaDestino);
        BigDecimal resultado = taxa.multiply(quantidade);

        Currency moeda = Currency.getInstance(moedaDestino); 
        Locale locale = new Locale("en", "US");
        NumberFormat formatador = NumberFormat.getCurrencyInstance(locale);
        formatador.setCurrency(moeda);

        System.out.println("Resultado da conversão: " + formatador.format(resultado));
    }
}
