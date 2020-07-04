package com.example;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        this.exits = exits;
        this.exits.put("Q", 0);
    }

//    protected void addExist(String direction, int location) {
//        exits.put(direction, location);
//    }

    protected int getLocationID() {
        return locationID;
    }

    protected String getDescription() {
        return description;
    }

    //defensive coding. Returning a new exit map to prevent unwanted
    // tampering with exits HashMap.
    protected Map<String, Integer> getExits() {
        return new HashMap<>(exits);
    }
}
