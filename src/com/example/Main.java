package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);

        locations.put(0, new Location(0, "You're in front of the computer"));
        locations.put(1, new Location(1, "You're at end of road with rock"));
        locations.put(2, new Location(2, "You're at top of a hill"));
        locations.put(3, new Location(3, "inside a building"));
        locations.put(4, new Location(4, "in a valley"));
        locations.put(5, new Location(5, "in the forest"));



        int loc = 1;
        while (true){
            System.out.println(locations.get(loc).getDescription());

            if (loc ==0)
                break;
            loc = scanner.nextInt();
            if (!locations.containsKey(loc)){
                System.out.println("You can't go in that direction");
            }
        }


    }
}
