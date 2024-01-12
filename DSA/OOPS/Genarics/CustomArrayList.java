package Genarics;

import java.util.Arrays;

public class CustomArrayList {
    private int[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0;
    public CustomArrayList(){
        this.data = new int[DEFAULT_SIZE];
    }

    public void add(int num){
        if (isFull()) {
            resize();
        }
        data[size++]=num;
    }
    private void resize() {
        int[] temp = new int[data.length*2];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data=temp;
    }

    private boolean isFull() {
        return size == data.length;
    }

    public int remove(){
        int removed = data[--size];
        return removed;
    }
    public int get(int index){
        return data[index];
    }

    public void set(int index,int value){
        data[index]  = value;
    }
    
    public String toString(){
        return "Custmstring{ "+"data = "+ Arrays.toString(data)+" , size = "+size+ "}";
    }
    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList();
        list.add(3);
        list.add(6);
        list.add(10);
        System.out.println(list);
    }
}
