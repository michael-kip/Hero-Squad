package models;

public class Squad {
    private  String mSquadName;
    private  String mCause;
    private  int mSquadId;
    private  static boolean mIsHeroSquadMember = false;
    private boolean mIsSquadFull = false;

    public Squad(String mSquadName, String mCause, int mSquadId, boolean mIsSquadFull) {
        this.mSquadName = mSquadName;
        this.mCause = mCause;
        this.mSquadId = mSquadId;
        this.mIsSquadFull = mIsSquadFull;
    }
}
