package dynamicarray;

import java.util.Arrays;

public class DynamicArray implements Dynamic {

    private int[] array;

    private final int size = 10;

    private int count;

    public DynamicArray(int capacity) {
        this.array = new int[capacity > 0 ? capacity : size];
        this.count = 0;
    }

    public DynamicArray() {
        this.count = 0;
        this.array = new int[size];
    }

    @Override
    public void add(int data) {
        if (array.length - count < 2) {
            growSize();
        }
        array[count] = data;
        count++;
    }

    @Override
    public void add(int index, int data) {
        if (array.length - count < 2) {
            growSize();
        }
        if (index > count) {
            add(data);
        }
        System.arraycopy(array, index, array, index + 1, count - index);
        array[index] = data;
        count++;
    }

    @Override
    public void remove(int data) {
        for (int i = 0; i < count; i++) {
            if (array[i] == data) {
                System.arraycopy(array, i + 1, array, i, count - 1 - i);
                count--;
                break;
            }
        }
    }

    @Override
    public void removeAt(int index) {
        if (index < count) {
            System.arraycopy(array, index + 1, array, index, count - 1 - index);
            count--;
        } else {
            System.out.println("There is no value at this index >> " + index);
        }
    }

    @Override
    public void growSize() {
        array = Arrays.copyOf(array, array.length * 2);
    }

    @Override
    public void shrinkSize() {
        if (!isEmpty()) {
            array = Arrays.copyOf(array, count);
        }
    }

    @Override
    public void set(int index, int data) {
        if (index < count) {
            array[index] = data;
        }
    }

    @Override
    public int get(int index) {
        if (index < count) {
            return array[index];
        }
        System.out.println("There is no value at this index >> " + index);
        return index;
    }

    @Override
    public void clear() {
        for (int i = count - 1; i >= 0; i--) {
            array[i] = 0;
        }
        count = 0;
    }

    @Override
    public boolean contains(int data) {
        for (int i = 0; i < count; i++) {
            if (array[i] == data) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return count < 1;
    }

    @Override
    public String toString() {
        if (!isEmpty()) {
            shrinkSize();
            return Arrays.toString(array);
        }
        return "Nothing to print";
    }
}
