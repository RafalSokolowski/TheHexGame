package pl.thgteam.thehexgame.x_other;

import lombok.Getter;
import lombok.AllArgsConstructor;
import pl.thgteam.thehexgame.hex.Location;

@Getter
@AllArgsConstructor
public class Polygon {

    private final Location a;
    private final Location b;
    private final Location c;
    private final Location d;
    private final Location e;
    private final Location f;

    public String createString () {
        StringBuilder sb = new StringBuilder();
        sb.append(a.createString()).append(" ");
        sb.append(b.createString()).append(" ");
        sb.append(c.createString()).append(" ");
        sb.append(d.createString()).append(" ");
        sb.append(e.createString()).append(" ");
        sb.append(f.createString()).append(" ");
        return sb.toString();
    }

}
