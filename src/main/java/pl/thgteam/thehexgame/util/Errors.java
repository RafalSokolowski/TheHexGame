package pl.thgteam.thehexgame.util;

public enum Errors {

    TOO_BIG ("This version of the game supports max grid of 2 147 395 600 hex fields... please use smaller data"),
    BELOW_ZERO ("Can not create battlefield with zero or negative values... please use positive data"),

    ;

    private String message;

    private Errors (String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }

}
