public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> a = new MyArrayList<>();
        System.out.println("isEmpty(): " + a.isEmpty());
        System.out.print("Adding elements: 7, 34, 13\n\t");
        a.add(7);
        a.add(34);
        a.add(13);
        a.print();

        System.out.println("isEmpty(): " + a.isEmpty());
        System.out.println("size(): " + a.size());
        System.out.println("contains(34): " + a.contains(34));
        System.out.println("contains(3): " + a.contains(3));

        MyArrayList<Integer> checkingList = new MyArrayList<>();
        checkingList.add(34);
        checkingList.add(7);
        System.out.println("containsAll(List = {34, 7}): " + a.containsAll(checkingList));
        checkingList.add(88);
        System.out.println("containsAll(List = {34, 7, 88}): " + a.containsAll(checkingList) + "\n");

        a.addAll(checkingList);
        System.out.print("addAll(List = {34, 7, 88}):\n\t");
        a.print();

        System.out.print("\nremove(index: 2): " + a.remove(2) + "\n\t");
        a.print();

        Object b = 34;
        System.out.print("\nremove(Object: 34): number of removes: " + a.remove(b) + "\n\t");
        a.print();

        a.addAll(checkingList);
        a.add(12);
        a.add(9);
        System.out.print("\naddAll(List = {34, 7, 88, 12, 9}):\n\t");
        a.print();
        MyArrayList<Integer> deletingList = new MyArrayList<>();
        deletingList.add(88);
        deletingList.add(7);
        a.removeAll(deletingList);
        System.out.print("\nremoveAll(List = {88, 7}):\n\t");
        a.print();

        a.set(1, 44);
        System.out.print("\nset(1, 44):\n\t");
        a.print();

        System.out.println("\nget(1): " + a.get(1));


        System.out.println("indexOf(9): " + a.indexOf(9));

        Object[] array = a.toArray();
        System.out.print("toArray(): ");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1]);


        a.clear();
        System.out.print("clear():\n\t");
        a.print();

        System.out.print("\nChanging capacity:\n\t");
        System.out.print("Current capacity: " + a.getCurrentCapacity() + "\n\t");
        System.out.print("Adding 100 elements to MyArrayList\n\t\t");
        for(int i = 0; i< 100; i++){
            a.add(i);
        }
        System.out.print("Current capacity: " + a.getCurrentCapacity() + "\n\t");
        System.out.print("clear()\n\t\t");
        a.clear();
        System.out.print("Current capacity: " + a.getCurrentCapacity());

    }
}