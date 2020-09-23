package pl.thgteam.thehexgame.battlefield;

import lombok.Getter;
import pl.thgteam.thehexgame.hex.Hex;
import pl.thgteam.thehexgame.hex.Location;
import pl.thgteam.thehexgame.hex.type.EStatus;

import java.util.Formatter;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

import static pl.thgteam.thehexgame.util.Color.*;
import static pl.thgteam.thehexgame.util.Errors.BELOW_ZERO;
import static pl.thgteam.thehexgame.util.Errors.TOO_BIG;


public class Battlefield implements IBattlefield {

    private final @Getter int sizeX;
    private final @Getter int sizeY;
    private final Map<Location, EStatus> unavailable;


    private final @Getter Map<Location, Hex> battlefield;

    public Battlefield(int sizeX, int sizeY, Map<Location, EStatus> unavailable) {
        exceptionIfGridTooBig(sizeX, sizeY);
        this.sizeX = exceptionIfValueBelowZero(sizeX);
        this.sizeY = exceptionIfValueBelowZero(sizeY);

        this.unavailable = unavailable;
        this.battlefield = generateBattlefield();
    }

    private Map<Location, Hex> generateBattlefield() {
//        Map<Location, Hex> result = new ConcurrentHashMap<>(sizeX * sizeY);
        Map<Location, Hex> result = new ConcurrentSkipListMap<>();

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                Location location = new Location(i, j);
                if (isFieldUnavailable(location)) result.put(location, new Hex(location, unavailable.get(location)));
                else result.put(location, new Hex(location, EStatus.EMPTY));
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


//    public String printBattlefield() {  // for testing purposes only (to be removed in the production version)
//        final int LOCATION_LENGTH = 10;
//        final int STATUS_LENGTH = 8;
//        final int UNDERLINE = (LOCATION_LENGTH + STATUS_LENGTH + 5) * sizeY;
//
//        Formatter sb = new Formatter();
//
//        sb.format("-".repeat(UNDERLINE)).format("\n");
//        battlefield.forEach((k, v) -> {
//            if (v.getStatus().equals(EStatus.OFF)) sb.format(WHITE);
//            if (v.getStatus().equals(EStatus.EMPTY)) sb.format(BLACK);
//            if (v.getStatus().equals(EStatus.WATER)) sb.format(BLUE);
//            if (v.getStatus().equals(EStatus.TREE)) sb.format(GREEN);
//            if (v.getStatus().equals(EStatus.ROCKS)) sb.format(RED);
//
//            sb.format("%-" + LOCATION_LENGTH + "s ", v.getLocation());
//            sb.format("%-" + STATUS_LENGTH + "s ", v.getStatus());
//            sb.format(RESET).format(" | ");
//
//            if (k.getY() == sizeY - 1) {
//                sb.format("\n");
//                sb.format("-".repeat(UNDERLINE));
//                sb.format("\n");
//            }
//        });
//
//
//        return sb.toString();
//    }

}
