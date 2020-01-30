package datastructures;

public class DynamicArray<String> {

    private Object[] data;

    private int size = 0;

    private int initialCapacity = 0;

    public DynamicArray(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        data = new Object[initialCapacity];
    }

    public String get(int index){

    }

    public void set(int index, String value){

    }

    public void insert(int index, String value){

    }

    public void delete(int index) {
    }

    public boolean isEmpty() {
    }

    public boolean Contains(String value) {
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
