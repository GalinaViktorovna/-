package com.hometask.module6;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private Map<String, Integer> orderedMusicInstruments = new HashMap<>();

    public Map<String, Integer> getOrderedMusicInstruments() {
        return orderedMusicInstruments;
    }

    public void addToOrder(String key, Integer value) throws ExceptionInName, ExceptionOfQuantityInOrder {
        try {
            if ((!key.equals("Guitar")) && (!key.equals("Trumpet")) && (!key.equals("Piano"))) {
                throw new ExceptionInName(("Type of music tool must be \"Guitar\" or \" \"Trumpet\" or \"Piano\"" +
                        "!!! \nYou enter wrong key :"), key);
            } else if (value <= 0) {
                throw new ExceptionOfQuantityInOrder("Quantity in order can not be < 1 or = 0.\n You enter " +
                        "wrong value :", value);
            } else {
                orderedMusicInstruments.put(key, value);
            }

        } catch (ExceptionInName e) {
            System.out.println("\n\n\n" + e + e.getName() + "\n\n\n");
        } catch (ExceptionOfQuantityInOrder e) {
            System.out.println(("\n\n\n" + e + " " + e.getQuantity()) + "\n\n\n");
        }
    }
}