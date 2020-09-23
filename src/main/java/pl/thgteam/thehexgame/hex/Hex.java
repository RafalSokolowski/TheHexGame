package pl.thgteam.thehexgame.hex;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.thgteam.thehexgame.hex.type.EStatus;

@Getter
@AllArgsConstructor
public class Hex {

    private final Location location;        // ... or as it is a LinkedHashMap, so without coordinate
//    private final boolean isEnabled;        // weather the hex field is available for the game (turn on / turn off), for the battlefields with not regular shapes
//    private final Type type;                // weather the hex field is available for the player (ie. the field is enabled, but have Mountains on it which can not be accessed by any player)
//    private boolean isTaken;                // TRUE: already taken by the: player, tree, fortification / FALSE: ready to be taken by the player or fortification
    private EStatus status;                  // what is currently on the field: nothing, player, fortification, water, tree, rocks

    // for JSON deserialization purposes
    public Hex (String string) {
        String[] table = string.split(" - ");
        this.location = new Location(table[0]);
        this.status = EStatus.valueOf(table[1]);
    }

//    @JsonValue
//    public String forJsonSerialization() {
//        return status.toString();
//    }

    @JsonValue
    @Override
    public String toString() {
        return location + " - " + status;
    }
}
