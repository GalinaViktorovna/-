package com.hometask.module6;

import java.util.HashMap;

public class Runner {

    public static void main(String[] args) throws ExceptionInName, ExceptionOfQuantityInOrder {
        MusicToolsShop musicToolsShop = new MusicToolsShop();
        musicToolsShop.addToShop(new Guitar(), 16);
        musicToolsShop.addToShop(new Piano(), 2);
        musicToolsShop.addToShop(new Trumpet(), 7);
        MusicToolsShop.printShop(musicToolsShop);

        //case 1: ok
        musicToolsShop.removeMusicTools(new HashMap<String, Integer>() {
            {
                put(InstrumentType.GUITAR.toString(), 7);
                put(InstrumentType.TRUMPET.toString(), 2);
            }
        });
        MusicToolsShop.printShop(musicToolsShop);

        //case 2: not enough piano
        try {
            musicToolsShop.removeMusicTools(new HashMap<String, Integer>() {
                {
                    put(InstrumentType.PIANO.toString(), 3);
                }
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        MusicToolsShop.printShop(musicToolsShop);

        //case 3:wrong key
        try {
            musicToolsShop.removeMusicTools(new HashMap<String, Integer>() {
                {
                    put("balalayka", 3);
                }
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        MusicToolsShop.printShop(musicToolsShop);

        //case 4: wrong quantity

        try {
            musicToolsShop.removeMusicTools(new HashMap<String, Integer>() {
                {
                    put(InstrumentType.GUITAR.toString(), -2);
                }
            });

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        MusicToolsShop.printShop(musicToolsShop);

    }
}


