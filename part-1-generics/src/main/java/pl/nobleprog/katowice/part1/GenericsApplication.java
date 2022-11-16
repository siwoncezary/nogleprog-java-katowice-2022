package pl.nobleprog.katowice.part1;


import pl.nobleprog.katowice.part1.bound.PizzaBox;
import pl.nobleprog.katowice.part1.model.Box;
import pl.nobleprog.katowice.part1.model.PepperoniPizza;
import pl.nobleprog.katowice.part1.model.Pizza;
import pl.nobleprog.katowice.part1.wildcard.Sender;

public class GenericsApplication {

    public static void main(String[] args) {
        example1();
    }


    /**
     * Tworzenie zmiennych klas generycznych
     */
    public static void example1(){
        Box<String> stringBox = new Box<>("Hello from box");
        Box<Pizza> pizzaBox = new Box<>(new Pizza("ser", "sos pomidorowy", "ciasto"));

        System.out.println(stringBox);
        System.out.println(pizzaBox);
    }

    /**
     * Wywołania metod, które przyjmują argumenty z wildcard
     */
    public static void example2(){
        Sender.send1(new Box<>(12));        //Box<?>
        Sender.send2(new Box<>(12));        //Box<T>
    }

    /**
     * Ograniczenie górne klasy PizzaBox.
     * Klasy PizzaBox można tworzyć tylko dla klas Pizza i jej pochodnych
     */
    public void example3(){
        Pizza pizza = new Pizza("ser", "szynka");
        PizzaBox<Pizza> box1 = new PizzaBox<>(pizza);
        PizzaBox<Pizza> box2 = new PizzaBox<>(new Pizza("ananas", "pepperoni"));
        PizzaBox<PepperoniPizza> box3 = new PizzaBox<>(new PepperoniPizza());
        box1.copyIngredients1(box2);
        box1.copyIngredients1(box3);
    }

    /**
     * Dziedziczenie a typy generyczne. Pudełko Box<Pizza> akceptuje jako zawartość obiekty klas pochodnych.
     */
    public void example4(){
        Box<Pizza> box = new Box<>(new Pizza("ser", "szynka"));
        //Do pudełka na klasę Pizza można włożyć klasy pochodne np. PepperoniPizza
        final PepperoniPizza pepperoniPizza = new PepperoniPizza("pepperoni", "ser");
        box.setContent(pepperoniPizza);
        System.out.println(box);
        Box<PepperoniPizza> box1 = new Box<>(pepperoniPizza);
        //chociaż w box i box1 mamy tę samą pizzę to pudełka nie są tego samego typu!!!
        //box = box1;               //niepoprawne przypisanie, niezgodne typy, błąd kompilacji
    }

    /**
     * Kowariantność. Ograniczenie górne powoduje, że z pudełka możemy wyciągnąć zawartość,
     * ale nie można jej zmienić!!!
     */
    public void example5(){
        Box<? extends Pizza> pizzaBox = new Box<>(new Pizza("ser", "szynka"));
        final Pizza pizza = pizzaBox.getContent();                      //pobranie zawartości
        //pizzaBox.setContent(new Pizza("pieczarki"));                  //zmiana zawartości nie skompiluje się!
    }

    /**
     * Kontrwariantność. Ograniczanie dolne powoduje, że do pudełka możemy wstawiać dowolną zawartość zgodną z ograniczeniem,
     * ale nie możemy tej zwartości odczytać zgodnie z typem zwartości.
     */
    public void example6(){
        Box<? super Pizza> pizzaBox = new Box<>(new Pizza("ser", "szynka"));
        final Object content = pizzaBox.getContent();                     //pobranie zawartości jest możliwe tylko jako typu Object
        pizzaBox.setContent(new Pizza("ser"));                 //zmiana zawartości zgodnie z typem aktualnej zawartości
        pizzaBox.setContent(new PepperoniPizza("pepperoni"));  //zmiana zawartości na inny typ dziedziczący po Pizza
        Box<? super Pizza> objectBox = new Box<>(new Object());           //Kontrwariancja
        objectBox = pizzaBox;                                             //pudełka na pizze i obiekty są zgodne!
        pizzaBox = objectBox;
    }
}


