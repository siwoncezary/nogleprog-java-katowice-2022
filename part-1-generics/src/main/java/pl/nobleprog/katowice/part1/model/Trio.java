package pl.nobleprog.katowice.part1.model;

import java.io.Serializable;

public class Trio <T, U, V> {

    private final T primary;
    private final U secondary;

    private final V third;

    private Trio(T primary, U secondary, V third) {
        this.primary = primary;
        this.secondary = secondary;
        this.third = third;
    }

    /**
     * Metoda statyczna wymaga podania typów generycznych po lewej stronie nazwy funkcji
     * @param t     pierwszy członek zespołu
     * @param u     drugi członek zespołu
     * @param v     trzeci członek zespołu
     * @return
     * @param <T>   typ pierwszego członka
     * @param <U>   typ drugiego członka
     * @param <V>   typ trzeciego członka
     */
    public static <T, U, V> Trio<T, U, V> create(T t, U u, V v){
        if (t instanceof Serializable && u instanceof Serializable && v instanceof Serializable ) {
            return new Trio(t, u, v);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public T getPrimary(){
        return primary;
    }

    public boolean isComplete(){
        return primary != null && secondary != null && third != null;
    }
}
