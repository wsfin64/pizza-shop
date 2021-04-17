package br.edu.ifpb.padroes.domain.adapter;

import br.edu.ifpb.padroes.api.pizzahot.PizzaHotPizza;
import br.edu.ifpb.padroes.domain.Pizza;

public class PizzahotAdapter implements Pizza {

    private PizzaHotPizza pizzaHotPizza;

    public PizzahotAdapter(PizzaHotPizza pizzaHotPizza) {
        this.pizzaHotPizza = pizzaHotPizza;
    }

    @Override
    public Float getPrice() {
        return pizzaHotPizza.getPrice();
    }

    @Override
    public String getName() {
        return pizzaHotPizza.getTopping();
    }
}
