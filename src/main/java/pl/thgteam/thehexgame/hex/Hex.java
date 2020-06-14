package pl.thgteam.thehexgame.hex;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.thgteam.thehexgame.hex.enums.Status;
import pl.thgteam.thehexgame.hex.enums.Type;

@AllArgsConstructor
@Getter
public class Hex {

//    private final Cord cord;                   // ... or as it is a LinkedHashMap, so without coordinate
    private final boolean isEnabled;           // weather the hex field is available for the game (turn on / turn off), for the battlefields with not regular shapes
    private final Type type;         // weather the hex field is available for the player (ie. the field is enabled, but have Mountains on it which can not be accessed by any player)

    private boolean isTaken;                   // TRUE: already taken by the: player, tree, fortification / FALSE: ready to be taken by the player
    private Status status;                     // what is currently on the field: nothing, player, tree, fortification

    @Override
    public String toString() {
        return "enable: " + isEnabled + ", available: " + type + ", taken: " + isTaken + ", status: " + status;
    }
}
