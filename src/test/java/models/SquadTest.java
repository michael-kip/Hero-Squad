package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {
    @Test
    public void heroInstantiatesCorrectly(){
        Squad testSquad = new Squad("Computer Ninjas",3, "Stop computer illiteracy");
        assertEquals(true, testSquad instanceof Squad );
    }
    @Test
    public void squadNameInstantiatesCorrectly(){
        Squad testSquad = new Squad("Computer Ninjas", 3,"Stop computer illiteracy");
        assertEquals("Computer Ninjas", testSquad.getName());
    }
    @Test
    public void squadSizeInstantiatesCorrectly(){
        Squad testSquad = new Squad("Computer Ninjas", 3,"Stop computer illiteracy");
        assertEquals(3, testSquad.getSize());
    }
    @Test
    public void squadCauseInstantiatesCorrectly(){
        Squad testSquad = new Squad("Computer Ninjas", 3,"Stop computer illiteracy");
        assertEquals("Stop computer illiteracy", testSquad.getCause());
    }
    @Test
    public void squadIdInstantiatesCorrectly(){
        Squad testSquad = new Squad("Computer Ninjas", 3,"Stop computer illiteracy");
        assertEquals(1, testSquad.getId());
    }
    @Test
    public void squadsReturnsAllInstancesCorrectly(){
        Squad squadOne = new Squad("Computer Ninjas", 3,"Stop computer illiteracy");
        Squad squadTwo = new Squad("Net Ninjas", 3,"Find people who don't practice code");
        assertEquals(true, Squad.getSquads().contains(squadOne));
        assertEquals(true, Squad.getSquads().contains(squadTwo));
    }
    @Test
    public void findSquadWithSameId(){
        Squad testSquad = new Squad("Computer Ninjas", 3,"Stop computer illiteracy");
        assertEquals(Squad.find(testSquad.getId()), testSquad);
    }
//    @Test
//    public void getSquadsReturnsEmptyList(){
//        Squad testSquad = new Squad("Computer Ninjas", 3,"Stop computer illiteracy");
//        assertEquals(0, testSquad.getSquadMembers().size());
//    }
    @Test
    public void addMembersToSquadCorrectly(){
        Squad testSquad = new Squad("Computer Ninjas", 3,"Stop computer illiteracy");
        Hero testHero = new Hero("Batman", 365, "Super-fly","Smoking", 2 );
        testSquad.addHero(testHero);
        assertTrue(testSquad.getHeroes().contains(testHero));
    }
//    @Test
//    public void isSquadMemberDuplicate(){
//        Squad testSquad = new Squad("Computer Ninjas", 3,"Stop computer illiteracy");
//        Hero testHero = new Hero("Batman", 365, "Super-fly","Smoking", 2 );
//        testSquad.addHero(testHero);
//        assertTrue(testSquad.(testHero));
//    }

//    @Test
//    public void addMembersIsSuccessful(){
//        Squad testSquad = new Squad("SpaceZZZ",2, "Secure space");
//        Hero newHero = new Hero("Mf Doom",32,"Space genius","Unpredictable", 1);
//        testSquad.addHero(newHero);
//        assertTrue(String.valueOf(testSquad.getSquadMembers().size()),true);
//    }

    @Test
    public void clearSquadsTrue(){
        Squad.clearSquads();
        assertEquals(Squad.getSquads().size(),0);
    }
}