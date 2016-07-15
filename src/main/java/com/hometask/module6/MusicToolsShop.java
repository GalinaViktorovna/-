package com.hometask.module6;

import java.util.*;


public class MusicToolsShop {

    private List<MusicTool> musicInstrument = new ArrayList<>();

    @Override
    public String toString() {
        return "\nMusicToolsShop{\n" +
                "musicInstrument=" + musicInstrument +
                "\n";
    }

    public HashMap<String, Integer> prepareInstruments(HashMap<String, Integer> order) throws ExceptionInName, ExceptionOfQuantityInOrder {
        for (Map.Entry<String, Integer> orderEntry : order.entrySet()) {
            String toolType = orderEntry.getKey();
            Integer toolToBeRemoved = orderEntry.getValue();
            int toolsRemoved = 0;
            for (MusicTool musicTools : musicInstrument) {
                if ((!InstrumentType.GUITAR.toString().equalsIgnoreCase(toolType)) &&
                        (!InstrumentType.TRUMPET.toString().equalsIgnoreCase(toolType) &&
                                (!InstrumentType.PIANO.toString().equalsIgnoreCase(toolType)))) {
                    throw new ExceptionInName(("\nType of music tool must be \"GUITAR\" or \" \"TRUMPET\"" +
                            " or \"PIANO\"" + "!!! \nYou enter wrong key : " + toolType + "\n"));
                } else if (toolToBeRemoved <= 0) {
                    throw new ExceptionOfQuantityInOrder("\nQuantity in order can not be < 1 or = 0.\n You enter " +
                            "wrong value :" + toolToBeRemoved + "\n");
                }
                if (musicTools.getName().equals(toolType) && toolsRemoved < toolToBeRemoved) {
                    toolsRemoved++;
                }
            }
            if (toolsRemoved < toolToBeRemoved) {
                throw new IllegalArgumentException("\nShop does not have enough " + toolType + "s\n");
            }
        }
        return order;
    }

    //        private Map<String, Long> getInstrumentsCounted () {
    //            return musicInstrument.stream().map(musicTool -> musicTool.getName().toLowerCase()).
    //                    collect(Collectors.groupingBy(java.util.function.Function.identity(), Collectors.counting()));
    //        }
    public Map<String, Long> getInstrumentsCounted() {
        Set<String> uniqueInstrument = new HashSet<>();
        for (MusicTool instrument : musicInstrument) {
            uniqueInstrument.add(instrument.getName().toLowerCase());
        }
        Map<String, Long> result = new HashMap<>();
        for (String instrumentName : uniqueInstrument) {
            long count = 0;
            for (int i = 0; i < musicInstrument.size(); i++) {
                if (instrumentName.equalsIgnoreCase(musicInstrument.get(i).getName())) count++;
            }
            if (count > 0) result.put(instrumentName, count);
        }
        return result;
    }

    public static void printShop(MusicToolsShop musicToolsShop) {
        musicToolsShop.getInstrumentsCounted().forEach((k, v) -> System.out.println(k + ":" + v));
    }

    public void addToShop(MusicTool musicTool, int quantity) {
        String name = musicTool.getName();
        InstrumentType type_TOOL = InstrumentType.valueOf(name);
        switch (type_TOOL) {
            case GUITAR:
                for (int i = 0; i < quantity; i++) {
                    musicInstrument.add(new Guitar());
                }
                break;
            case PIANO:
                for (int i = 0; i < quantity; i++) {
                    musicInstrument.add(new Piano());
                }
                break;
            case TRUMPET:
                for (int i = 0; i < quantity; i++) {
                    musicInstrument.add(new Trumpet());
                }
                break;
        }
    }

    public void removeMusicTools(HashMap<String, Integer> order) throws ExceptionInName, ExceptionOfQuantityInOrder {
        prepareInstruments(order);
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
}






