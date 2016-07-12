package com.hometask.module6;

public class Runner {

    public static void main(String[] args) throws ExceptionInName, ExceptionOfQuantityInOrder {
        MusicToolsShop musicToolsShop = new MusicToolsShop();
        musicToolsShop.addToShop(new Guitar(), 16);
        musicToolsShop.addToShop(new Piano(), 2);
        musicToolsShop.addToShop(new Trumpet(), 7);
        System.out.println(musicToolsShop.toString());

        Order order = new Order();
        order.addToOrder("Guitar", 7);
        order.addToOrder("Trumpet", 2);
        musicToolsShop.startUp(order.getOrderedMusicInstruments());
        Order order2 = new Order();
        order2.addToOrder("Piano", 1);

        musicToolsShop.startUp(order2.getOrderedMusicInstruments());
        Order order3 = new Order();
        order3.addToOrder("Piano", 1);
        order3.addToOrder("Guitar", 8);
        order3.addToOrder("Trumpet", 6);
        musicToolsShop.startUp(order3.getOrderedMusicInstruments());
    }
}


