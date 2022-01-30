package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {
    @Test
    public void heroInstantiatesCorrectly(){
        Squad testSquad = new Squad("Computer Ninjas","Stop computer illiteracy", 3);
        assertEquals(true, testSquad instanceof Squad );
    }
    @Test
    public void squadNameInstantiatesCorrectly(){
        Squad testSquad = new Squad("Computer Ninjas", "Stop computer illiteracy",3);
        assertEquals("Computer Ninjas", testSquad.getmSquadName());
    }
    @Test
    public void squadSizeInstantiatesCorrectly(){
        Squad testSquad = new Squad("Computer Ninjas", "Stop computer illiteracy",3);
        assertEquals(3, testSquad.getmSize());
    }
    @Test
    public void squadCauseInstantiatesCorrectly(){
        Squad testSquad = new Squad("Computer Ninjas", "Stop computer illiteracy",3);
        assertEquals("Stop computer illiteracy", testSquad.getmCause());
    }
    @Test
    public void squadIdInstantiatesCorrectly(){
        Squad testSquad = new Squad("Computer Ninjas", "Stop computer illiteracy",3);
        assertEquals(1, testSquad.getmSquadId());
    }
    @Test
    public void squadsReturnsAllInstancesCorrectly(){
        Squad squadOne = new Squad("Computer Ninjas", "Stop computer illiteracy",3);
        Squad squadTwo = new Squad("Net Ninjas", "Find people who don't practice code",3);
        assertEquals(true, Squad.getSquads().contains(squadOne));
        assertEquals(true, Squad.getSquads().contains(squadTwo));
    }
    @Test
    public void findSquadWithSameId(){
        Squad testSquad = new Squad("Computer Ninjas", "Stop computer illiteracy",3);
        assertEquals(Squad.findSquads(testSquad.getmSquadId()), testSquad);
    }
    @Test
    public void getSquadsReturnsEmptyList(){
        Squad testSquad = new Squad("Computer Ninjas", "Stop computer illiteracy",3);
        assertEquals(0, testSquad.getSquadMembers().size());
    }
    @Test
    public void addMembersToSquadCorrectly(){
        Squad testSquad = new Squad("Computer Ninjas", "Stop computer illiteracy",3);
        Hero testHero = new Hero("Batman", 365, "Super-fly","Smoking" );
        testSquad.addMemberToSquad(testHero);
        assertTrue(testSquad.getSquadMembers().contains(testHero));
    }
    @Test
    public void isSquadMemberDuplicate(){
        Squad testSquad = new Squad("Computer Ninjas", "Stop computer illiteracy",3);
        Hero testHero = new Hero("Batman", 365, "Super-fly","Smoking" );
        testSquad.addMemberToSquad(testHero);
        assertTrue(testSquad.ismIsHeroSquadMember(testHero));
    }

    @Test
    public void addMembersIsSuccessful(){
        Squad testSquad = new Squad("SpaceZZZ","Secure space", 2);
        Hero newHero = new Hero("Mf Doom",32,"Space genius","Unpredictable");
        testSquad.addMemberToSquad(newHero);
        assertTrue(String.valueOf(testSquad.getSquadMembers().size()),true);
    }

    @Test
    public void clearSquadsTrue(){
        Squad.clearSquads();
        assertEquals(Squad.getSquads().size(),0);
    }
}