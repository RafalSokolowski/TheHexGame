package pl.thgteam.thehexgame.hex.enums;

public enum Status {

    OFF("This field is disabled"),
    EMPTY("Empty and available for take over by the player"),
    PLAYER("Taken by the player"),
    TREE("There is tree on the hex field"),
    TOWER("there is the fortification on the field")
    ;

    private String desc;

    Status(String desc) {
        this.desc = desc;
    }

    public String get() {
        return desc;
    }
}
