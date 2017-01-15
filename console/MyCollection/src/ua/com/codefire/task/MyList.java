/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.task;

/**
 *
 * @author codefire
 */
public interface MyList {
    
    void add(int val);
    int get(int index);
    int[] getAll();
    int set(int index, int value);
    int remove(int index);
    int[] reverse();
    int[] sort();
    int[] shuffle();
}
