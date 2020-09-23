package pl.thgteam.thehexgame.battlefield;

import pl.thgteam.thehexgame.hex.Hex;
import pl.thgteam.thehexgame.hex.Location;
import pl.thgteam.thehexgame.hex.type.EStatus;

import java.util.Formatter;
import java.util.Map;

import static pl.thgteam.thehexgame.util.Color.*;

public class PrintBattlefield {

    public static String inTerminal(Battlefield battlefield) {
        final int LOCATION_LENGTH = 10;
        final int STATUS_LENGTH = 8;
        final int UNDERLINE = (LOCATION_LENGTH + STATUS_LENGTH + 5) * battlefield.getSizeY();

        Formatter sb = new Formatter();

        sb.format("-".repeat(UNDERLINE)).format("\n");
        battlefield.getBattlefield().forEach((k, v) -> {
            if (v.getStatus().equals(EStatus.OFF)) sb.format(WHITE);
            if (v.getStatus().equals(EStatus.EMPTY)) sb.format(BLACK);
            if (v.getStatus().equals(EStatus.WATER)) sb.format(BLUE);
            if (v.getStatus().equals(EStatus.TREE)) sb.format(GREEN);
            if (v.getStatus().equals(EStatus.ROCKS)) sb.format(RED);

            sb.format("%-" + LOCATION_LENGTH + "s ", v.getLocation());
            sb.format("%-" + STATUS_LENGTH + "s ", v.getStatus());
            sb.format(RESET).format(" | ");

            if (k.getY() == battlefield.getSizeY() - 1) {
                sb.format("\n");
                sb.format("-".repeat(UNDERLINE));
                sb.format("\n");
            }
        });

        return sb.toString();
    }

    public static String inTerminal(Map<Location, Hex> battlefield, int sizeY) {
        final int LOCATION_LENGTH = 10;
        final int STATUS_LENGTH = 8;
        final int UNDERLINE = (LOCATION_LENGTH + STATUS_LENGTH + 5) * sizeY;

        Formatter sb = new Formatter();

        sb.format("-".repeat(UNDERLINE)).format("\n");
        battlefield.forEach((k, v) -> {
            if (v.getStatus().equals(EStatus.OFF)) sb.format(WHITE);
            if (v.getStatus().equals(EStatus.EMPTY)) sb.format(BLACK);
            if (v.getStatus().equals(EStatus.WATER)) sb.format(BLUE);
            if (v.getStatus().equals(EStatus.TREE)) sb.format(GREEN);
            if (v.getStatus().equals(EStatus.ROCKS)) sb.format(RED);

            sb.format("%-" + LOCATION_LENGTH + "s ", v.getLocation());
            sb.format("%-" + STATUS_LENGTH + "s ", v.getStatus());
            sb.format(RESET).format(" | ");

            if (k.getY() == sizeY - 1) {
                sb.format("\n");
                sb.format("-".repeat(UNDERLINE));
                sb.format("\n");
            }
        });

        return sb.toString();
    }


}
