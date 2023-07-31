package org.alishahidi;

import java.util.stream.IntStream;

public class DynamicArray {
    private int size;
    private int capacity = 10;
    private Object[] array;

    public DynamicArray() {
        array = new Object[capacity];
    }

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Object[] getArray() {
        return array;
    }

    public void add(Object data) {
        if (size >= capacity) {
            grow();
        }
        array[size] = data;
        size++;
    }

    public void insert(int index, Object data) {
        if (size >= capacity) {
            grow();
        }
        IntStream.iterate(size, i -> i > index, i -> i - 1).forEach(i -> array[i] = array[i - 1]);
        array[index] = data;
        size++;
    }

    public void delete(Object data) {
        for (int i = 0; i < size; i++) {
            if (array[i] == data) {
                for (int j = 0; j < (size - i - 1); j++) {
                    array[i + j] = array[i + j + 1];
                }
                array[size - 1] = null;
                size--;
                if (size <= (capacity / 3)) {
                    shrink();
                }
                break;
            }
        }
    }

    public int search(Object data) {
        for (int i = 0; i < size; i++) {
            if(array[i] == data){
                return i;
            }
        }
        return -1;
    }

    public void grow() {
        int newCapacity = capacity * 2;
        Object[] newArray = new Object[newCapacity];
        if (size >= 0) System.arraycopy(array, 0, newArray, 0, size);
        capacity = newCapacity;
        array = newArray;
     }

    public void shrink() {
        int newCapacity = capacity / 2;
        Object[] newArray = new Object[newCapacity];
        if (size >= 0) System.arraycopy(array, 0, newArray, 0, size);
        capacity = newCapacity;
        array = newArray;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            string.append(array[i]).append(", ");
        }
        if (!string.toString().equals("[")) {
            string.setLength(string.length() - 2);
        }
        string.append("]");
        return string.toString();
    }
}
