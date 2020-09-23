package pl.thgteam.thehexgame.hex.type;

public enum EStatus {

    OFF("This field is disabled"),
    WATER("There is water on the hex field"),
    TREE("There is tree on the hex field"),
    ROCKS("There are rocks on the hex field"),

    EMPTY("Empty and available for take over by the player or fortification"),

    PLAYER("Taken by the player"),
    TOWER("there is the fortification on the field"),

    ;

    private String desc;

    EStatus(String desc) {
        this.desc = desc;
    }

    public String get() {
        return desc;
    }
}
