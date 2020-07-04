package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> tempExists = new HashMap<>();
        locations.put(0, new Location(0, "You're in front of the computer", tempExists));

        tempExists = new HashMap<>();
        tempExists.put("W", 2);
        tempExists.put("E", 3);
        tempExists.put("S", 4);
        tempExists.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building.\n" +
                "Around you is a forest.", tempExists));

        tempExists = new HashMap<>();
        tempExists.put("N", 5);
        locations.put(2, new Location(2, "You're at top of a hill", tempExists));

        tempExists = new HashMap<>();
        tempExists.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a large spring.", tempExists));

        tempExists = new HashMap<>();
        tempExists.put("N", 1);
        tempExists.put("W", 2);
        locations.put(4, new Location(4, "YOU ARE IN A VALLEY BESIDE A STREAM TUMBLING ALONG A    \n" +
                "ROCKY BED.", tempExists));

        tempExists = new HashMap<>();
        tempExists.put("S", 1);
        tempExists.put("W", 2);
        locations.put(5, new Location(5, "in the forest",tempExists));
        

        Map<String, String> options = Map.of("W", "WEST",
                "E", "EAST",
                "N", "NORTH",
                "S", "SOUTH",
                "Q", "QUIT");


        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0)
                break;
            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.println("Available exists are: ");

            for (String exist : exits.keySet()) {
                System.out.print(exist + ", ");
            }

            System.out.println();

            String dir = null;

            String[] input = scanner.nextLine().toUpperCase().split(" ");

            for (String word : input) {
                if (options.containsKey(word))
                    dir = word;
                else if (options.containsValue(word))
                    dir = word.substring(0, 1);
            }

            if(dir==null)
                System.out.println("Direction doesn't exist");
            else if (exits.containsKey(dir))
                loc = exits.get(dir.substring(0, 1));
            else
                System.out.println("Error");

        }
    }
}
