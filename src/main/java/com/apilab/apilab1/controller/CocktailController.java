package com.apilab.apilab1.controller;

import com.apilab.apilab1.model.Cocktail;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CocktailController {
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/cocktail")
    public Cocktail cocktail(@RequestParam(value = "name", defaultValue = "mojito") String name) {
        return new Cocktail(counter.incrementAndGet(), name);
    }
}
