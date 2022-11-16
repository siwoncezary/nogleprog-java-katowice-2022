package pl.nobleprog.katowice.part1.bound;
import pl.nobleprog.katowice.part1.model.Pizza;

/**
 * Klasa generyczna z ograniczeniem do klas pochodnych, PizzaBox można tworzyć dla
 * parametru T klasy Pizza i wszystkich klas po niej dziedziczących.
 */
public class PizzaBox<T extends Pizza> {
    private final T pizza;

    public PizzaBox(T pizza) {
        this.pizza = pizza;
    }

    /**
     * Metoda kopiuje składniki pizzy wyjętej z pudełka podanego w parametrze do pizzy w bieżącym pudełku.
     * Metoda akceptuje pudełka z dowolnym typem uogólnionym, może zaakceptować pudełko na cokolwiek
     * np. PizzaBox<String> jak i PizzaBox<PepperoniPizza>.
     * @param pizzaBox
     */
    public void copyIngredients1(PizzaBox<?> pizzaBox){
        pizzaBox.getPizza().setIngredients(pizzaBox.getPizza().getIngredients());
    }

    /**
     * Metoda wykonuje to samo co poprzednia, ale pudełko jest tylko dla typu bazowego, nie akceptuje pudełka z klasami
     * wyprowadzonymi z Pizza np. PepperoniPizza.
     * @param pizzaBox
     */
    public void copyIngredients2(PizzaBox<Pizza> pizzaBox){
        pizzaBox.getPizza().setIngredients(pizzaBox.getPizza().getIngredients());
    }

    /**
     * Trzecia wersja metody, która akceptuje pudełka na klasy, które wyprowadzone są tylko z klasy Pizza,
     * a więc nie zaakceptuje np. PizzaBox<String>.
     * @param pizzaBox
     */
    public void copyIngredients3(PizzaBox<? extends Pizza> pizzaBox){
        pizzaBox.getPizza().setIngredients(pizzaBox.getPizza().getIngredients());
    }

    public T getPizza(){
        return pizza;
    }

    public PizzaBox<? super Pizza> repack(PizzaBox<? extends Pizza> box){
        return new PizzaBox<>(box.pizza);
    }

    @Override
    public String toString() {
        return String.format("class PizzaBox {pizza: %s}", pizza);
    }
}
