package hk.edu.polyu.comp.comp2021.simple.model;

public class Variable<T> {
    private T value;
    Variable(T value){
        this.value = value;
    }
    public T getvalue() {
        return this.value;
    }
    public void setvalue(T value) {
        this.value = value;
    }

}
