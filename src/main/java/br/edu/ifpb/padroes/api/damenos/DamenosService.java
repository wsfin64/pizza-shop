package br.edu.ifpb.padroes.api.damenos;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

// TODO - adicionar proxy de cache para evitar leitura do json a cada chamada do método
public class DamenosService {

    private Logger logger = Logger.getLogger(DamenosService.class.getName());

    public List<DamenosPizza> getPizzas() {
        List<DamenosPizza> pizzas = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            pizzas = Arrays.asList(objectMapper.readValue(ClassLoader.getSystemClassLoader().getResourceAsStream("data/damenos.json"), DamenosPizza[].class));
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Fail to read json", e);
        }
        return pizzas;
    }

}
