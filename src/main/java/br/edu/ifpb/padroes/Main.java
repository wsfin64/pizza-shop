package br.edu.ifpb.padroes;

import br.edu.ifpb.padroes.api.damenos.DamenosPizza;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotPizza;
import br.edu.ifpb.padroes.domain.Pizza;
import br.edu.ifpb.padroes.domain.PizzaShopPizza;
import br.edu.ifpb.padroes.domain.adapter.DamenosAdapter;
import br.edu.ifpb.padroes.domain.adapter.PizzahotAdapter;
import br.edu.ifpb.padroes.service.PizzaShopService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        PizzaShopService pizzaShopService = new PizzaShopService();

        System.out.println("Pizzas - menu");

        // TODO - implementar adapter para juntar as pizzas da PizzaHot e Damenos em um único conjunto
//        for (PizzaHotPizza pizza : pizzaShopService.getPizzasPizzaHot()) {
//            System.out.println(String.format("%s - %.2f", pizza.getTopping(), pizza.getPrice()));
//        }
//        for (DamenosPizza pizza : pizzaShopService.getPizzasDamenos()) {
//            System.out.println(String.format("%s - %.2f", pizza.getName(), pizza.getCost()));
//        }
        List<Pizza> pizzas = pizzaShopService.getPizzas();

        for (Pizza p : pizzas){

            if (p instanceof PizzahotAdapter){
                PizzahotAdapter pizzahotAdapter = (PizzahotAdapter) p;
                System.out.println(String.format("%s - %.2f", pizzahotAdapter.getName(), pizzahotAdapter.getPrice()));
            }

            if (p instanceof DamenosAdapter){
                DamenosAdapter pizzaDamenos = (DamenosAdapter) p;
                System.out.println(String.format("%s - %.2f", pizzaDamenos.getName(), pizzaDamenos.getPrice()));
            }
        }


        Pizza pizza = new PizzaShopPizza("pepperoni", 55.0f);

        // TODO - implementar padrão decorator para só precisar passar o objeto pizza
        pizzaShopService.orderPizza(pizza, true, true, false, true);

    }

}
