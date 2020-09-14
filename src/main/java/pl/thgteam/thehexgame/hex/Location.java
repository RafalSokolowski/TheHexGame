package pl.thgteam.thehexgame.hex;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Location {

    private final long x;   // horizontally on the map
    private final long y;   // vertically on the map

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public String createString () {
        return x + "," + y;
    }
}


