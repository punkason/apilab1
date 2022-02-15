package com.apilab.apilab1.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
public class CocktailControllerTests {
    @Autowired
    private MockMvc mockMvcController;

    @Test
    public void testCocktailWithNoParameter() throws Exception {
//Arrange, Act and Assert chained within the following statements

        String expectedContent = "mojito";
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/cocktail"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedContent));
    }

    @Test
    public void testCocktailWithAperolSpritz() throws Exception {
//Arrange, Act and Assert chained within the following statements

        String expectedContent = "Aperol Spritz";
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/cocktail").param("name", "Aperol Spritz"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedContent));
    }

}
