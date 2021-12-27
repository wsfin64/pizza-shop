package br.edu.ifpb.padroes.service;

import br.edu.ifpb.padroes.api.damenos.DamenosPizza;
import br.edu.ifpb.padroes.api.damenos.DamenosServiceImpl;
import br.edu.ifpb.padroes.api.damenos.proxy.DamenosService;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotPizza;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotServiceImpl;
import br.edu.ifpb.padroes.api.pizzahot.proxy.PizzaHotService;
import br.edu.ifpb.padroes.domain.Pizza;
import br.edu.ifpb.padroes.domain.adapter.DamenosAdapter;
import br.edu.ifpb.padroes.domain.adapter.PizzahotAdapter;

import java.util.ArrayList;
import java.util.List;

public class PizzaShopService {

    private DamenosService damenosService;
    private PizzaHotService pizzaHotService;

    public PizzaShopService() {
        // TODO - alterar criação de instância para chamar para o Proxy de Cache
        damenosService = new DamenosServiceImpl();
        pizzaHotService = new PizzaHotServiceImpl();
    }

    // TODO - implementar decorator para não precisar atributos da pizza como parâmetros no método
    public void orderPizza(Pizza pizza, boolean discountCoupon, boolean extraCheese, boolean panPizza, boolean stuffedCrust) {

        Float totalPrice = pizza.getPrice();
        String name = pizza.getName();

        // cupom de desconto
        if (discountCoupon) {
            totalPrice *= 0.25f; // 25% discount
        }

        // queijo extra
        if (extraCheese) {
            totalPrice *= 1.10f; // 10% increase
            name += " (extra cheese)";
        }

        // massa pan
        if (panPizza) {
            totalPrice *= 1.15f; // 15% increase
            name += " (pan pizza)";
        }

        // borda recheada
        if (stuffedCrust) {
            totalPrice *= 1.20f; // 20% increase
            name += " (stuffed crust)";
        }

        System.out.println(String.format("New order for = %s", name));
        System.out.println(String.format("Total price = %f", totalPrice));

    }

    // TODO - implementar adapter para unificar pizzas vindas das APIs Damenos e PizzaHot num único método getPizzas()
    // TODO - public List<Pizza> getPizzas() {}

    public List<Pizza> getPizzas(){
        List<Pizza> pizzas = new ArrayList<>();

        List<DamenosPizza> pizzasDamenos = damenosService.getPizzas();
        List<PizzaHotPizza> pizzaHotPizzas = pizzaHotService.getPizzas();

        for (DamenosPizza p : pizzasDamenos){
            Pizza pizzaAdaptada = new DamenosAdapter(p);
            pizzas.add(pizzaAdaptada);
        }

        for (PizzaHotPizza p : pizzaHotPizzas){
            Pizza pizzaAdaptadaHot = new PizzahotAdapter(p);
            pizzas.add(pizzaAdaptadaHot);
        }


        return pizzas;
    }

//    public List<DamenosPizza> getPizzasDamenos() {
//        return damenosService.getPizzas();
//    }
//
//    public List<PizzaHotPizza> getPizzasPizzaHot() {
//        return pizzaHotService.getPizzas();
//    }

}
