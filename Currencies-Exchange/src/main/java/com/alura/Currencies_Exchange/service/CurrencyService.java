package com.alura.Currencies_Exchange.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class CurrencyService {

    @Value("${currency.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public CurrencyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, Object> getExchangeRates() {
        return restTemplate.getForObject(apiUrl, Map.class);
    }

    public double convert(String fromCurrency, String toCurrency, String amount) {
        // Convertir el amount de String a double
        double amountDouble = Double.parseDouble(amount);

        Map<String, Object> exchangeRates = getExchangeRates();
        Map<String, Object> rates = (Map<String, Object>) exchangeRates.get("conversion_rates");

        // Obtener la tasa de cambio
        double fromRate = ((Number) rates.get(fromCurrency)).doubleValue(); // Safely convert to double
        double toRate = ((Number) rates.get(toCurrency)).doubleValue(); // Safely convert to double

        // Realizar la conversión
        return amountDouble / fromRate * toRate;
    }



}
