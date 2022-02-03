package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {
    @Test
    public void newHeroInstantiatesCorrectly(){
        Hero testHero = new Hero("Makmende", "20", "Funny", "Crazy");
        assertEquals(true, testHero instanceof Hero);
    }

    @Test
    public void  newNameInstantiatesCorrectly(){
        Hero testHero = new Hero("Makmende", "20", "Funny", "Crazy");
        assertEquals("Makmende", testHero.getmName());
    }
    @Test
    public void  newAgeInstantiatesCorrectly(){
        Hero testHero = new Hero("Makmende", "20", "Funny", "Crazy");
        assertEquals("20", testHero.getmAge());
    }
    @Test
    public void  newPowerInstantiatesCorrectly(){
        Hero testHero = new Hero("Makmende", "20", "Funny", "Crazy");
        assertEquals("Funny", testHero.getmPower());
    }
    @Test
    public void  newWeaknessInstantiatesCorrectly(){
        Hero testHero = new Hero("Makmende", "20", "Funny", "Crazy");
        assertEquals("Crazy", testHero.getmWeakness());
    }
    @Test
    public void newGetHeroesRegister(){
        Hero heroOne = new Hero("Makmende","20", "Funny","Crazy");
        Hero heroTwo = new Hero("Batman", "560","Super-fly","Smoking");
        assertEquals(true, Hero.heroes().contains(heroOne));
        assertEquals(true, Hero.heroes().contains(heroTwo));
    }
    @Test
    public void newHeroIdInstantiatesCorrectly(){
        Hero.clearRegister();
        Hero testHero = new Hero("Batman", "560", "Super-fly", "Smoking");
        assertEquals(1, testHero.getmHeroId());
    }
    @Test
    public void newClearRegister(){
        Hero.clearRegister();
        assertEquals(Hero.heroes().size(),0);
    }

}