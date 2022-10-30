package dynamicarray;

public class MainApp {

    public static void main(String[] args) {

        DynamicArray dynamicArray = new DynamicArray();

        dynamicArray.add(66);
        System.out.println(dynamicArray);

        dynamicArray.add(0, 65);
        System.out.println(dynamicArray);

        dynamicArray.remove(67);

        dynamicArray.removeAt(3);

        dynamicArray.set(1, 64);
        System.out.println(dynamicArray);

        System.out.println("Your number : " + dynamicArray.get(1));

        System.out.println(dynamicArray.contains(65));

        dynamicArray.clear();
        System.out.println(dynamicArray);

        System.out.println("Is empty? >> " + dynamicArray.isEmpty());

        System.out.println(dynamicArray);
    }
}
