package MyLinkedList;

public class MyLinkedListTest {
    public static void start() {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        int counter = 0;
        System.out.println("Adding elements:\nlist.add(1);\nlist.add(2);\nlist.add(3);\n");
        list.add(1);
        list.add(2);
        list.add(3);

        counter = 0;
        for(Object o : list){
            System.out.println("\t" + counter + ") " + o);
            counter++;
        }

        System.out.println();

        System.out.println("size(): " + list.size());
        System.out.println();

        System.out.println("contains(7): " + list.contains(7));
        System.out.println("contains(2): " + list.contains(2));
        System.out.println();


        System.out.print("Print via iterator:\n\t");
        for (Integer o : list) {
            System.out.print(o + " ");
        }
        System.out.println();


        System.out.println("\ntoArray()");
        System.out.print("Print via array:\n\t");
        Object[] array = list.toArray();
        for (Object o : array) {
            System.out.print(o + " ");
        }
        System.out.println();


        MyLinkedList<Integer> checkingList = new MyLinkedList<Integer>();
        checkingList.add(2);
        checkingList.add(3);
        System.out.println("\ncontainsAll(2, 3): " + list.containsAll(checkingList));
        checkingList.add(5);
        System.out.println("containsAll(2, 3, 5): " + list.containsAll(checkingList));
        System.out.println();


        System.out.println("addAll(2, 3, 5):");
        list.addAll(checkingList);
        counter = 0;
        for(Object o : list){
            System.out.println("\t" + counter + ") " + o);
            counter++;
        }
        System.out.println();


        System.out.println("list.get(index: 4): " + list.get(4));
        System.out.println();


        System.out.println("list.set(4, 7): " + list.set(4, 7));
        counter = 0;
        for(Object o : list){
            System.out.println("\t" + counter + ") " + o);
            counter++;
        }
        System.out.println();


        list.add(3, 6);
        counter = 0;
        for(Object o : list){
            System.out.println("\t" + counter + ") " + o);
            counter++;
        }
        System.out.println();


        System.out.println("remove(index: 1):");
        list.remove(1);
        counter = 0;
        for(Object o : list){
            System.out.println("\t" + counter + ") " + o);
            counter++;
        }
        System.out.println();


        System.out.println("remove(Object: 2):");
        list.remove((Object) 2);
        counter = 0;
        for(Object o : list){
            System.out.println("\t" + counter + ") " + o);
            counter++;
        }
        System.out.println();


        System.out.println("removeAll(2, 3, 5):");
        list.removeAll(checkingList);
        counter = 0;
        for(Object o : list){
            System.out.println("\t" + counter + ") " + o);
            counter++;
        }
        System.out.println();


        System.out.println("isEmpty():" + list.isEmpty());
        System.out.println("clear()");
        list.clear();
        counter = 0;
        for(Object o : list){
            System.out.println("\t" + counter + ") " + o);
            counter++;
        }
        System.out.println("isEmpty():" + list.isEmpty());
        System.out.println();
    }
}
