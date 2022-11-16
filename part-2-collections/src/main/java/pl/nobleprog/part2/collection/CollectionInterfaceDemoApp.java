package pl.nobleprog.part2.collection;

import pl.nobleprog.katowice.part1.model.PepperoniPizza;
import pl.nobleprog.katowice.part1.model.Pizza;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Interfejs generyczny Collection:
 * - można dodać element,
 * - można usunąć element,
 * - usunąć wszystko,
 * - można sprawdzić, czy pusta,
 * - można sprawdzić, czy zawiera element,
 * - można przeglądać elementy za pomocą foreach.
 */
public class CollectionInterfaceDemoApp {
    public static void main(String[] args) {
        //interfejs Collection to podstawowa projekcja kolekcji
        //listy i zbiory go implementują
        Collection<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new Pizza("ser mozzarella", "oliwki", "cienkie ciasto"));
        pizzas.add(new Pizza("ser gouda", "ananas", "szynka", "cienkie ciasto"));
        System.out.println(pizzas);
        System.out.println("Contains: " + pizzas.contains(new Pizza("ser mozzarella", "oliwki", "cienkie ciasto")));   //czas liniowy!!!
        final boolean remove = pizzas.remove(new Pizza("ser mozzarella", "oliwki", "cienkie ciasto"));
        System.out.println("Remove: " + remove);
        for(var pizza: pizzas){
            System.out.println(pizza);
        }
        pizzas.add(new PepperoniPizza("pepperoni", "ser", "oliwki", "grube ciasto"));
        //możemy zainicjować nową kolekcję inną kolekcją
        Collection<Pizza> orderedPizzas = new ArrayList<>(pizzas);
        //klasa Collections to zbiór użytecznych metod i gotowych kolekcji
        //dodanie wiele elementów do kolekcji
        Collections.addAll(pizzas, new Pizza(), new PepperoniPizza(), new Pizza());
        final boolean disjoint = Collections.disjoint(pizzas, orderedPizzas);
        System.out.println("Do both collections have a common items? " + disjoint);
        //projekcja kolekcji zawierająca elementy wyspecyfikowanej klasy
        System.out.println(Collections.checkedCollection(pizzas, Pizza.class));
        final int frequency = Collections.frequency(pizzas, new Pizza());
        System.out.println("Frequency " + frequency);
        //synchronizowana kolekcja
        final Collection<Pizza> synchronizedPizzas = Collections.synchronizedCollection(pizzas);
    }
}
