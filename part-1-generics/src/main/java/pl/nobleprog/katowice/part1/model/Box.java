package pl.nobleprog.katowice.part1.model;

public class Box<T>{
    private T content;          //pole typu generycznego

    public Box(T content) {     //metoda z parametrem generycznym
        this.content = content;
    }

    public T getContent() {     //metoda zwracająca typ generyczny
        return content;
    }

    public void setContent(T content){
        this.content = content;
    }

    public boolean isEmpty(){
        return content == null;
    }

    @Override
    public String toString() {
        return String.format("Class Box { content: %s }", content.toString());
    }

    //metoda generyczna może być definiowania w dowolnej klasie
    public static <T> Box<T> of(T content){
        if (content == null){
            throw new IllegalArgumentException();
        }
        return new Box<>(content);
    }
}
