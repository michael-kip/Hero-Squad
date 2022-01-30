package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {
    @Test
    public void newHeroInstantiatesCorrectly(){
        Hero testHero = new Hero("Makmende", 20, "Funny", "Crazy");
        assertEquals(true, testHero instanceof Hero);
    }
}