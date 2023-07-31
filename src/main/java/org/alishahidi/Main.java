package org.alishahidi;

public class Main {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray(5);
        dynamicArray.add(5);
        dynamicArray.insert(0, "Hi");
        dynamicArray.add("Ali");
        dynamicArray.add("Melika");
        dynamicArray.add("Mohammad");
        dynamicArray.add("Mohammad");
        dynamicArray.add("Mohammad");
        dynamicArray.add("Mohammad");
        dynamicArray.add("Mohammad");
        dynamicArray.add("Mohammad");
        dynamicArray.add("Mohammad");
        dynamicArray.delete("Melika");
        System.out.println(dynamicArray.search("Ali"));;

        System.out.println(dynamicArray);
        System.out.println(dynamicArray.isEmpty());
        System.out.println(dynamicArray.getCapacity());
        System.out.println(dynamicArray.getSize());
    }
}