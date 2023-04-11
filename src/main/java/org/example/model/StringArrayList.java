package org.example.model;


import org.example.exception.ElementNotFoundException;

import org.example.exception.MyIndexOutOfBoundsException;
import org.example.exception.NullParamException;

import java.util.Arrays;

public class StringArrayList implements StringList {

    String[] stringArray = new String[0];

    @Override
    public String add(String item) {
        if (item == null)
            throw new NullParamException("Null Param Accrued");

        stringArray = Arrays.copyOf(stringArray, stringArray.length + 1);
        stringArray[stringArray.length - 1] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (item == null)
            throw new NullParamException("Null Param Accrued");
        if (this.stringArray.length < 1) {
            throw new MyIndexOutOfBoundsException("Empty List");
        }
        if (index > stringArray.length)
            throw new MyIndexOutOfBoundsException("Index out of bounds");

        stringArray = Arrays.copyOf(stringArray, stringArray.length + 1);
        for (int i = stringArray.length - 1; i > index; i--) {
            stringArray[i] = stringArray[i - 1];
        }
        stringArray[index] = item;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (item == null)
            throw new NullParamException("Null Param Occurred");
        if (index >= stringArray.length)
            throw new MyIndexOutOfBoundsException("Index out of bounds");

        stringArray[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {

        if (this.stringArray.length < 1)
            throw new ElementNotFoundException("No such element");

        if (!isInArray(item)) {
            throw new ElementNotFoundException("No such element");
        }
        String[] newArray = new String[this.stringArray.length - 1];
        for (int i = 0, k = 0; i < this.stringArray.length; i++) {
            if (!this.stringArray[i].equals(item)) {
                newArray[k] = this.stringArray[i];
                k++;
            }
        }
        this.stringArray = newArray;
        return item;
    }

    @Override
    public String remove(int index) {

        if (this.stringArray.length < 1)
            throw new MyIndexOutOfBoundsException("Index out of bounds, list is empty");

        if (index >= this.stringArray.length)
            throw new MyIndexOutOfBoundsException("Out of bounds");

        String result = "";

        String[] newArray = new String[this.stringArray.length - 1];
        for (int i = 0, k = 0; i < this.stringArray.length; i++) {
            if (i != index) {
                newArray[k] = this.stringArray[i];
                k++;
            } else {
                result = this.stringArray[i];
            }
        }
        this.stringArray = newArray;
        return result;
    }


    @Override
    public boolean contains(String item) {
        for (String s : this.stringArray) {
            if (item.equals(s))
                return true;
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < this.stringArray.length; i++) {
            if (this.stringArray[i].equals(item))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = this.stringArray.length - 1; i >= 0; i--) {
            if (this.stringArray[i].equals(item))
                return i;
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (this.stringArray.length < 1 || this.stringArray.length < index)
            throw new MyIndexOutOfBoundsException("Index out of bounds");
        return this.stringArray[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null)
            throw new NullParamException("Null param occurred");
        if (this.stringArray.length != otherList.size())
            return false;

        String[] tmpArray = otherList.toArray();

        for (int i = 0; i < this.stringArray.length; i++) {
            if (!this.stringArray[i].equals(tmpArray[i]))
                return false;
        }
        return true;
    }

    @Override
    public int size() {
        return this.stringArray.length;
    }

    @Override
    public boolean isEmpty() {
        return this.stringArray.length == 0;
    }

    @Override
    public void clear() {
        this.stringArray = new String[0];
    }

    @Override
    public String[] toArray() {
        String[] result = new String[this.stringArray.length];
        System.arraycopy(this.stringArray, 0, result, 0, result.length);
        return result;
    }

    private boolean isInArray(String item) {
        for (String s : this.stringArray) {
            if (item.equals(s))
                return true;
        }
        return false;
    }
}