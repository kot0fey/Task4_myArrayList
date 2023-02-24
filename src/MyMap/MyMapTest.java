package MyMap;

public class MyMapTest {
    public static void start(){

        MyMap<Integer, Integer> map = new MyMap<Integer, Integer>();
        System.out.println("Adding elements:\n\tmap.put(72, 1)\n\tmap.put(56, 2)\n\tmap.put(40, 3)\n\tmap.put(28, 4)\n\tmap.put(30, 5)");
        map.put(72, 1);
        map.put(56, 2);
        map.put(40, 3);
        map.put(28, 4);
        map.put(30, 5);
        System.out.println("\t" + map.entrySet());
        System.out.println();


        System.out.println("Adding existing element:\n\tmap.put(28, 5)");
        map.put(28, 5);
        System.out.println("\tMyMap: " + map.entrySet());
        System.out.println();


        System.out.println("containsKey(72): " + map.containsKey(72));
        System.out.println("containsKey(7): " + map.containsKey(7));
        System.out.println();


        System.out.println("containsValue(2): " + map.containsValue(2));
        System.out.println("containsValue(7): " + map.containsValue(7));
        System.out.println();


        System.out.println("get(40): " + map.get(40));
        System.out.println();


        MyMap<Integer, Integer> additionalMap = new MyMap<Integer, Integer>();
        additionalMap.put(450, 760);
        additionalMap.put(140, 680);
        additionalMap.put(990, 120);
        map.putAll(additionalMap);
        System.out.println("putAll(" + additionalMap.entrySet() + "):");
        System.out.println("\tMyMap: " + map.entrySet());
        System.out.println();


        System.out.println("keySet(): " + map.keySet());
        System.out.println("values(): " + map.values());
        System.out.println();


        System.out.println("Removing element:\n\tmap.remove(56)");
        System.out.println("\tMyMap: " + map.entrySet());
        map.remove(56);
        System.out.println("\tMyMap: " + map.entrySet());
        System.out.println();


        System.out.println("isEmpty():" + map.isEmpty());
        System.out.println("clear()");
        map.clear();
        System.out.println("\tMyMap: " + map.entrySet());
        System.out.println("isEmpty():" + map.isEmpty());
        System.out.println();
    }
}
