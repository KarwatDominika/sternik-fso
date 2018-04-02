package pl.sternik.dk.chinese.factrory;

import pl.sternik.dk.Thing;
import pl.sternik.dk.fso.car.CarBuildDirector;
import pl.sternik.dk.fso.car.Car;
import pl.sternik.dk.fso.car.CarBuilder;
import pl.sternik.dk.fso.car.KabrioBuilder;

class RaceCar extends Toy {
    public RaceCar() {
        super("Wyscigówa");
        System.out.println("-----------------------");
    }

    @Override
    public String toString() {
        return "RaceCar [nazwa=" + nazwa + "]" + super.toString();
    }
}

class Bear extends Toy {
    public Bear() {
        super("Misio");
        System.out.println("-----------------------");
    }

    @Override
    public String toString() {
        return "Bear [nazwa=" + nazwa + "]" + super.toString();
    }
}

public class ChineseFactory {
    private Thing toClone;

    public void setProductionLine(Thing thing) {
        toClone = thing;
    }

    public Thing produceNextItem() {
        return toClone.clone();
    }

    public static void main(String[] args) {
        ChineseFactory factory = new ChineseFactory();

        factory.setProductionLine(new RaceCar());
        for (int i = 1; i < 5; i++)
            System.out.println(factory.produceNextItem());
        factory.setProductionLine(new Bear());
        for (int i = 1; i < 5; i++)
            System.out.println(factory.produceNextItem());

        System.out.println("-----------------------");
        long start = System.nanoTime();
        CarBuilder kabrioBuilder = new KabrioBuilder();
        CarBuildDirector carBuildDirector = new CarBuildDirector(kabrioBuilder);

        Car car = carBuildDirector.constructSportVersion();
        System.out.println("Produkcja pierwszego cara:" + (System.nanoTime() - start));
        start = System.nanoTime();
        car = carBuildDirector.constructSportVersion();
        System.out.println("Produkcja drugiego cara:" + (System.nanoTime() - start));

        System.out.println("Jeden z nich trafia do kraju na dalekim wschodzie...");
        start = System.nanoTime();
        factory.setProductionLine(car);
        Thing[] produkcja = new Thing[5];
        for (int i = 0; i < 5; i++)
            produkcja[i] = factory.produceNextItem();
        long duration = System.nanoTime() - start;
        System.out.println("Klon 5 carów:" + duration + " srednio na jeden:" + duration / 5);

        for (int i = 0; i < produkcja.length; i++) {
            System.out.println(produkcja[i]);
        }
    }
}