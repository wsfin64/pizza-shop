package br.edu.ifpb.padroes.api.pizzahot;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

// TODO - adicionar proxy de cache para evitar leitura do json a cada chamada do método
public class PizzaHotService {

    private Logger logger = Logger.getLogger(PizzaHotService.class.getName());

    public List<PizzaHotPizza> getPizzas() {

        // TODO - adicionar proxy de cache para evitar leitura do json a cada chamada do método

        List<PizzaHotPizza> pizzas = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            pizzas = Arrays.asList(objectMapper.readValue(ClassLoader.getSystemClassLoader().getResourceAsStream("data/pizza-hot.json"), PizzaHotPizza[].class));
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Fail to read json", e);
        }
        return pizzas;

    }

}
