package pl.nobleprog.katowice.part1.wildcard;

import pl.nobleprog.katowice.part1.model.Box;

/**
 * Wildcard ? może być wykorzystywany w sytuacji, gdy nieznany jest typ uogólniony. Nie może wystąpić jako:
 * - typ argumentu wywołania metody,
 * - typ instancji tworzonego obiektu,
 * - typ superklasy.
 */
public class Sender {

    /**
     * Metoda przyjmuje pudełko, które należy wysłać. Można użyć znaku wildcard w sytuacji, gdy typ zawartości
     * pudełka nie jest znany.
     * Uycie
     * @param box
     */
    public static void send1(Box<?> box){
        final Object content = box.getContent();                //wildcard powoduje, że typ zawartości pudełka to Object
        System.out.println("Sending box with content type  " + box.getContent().getClass());
    }

    /**
     * Nie należy nadużywać znaku wildcard. Gdzie to możliwe należy używać typu uogólnionego.
     * Metoda jest także przykładem przechwytywania typów generycznych.
     * @param box
     * @param <T>
     */
    public static <T> void send2(Box<T> box){
        final T content = box.getContent();                     //typ zawartości pudełka to typ parametryczny
        System.out.println("Sending box with content type  " + box.getContent().getClass());
    }
}