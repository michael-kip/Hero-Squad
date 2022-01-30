package models;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private  String mName;
    private  int mAge;
    private String mPower;
    private String mWeakness;
    private int mHeroId;
    private static List<Hero>heroesRegister= new ArrayList<Hero>();

    public Hero(String mName, int mAge, String mPower, String mWeakness) {
        this.mName = mName;
        this.mAge = mAge;
        this.mPower = mPower;
        this.mWeakness = mWeakness;
        heroesRegister.add(this);
        mHeroId = heroesRegister.size();
    }

    public String getmName() {
        return mName;
    }

    public int getmAge() {
        return mAge;
    }

    public String getmPower() {
        return mPower;
    }

    public String getmWeakness() {
        return mWeakness;
    }
    public int getmHeroId(){
        return mHeroId;
    }
    public static Hero findHero(int searchId){
        return heroesRegister.get(searchId-1);
    }
    public static List<Hero> heroes(){
        return heroesRegister;
    }
    public static void clearRegister(){
        heroesRegister.clear();
    }

}
