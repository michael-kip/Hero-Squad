//package models;
//
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class HeroTest {
//    @Test
//    public void newHeroInstantiatesCorrectly(){
//        Hero testHero = new Hero("Makmende", 20, "Funny", "Crazy", 1);
//        assertEquals(true, testHero instanceof Hero);
//    }
//
//    @Test
//    public void  newNameInstantiatesCorrectly(){
//        Hero testHero = new Hero("Makmende", 20, "Funny", "Crazy", 1);
//        assertEquals("Makmende", testHero.getName());
//    }
//    @Test
//    public void  newAgeInstantiatesCorrectly(){
//        Hero testHero = new Hero("Makmende", 20, "Funny", "Crazy", 1);
//        assertEquals("20", testHero.getAge());
//    }
//    @Test
//    public void  newPowerInstantiatesCorrectly(){
//        Hero testHero = new Hero("Makmende", 20, "Funny", "Crazy", 2);
//        assertEquals("Funny", testHero.getPower());
//    }
//    @Test
//    public void  newWeaknessInstantiatesCorrectly(){
//        Hero testHero = new Hero("Makmende", 20, "Funny", "Crazy", 1);
//        assertEquals("Crazy", testHero.getWeakness());
//    }
//    @Test
//    public void newGetHeroesRegister(){
//        Hero heroOne = new Hero("Makmende",20, "Funny","Crazy", 1);
//        Hero heroTwo = new Hero("Batman", 560,"Super-fly","Smoking", 2);
//        assertEquals(true, Hero.getAll().contains(heroOne));
//        assertEquals(true, Hero.getAll().contains(heroTwo));
//    }
//    @Test
//    public void newHeroIdInstantiatesCorrectly(){
//        Hero.clearAllHeroes();
//        Hero testHero = new Hero("Batman", 560, "Super-fly", "Smoking", 2);
//        assertEquals(1, testHero.getId());
//    }
//    @Test
//    public void newClearRegister(){
//        Hero.clearAllHeroes();
//        assertEquals(Hero.getAll().size(),0);
//    }
//
//}