package pl.thgteam.thehexgame.hex;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Polygon {

    private final Cord a;
    private final Cord b;
    private final Cord c;
    private final Cord d;
    private final Cord e;
    private final Cord f;

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
