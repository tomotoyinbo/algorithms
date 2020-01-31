package datastructures;

public class DynamicArray<T> {

    private Object[] data;

    private int size = 0;

    private int initialCapacity = 0;

    public DynamicArray(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        data = new Object[initialCapacity];
    }

    public T get(int index){
        return (T) data[index];
    }

    public void set(int index, String value){

        if(index > initialCapacity){
            resize();
        }

        data[index] = value;
    }

    public void add(String value){

        if(size == initialCapacity){
            resize();
        }

        data[size] = value;

        size++;
    }

    public void insert(int index, String value){

        if(size+1 > initialCapacity){
            resize();
        }

        for(int i = size-1; i >= index; i--){
            data[i+1] = data[i];
        }

        data[index] = value;
        size++;
    }

    public void delete(int index) {

       if(index >= 0 ){
           for(int i = index; i < size; i++){
               data[i] = data[i+1];
           }
           size--;
       }
    }

    public boolean isEmpty() {
        return size < 1;
    }

    public boolean Contains(String value) {
        for(int i = 0; i <= size; i++){
            if(data != null && !isEmpty() && data[i].equals(value)){
                return true;
            }
        }
        return false;
    }

    private void resize() {

        Object[] newData = new Object[initialCapacity * 2];

        for (int i = 0; i < initialCapacity; i++) {
            newData[i] = data[i];
        }

        data = newData;
        initialCapacity = initialCapacity * 2;
    }

    public int size() {
        return size;
    }

    public void print() {
        for (int i=0;i< size;i++) {
            System.out.println("data[i] = " + data[i]);
        }
    }
}
