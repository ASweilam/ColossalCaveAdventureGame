package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);

        locations.put(0, new Location(0, "You're in front of the computer"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building.\n" +
                "Around you is a forest."));
        locations.put(2, new Location(2, "You're at top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a large spring."));
        locations.put(4, new Location(4, "YOU ARE IN A VALLEY BESIDE A STREAM TUMBLING ALONG A    \n" +
                "ROCKY BED."));
        locations.put(5, new Location(5, "in the forest"));

        locations.get(1).addExist("W", 2);
        locations.get(1).addExist("E", 3);
        locations.get(1).addExist("S", 4);
        locations.get(1).addExist("N", 5);

        locations.get(2).addExist("N", 5);


        locations.get(3).addExist("W", 1);

        locations.get(4).addExist("N", 1);
        locations.get(4).addExist("W", 2);

        locations.get(5).addExist("S", 1);
        locations.get(5).addExist("W", 2);


        int loc = 1;
        while (true){
            System.out.println(locations.get(loc).getDescription());

            if (loc ==0)
                break;
            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.println("Available exists are: ");

            for (String exist: exits.keySet()
                 ) {
                System.out.print(exist + ", ");
            }

            System.out.println();

            String direction = scanner.nextLine().toUpperCase();

            if (exits.containsKey(direction)){
                loc = exits.get(direction);
            } else {
                System.out.println("Wrong direction");
            }
        }


    }
}
