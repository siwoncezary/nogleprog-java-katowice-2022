package pl.nobleprog.katowice.part1.exercise;

/**
 * Zdefiniuj metodę kopiującą, aby działała dla typów zgodnych np. kopiowanie do Task1<Pizza> zawartości Task1<PepperoniPizza>
 * przy założeniu, że PepperoniPizza dziedziczy po Pizza.
 * Przykłady:
 * Task1<Integer> t3 = new Task1<>(12);
 * Task1<Number> t4 = new Task1<>(4);
 * Task1.copy(t3, t4);
 * Task1<PepperoniPizza> t5 = new Task1<>(new PepperoniPizza());
 * Task1<Pizza> t6 = new Task1<>(new Pizza());
 * Task1.copy(t5, t6);
 */
public class Task1<T> {
    private T value;

    public Task1(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public static<T> void copy(Task1<T> source, Task1<T> target){

    }

    @Override
    public String toString() {
        return String.format("Class Task1{value: %s}", value);
    }
}
