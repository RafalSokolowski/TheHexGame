package pl.thgteam.thehexgame.util;

import pl.thgteam.thehexgame.hex.Hex;
import pl.thgteam.thehexgame.hex.enums.Status;
import pl.thgteam.thehexgame.hex.enums.Type;

public class Util {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";
    public static final String GREEN = "\u001B[32m";
    public static final String WHITE = "\u001B[37m";
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m";
    public static final String WHITE_BOLD = "\033[1;37m";
    public static final String WHITE_BRIGHT = "\033[0;97m";

    public static final Hex HEX_DISABLED = new Hex(false, Type.OFF,false, Status.OFF);

}
