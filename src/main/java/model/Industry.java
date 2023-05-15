package model;

public enum Industry {
    IRON_MINE("iron mine",2,10,GroundTypes.IRON),
    MARKET("market",1,5,GroundTypes.GROUND),
    OX_TETHER("ox tether",1,5,GroundTypes.ROCK),
    PITCH_RIG("pitch rig",1,5,GroundTypes.MEADOW),
    QUARRY("quarry",3,5,GroundTypes.ROCK),
    STOCKPILE("stockpile",0,5,GroundTypes.GROUND),
    WOODCUTTER("woodcutter",1,5,GroundTypes.GROUND);
    private String buildingName;
    private int numberOfWorkers;
    private int hp;
    private GroundTypes groundTypes;
    private Industry(String buildingName, int numberOfWorkers, int hp, GroundTypes groundTypes){
        this.buildingName=buildingName;
        this.numberOfWorkers=numberOfWorkers;
        this.hp=hp;
        this.groundTypes=groundTypes;

    }

    public String getBuildingName() {
        return buildingName;
    }

    public GroundTypes getGroundTypes() {
        return groundTypes;
    }

    public static Industry getGroundTypeByName(String name){
        if(name.equals(IRON_MINE.getBuildingName()))
            return Industry.IRON_MINE;
        else if(name.equals(MARKET.getBuildingName()))
            return MARKET;
        else if(name.equals(OX_TETHER.getBuildingName()))
            return OX_TETHER;
        else if(name.equals(PITCH_RIG.getBuildingName()))
            return PITCH_RIG;
        else if(name.equals(QUARRY.getBuildingName()))
            return QUARRY;
        else if(name.equals(STOCKPILE.getBuildingName()))
            return STOCKPILE;
        else if(name.equals(WOODCUTTER.getBuildingName()))
            return WOODCUTTER;
        return null;
    }
}
