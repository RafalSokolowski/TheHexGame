package pl.thgteam.thehexgame.battlefield;

import org.springframework.stereotype.Service;
import pl.thgteam.thehexgame.hex.Cord;
import pl.thgteam.thehexgame.hex.enums.Type;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class TestBattlefield {

    public void start () {

        Map<Cord, Type> otherThanFree = new HashMap<>();
        otherThanFree.put(new Cord(0,0),Type.ROCKS);
        otherThanFree.put(new Cord(0,1),Type.ROCKS);
        otherThanFree.put(new Cord(1,0),Type.ROCKS);
        otherThanFree.put(new Cord(0,4),Type.WATER);
        otherThanFree.put(new Cord(4,0),Type.WATER);
        otherThanFree.put(new Cord(4,4),Type.WATER);

        RawMap testMap = new RawMap(
                5,
                5,
                Arrays.asList(new Cord(1, 1), new Cord(1, 2)),
                otherThanFree
        );

        System.out.println(
                RawMap.printBattlefield(testMap.getBattlefield())
        );
    }
}
