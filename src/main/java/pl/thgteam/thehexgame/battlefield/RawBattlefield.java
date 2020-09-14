package pl.thgteam.thehexgame.battlefield;

import lombok.Getter;
import pl.thgteam.thehexgame.hex.Hex;
import pl.thgteam.thehexgame.hex.Location;
import pl.thgteam.thehexgame.hex.type.Status;

import java.util.Formatter;
import java.util.LinkedHashMap;
import java.util.Map;

import static pl.thgteam.thehexgame.util.Color.*;
import static pl.thgteam.thehexgame.util.Errors.BELOW_ZERO;
import static pl.thgteam.thehexgame.util.Errors.TOO_BIG;

@Getter
public class RawBattlefield implements IBattlefield {

    private final int sizeX;
    private final int sizeY;
    private final Map<Location, Status> unavailable;

    private final Map<Location, Hex> battlefield;

    public RawBattlefield(int sizeX, int sizeY, Map<Location, Status> unavailable) {
        exceptionIfGridTooBig(sizeX, sizeY);
        this.sizeX = exceptionIfValueBelowZero(sizeX);
        this.sizeY = exceptionIfValueBelowZero(sizeY);

        this.unavailable = unavailable;
        this.battlefield = generateBattlefield();
    }

    private Map<Location, Hex> generateBattlefield() {
        Map<Location, Hex> result = new LinkedHashMap<>(sizeX * sizeY);

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                Location location = new Location(i, j);
                if (isFieldUnavailable(location)) result.put(location, new Hex(location, unavailable.get(location)));
                else result.put(location, new Hex(location, Status.EMPTY));
            }
        }

        return result;
    }

    private boolean isFieldUnavailable(Location location) {
        return unavailable.containsKey(location);
    }

    private int exceptionIfValueBelowZero(int value) {
        if (value <= 0)
            throw new IllegalArgumentException(BELOW_ZERO.get());
        return value;
    }

    private void exceptionIfGridTooBig(int x, int y) {
        if (x * y < 0) throw new IllegalArgumentException(TOO_BIG.get());
    }

    // for testing purposes only (to be removed in the production version)
    public String printBattlefield() {
        final int LOCATION_LENGTH = 10;
        final int STATUS_LENGTH = 8;
        final int UNDERLINE = (LOCATION_LENGTH + STATUS_LENGTH + 5) * sizeY;

        Formatter sb = new Formatter();
        sb.format("Here is your battlefield (white are ready to move on :)\n");

        sb.format("-".repeat(UNDERLINE)).format("\n");
        battlefield.forEach((k, v) -> {
            if (v.getStatus().equals(Status.OFF)) sb.format(WHITE);
            if (v.getStatus().equals(Status.EMPTY)) sb.format(BLACK);
            if (v.getStatus().equals(Status.WATER)) sb.format(BLUE);
            if (v.getStatus().equals(Status.TREE)) sb.format(GREEN);
            if (v.getStatus().equals(Status.ROCKS)) sb.format(RED);

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

//    public static String printBattlefield(Map<Cord, Hex> battlefield) {
//        StringBuilder sb = new StringBuilder();
//        battlefield.forEach((k, v) -> {
//            if (!v.isEnabled()) sb.append(RED);
//            sb.append(k.toString(),0,10).append(" - ");
//            sb.append("enable: ").append(v.isEnabled()).append(", ").append("\t");
//            sb.append("type: ").append(v.getType()).append(", ").append("\t");
//            sb.append("taken: ").append(v.isTaken()).append(", ").append("\t");
//            sb.append("taken: ").append(v.isTaken()).append(", ").append("\t");
//            sb.append("status: ").append(v.getStatus()).append(", ").append("\t");
//            sb.append(RESET).append("\n");
//        });
//        return sb.toString();
//    }

}
