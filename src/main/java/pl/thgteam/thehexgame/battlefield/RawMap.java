package pl.thgteam.thehexgame.battlefield;

import lombok.Getter;
import pl.thgteam.thehexgame.hex.Cord;
import pl.thgteam.thehexgame.hex.Hex;
import pl.thgteam.thehexgame.hex.enums.Status;
import pl.thgteam.thehexgame.hex.enums.Type;

import java.util.Formatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static pl.thgteam.thehexgame.util.Util.*;

@Getter
public class RawMap {

    private final long sizeX;
    private final long sizeY;
    private final List<Cord> disabledFields;
    private final Map<Cord, Type> otherThanFree;


    private final Map<Cord, Hex> battlefield;

    public RawMap(long sizeX, long sizeY, List<Cord> disabledFields, Map<Cord, Type> otherThanFree) {
        this.sizeX = exceptionIfValueNegativeOrZero(sizeX);
        this.sizeY = exceptionIfValueNegativeOrZero(sizeY);
        this.disabledFields = disabledFields;
        this.otherThanFree = otherThanFree;
        this.battlefield = generateMap();
    }

    public Map<Cord, Hex> generateMap() {
        Map<Cord, Hex> result;
        result = generateRectangleDraftMap(sizeX, sizeY);
        return result;
    }

    private Map<Cord, Hex> generateRectangleDraftMap(long sizeX, long sizeY) {
        Map<Cord, Hex> result = new LinkedHashMap<>();

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                Cord cord = new Cord(i, j);
                if (isFieldEnabled(cord)) result.put(cord, HEX_DISABLED);
                else result.put(cord, new Hex(true, whatIsTheFieldType(cord), false, Status.EMPTY));

            }
        }
        return result;
    }

    private boolean isFieldEnabled(Cord cord) {
        return disabledFields.contains(cord);
    }

    private Type whatIsTheFieldType(Cord cord) {
        return otherThanFree.getOrDefault(cord, Type.FREE);
    }

    private long exceptionIfValueNegativeOrZero (long value) {
        if (value <= 0) throw new IllegalArgumentException("Can not create battlefield with zero or negative values! Use Positive data");
        return value;
    }


    // for testing purposes only (to be removed in the production version)
    public static String printBattlefield(Map<Cord, Hex> battlefield) {
        Formatter sb = new Formatter();
        sb.format("Here is the battlefield (blue fields are ready to move on:)\n");
        battlefield.forEach((k, v) -> {
            if (!v.isEnabled()) sb.format(RED);
            if (Type.FREE.equals(v.getType())) sb.format(BLUE);
            sb.format(k.toString()).format(" - ");
            sb.format("enable: %-7s ", v.isEnabled());
            sb.format("type: %-7s ", v.getType());
            sb.format("taken: %-7s ", v.isTaken());
            sb.format("taken: %-7s ", v.isTaken());
            sb.format("status: %-7s ", v.getStatus());
            sb.format(RESET).format("\n");
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
