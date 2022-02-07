package models;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String name;
    private int age;
    private String power;
    private String weakness;
    private int id;
    private int squadId;
    private static List<Hero> minstances =  new ArrayList<Hero>();

//   public Hero(String superman, int i, String sniffing, String love) {
//    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getPower() {
        return power;
    }

    public String getWeakness() {
        return weakness;
    }
    public static Hero findHero(int n) {
        return minstances.get(n-1);
    }
    public Hero(String name, int age, String power, String weakness, int squadId) {
        this.name = name;
        this.age = age;
        this.power = power;
        this.weakness = weakness;
        this.squadId = squadId;
        minstances.add(this);
        this.id = minstances.size();
    }

    public int getId() {
        return id;
    }
    public int getSquadId() {
        return squadId;
    }
    public static List<Hero> getAll() {
        return minstances;
    }
    public static void clearAllHeroes() {
        minstances.clear();
    }
}