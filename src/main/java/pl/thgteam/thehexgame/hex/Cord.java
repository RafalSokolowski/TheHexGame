package pl.thgteam.thehexgame.hex;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Cord {

    private final long x;   // horizontally on the map
    private final long y;   // vertically on the map

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}


