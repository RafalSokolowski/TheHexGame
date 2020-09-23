package pl.thgteam.thehexgame.hex;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.sound.sampled.FloatControl;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Location implements Comparable<Location> {

    private final int x;   // horizontally on the map
    private final int y;   // vertically on the map

    // for JSON deserialization purposes
    public Location(String string) {                               // "(x, y)" is provided
        string = string.replaceAll("[() ]",""); // "x,y" is produced
        String[] table = string.split(",");                 // {x, y} is produced
        this.x = Integer.parseInt(table[0]);
        this.y = Integer.parseInt(table[1]);
    }

    @Override
    public int compareTo(Location location) {
        if (x == location.getX()) return y - location.getY();
        return x - location.getX();
    }

    @Override
    @JsonValue
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

//    public String createString() {
//        return x + "," + y;
//    }
}


