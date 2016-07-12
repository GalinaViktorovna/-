package com.hometask.module6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class MusicToolsShop {

    private List<MusicTool> musicInstrument = new ArrayList<>();

    @Override
    public String toString() {
        return "\nMusicToolsShop{\n" +
                "musicInstrument=" + musicInstrument +
                "\n";
    }


    public void addToShop(MusicTool musicTool, int quantity) {
        String name = musicTool.getName();
        NameMusicToolsEnum.NAME NAME_TOOL = NameMusicToolsEnum.NAME.valueOf(name);
        switch (NAME_TOOL) {
            case Guitar:
                for (int i = 0; i < quantity; i++) {
                    musicInstrument.add(new Guitar());
                }
                break;
            case Piano:
                for (int i = 0; i < quantity; i++) {
                    musicInstrument.add(new Piano());
                }
                break;
            case Trumpet:
                for (int i = 0; i < quantity; i++) {
                    musicInstrument.add(new Trumpet());
                }
                break;


        }

    }

    public List<MusicTool> prepareListToRemove(Map<String, Integer> order) throws ExceptionOfQuantityInOrder, ExceptionInName {

        List<MusicTool> result = new ArrayList<>();

        for (Map.Entry<String, Integer> orderEntry : order.entrySet()) {
            String toolType = orderEntry.getKey();

            Integer toolToBeRemoved = orderEntry.getValue();

            int toolRemoved = 0;
            for (MusicTool musicTool : musicInstrument) {
                if (musicTool.getName().equals(toolType) && toolRemoved < toolToBeRemoved) {
                    result.add(musicTool);
                    toolRemoved++;
                }
            }
            if (toolRemoved < toolToBeRemoved) {

                throw new IllegalArgumentException("\nShop does not have enough " + toolType + "s\n");
            }
        }
        return result;
    }

    public void removeMusicToolsFromTheShop(Map<String, Integer> order) throws ExceptionOfQuantityInOrder {
        for (Map.Entry<String, Integer> orderEntry : order.entrySet()) {
            String toolType = orderEntry.getKey();
            Integer toolToBeRemoved = orderEntry.getValue();
            int toolsRemoved = 0;
            Iterator<MusicTool> iterator = musicInstrument.iterator();
            while (iterator.hasNext()) {
                MusicTool musicTool = iterator.next();
                if (musicTool.getName().equals(toolType) && toolsRemoved < toolToBeRemoved) {
                    iterator.remove();
                    toolsRemoved++;
                }
            }
        }
    }

    public void startUp(Map<String, Integer> order) throws ExceptionInName, ExceptionOfQuantityInOrder {
        try {
            List<MusicTool> toolsToBeRemove = prepareListToRemove(order);
            removeMusicToolsFromTheShop(order);
            System.out.println("Order: " + toolsToBeRemove);
            System.out.println(toString());

        } catch (IllegalArgumentException e) {
            System.out.println("Exception happen " + e);
            System.out.println(toString());
        }
    }

}



