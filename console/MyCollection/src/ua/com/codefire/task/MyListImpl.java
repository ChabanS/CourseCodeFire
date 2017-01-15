/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.task;

import java.util.Collections;
import java.util.Random;

/**
 *
 * @author codefire
 */
public class MyListImpl implements MyList {

    private Integer[] data;

    private int size =0;
    
    public int size() {
        return size;
    }

    public MyListImpl() {
        this.data = new Integer[10];
    }

    public MyListImpl(int length) {
        this.data = new Integer[length];
    }

    
    @Override
    public void add(int val) {
        capacity();
        data[size] = val;
        size++;
    }


    @Override
    public int get(int index) {
          return data[index];
    }

    @Override
    public int[] getAll() {
        int[] getAll = new int[size];
        for (int i = 0; i < size; i++) {
            getAll[i]=data[i];
        }
        return getAll;
    }

    @Override
    public int set(int index, int value) {
        int tmp = data[index];
        data[index]=value;
        return tmp;
    }

    @Override
    public int remove(int index) {
        int tmp = data[index];
        int numMoved = size - index - 1;
        System.arraycopy(data, index + 1, data, index, numMoved);
        data[--size] = null;
        return tmp;
    }

    @Override
    public int[] reverse() {
        int[] array = getAll();
        for(int i = 0; i < array.length / 2; i++){
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }

    @Override
    public int[] sort() {
        quickSort();
        return getAll();
    }

    @Override
    public int[] shuffle() {
       return shuffleArray(getAll());
    }

    private void capacity() {
        if(data.length==size){
            Integer[] tmp = new Integer[(data.length * 3) / 2 + 1];
            System.arraycopy(data, 0, tmp, 0, data.length);
            data = tmp;
        }
    }
    
    private void quickSort() {
        int startIndex = 0;
        int endIndex = size - 1;
        doSort(startIndex, endIndex);
    }

    private void doSort(int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (data[i] <= data[cur])) {
                i++;
            }
            while (j > cur && (data[cur] <= data[j])) {
                j--;
            }
            if (i < j) {
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort(start, cur);
        doSort(cur+1, end);
    }
    
    int[] shuffleArray(int[] array){
    Random random = new Random();
    for (int i = array.length - 1; i > 0; i--)
    {
      int index = random.nextInt(i + 1);
      int a = array[index];
      array[index] = array[i];
      array[i] = a;
    }
    return array;
  }
}
