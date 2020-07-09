package pl.thgteam.thehexgame.battlefield;

import lombok.Getter;
import org.springframework.stereotype.Service;
import pl.thgteam.thehexgame.hex.Cord;
import pl.thgteam.thehexgame.hex.enums.Type;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Getter
@Service
public class FirstBattlefield {

    private RawMap rawMap;

    public FirstBattlefield() {
        this.rawMap = start();
    }

    public RawMap start () {

        Map<Cord, Type> otherThanFree = new HashMap<>();
        otherThanFree.put(new Cord(0,0),Type.ROCKS);
        otherThanFree.put(new Cord(0,1),Type.ROCKS);
        otherThanFree.put(new Cord(1,0),Type.ROCKS);
        otherThanFree.put(new Cord(0,4),Type.WATER);
        otherThanFree.put(new Cord(4,0),Type.WATER);
        otherThanFree.put(new Cord(4,4),Type.WATER);

        return new RawMap(
                5,
                5,
                Arrays.asList(new Cord(1, 1), new Cord(1, 2)),
                otherThanFree
        );
    }
}
