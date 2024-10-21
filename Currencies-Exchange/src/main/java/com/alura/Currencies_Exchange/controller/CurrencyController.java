package com.alura.Currencies_Exchange.controller;

import com.alura.Currencies_Exchange.service.CurrencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/convert")
    public String convertCurrency(@RequestParam String from, @RequestParam String to, @RequestParam double amount) {
        Map<String, Object> rates = currencyService.getExchangeRates();
        double rate = (double) ((Map<String, Object>) rates.get("conversion_rates")).get(to);
        double convertedAmount = amount * rate;

        return String.format("%.2f %s = %.2f %s", amount, from, convertedAmount, to);
    }
}

//package com.alura.Currencies_Exchange.controller;
//
//import com.alura.Currencies_Exchange.service.CurrencyService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class CurrencyController {
//
//    @Autowired
//    private CurrencyService currencyService; // Inyectar el servicio de conversión
//
//    @GetMapping("/")
//    public String index(Model model) {
//        return "index"; // Nombre del archivo Thymeleaf
//    }
//
//    @PostMapping("/convert")
//    public String convert(@RequestParam double amount,
//                          @RequestParam String fromCurrency,
//                          @RequestParam String toCurrency,
//                          Model model) {
//        // Convierte el amount a String para pasarlo al servicio
//        String amountStr = String.valueOf(amount);
//
//        double convertedAmount = currencyService.convert(fromCurrency, toCurrency, amountStr);
//
//        model.addAttribute("convertedAmount", convertedAmount);
//        model.addAttribute("fromCurrency", fromCurrency);
//        model.addAttribute("toCurrency", toCurrency);
//        return "result"; // Nombre de la plantilla para mostrar el resultado
//    }
//
//}
