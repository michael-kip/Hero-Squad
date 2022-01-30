package models;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private  String mSquadName;
    private int mSize;
    private  String mCause;
    private  int mSquadId;
    private  static boolean mIsHeroSquadMember = false;
    private boolean mIsSquadFull = false;
    private static List<Squad>squads=new ArrayList<>();
    private List<Hero>squadMembers = new ArrayList<Hero>();

    public Squad(String mSquadName, String mCause, int mSize) {
        this.mSquadName = mSquadName;
        this.mCause = mCause;
        this.mSize = mSize;
        squads.add(this);
        mSquadId = squads.size();
    }

    public String getmSquadName() {
        return mSquadName;
    }

    public int getmSize() {
        return mSize;
    }

    public String getmCause() {
        return mCause;
    }

    public int getmSquadId() {
        return mSquadId;
    }

    public static boolean ismIsHeroSquadMember(Hero newHero) {
        boolean isDuplicate = false;
        for (Squad newSquad: squads){
            for (Hero anotherHero: newSquad.getSquadMembers()){
                if (newHero.getmName().equals(newHero.getmName())){
                    isDuplicate = true;
                }
            }
        }
        return isDuplicate;
    }

    public boolean ismIsSquadFull() {
        return mIsSquadFull;
    }

    public void addMembers(Hero newHero){
        if(squadMembers.size()>=3){
            mIsSquadFull = true;
        }else {
            squadMembers.add(newHero);
        }
    }

    public static List<Squad> getSquads() {
        return squads;
    }

    public List<Hero> getSquadMembers() {
        return squadMembers;
    }

    public static Squad findSquads(int searchId){
        return squads.get(searchId - 1);
    }

    public void addMemberToSquad(Hero newHero){
        squadMembers.add(newHero);
    }

    public static void clearSquads(){
        squads.clear();
    }
}
