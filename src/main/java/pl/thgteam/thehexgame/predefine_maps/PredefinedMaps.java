package pl.thgteam.thehexgame.predefine_maps;

import pl.thgteam.thehexgame.battlefield.Battlefield;
import pl.thgteam.thehexgame.hex.Location;
import pl.thgteam.thehexgame.hex.type.EStatus;

import java.util.HashMap;
import java.util.Map;

import static pl.thgteam.thehexgame.hex.type.EStatus.*;


public class PredefinedMaps {

    public static Battlefield createRawBattlefield01() {

        Map<Location, EStatus> unavailable = new HashMap<>();

        unavailable.put(new Location(0, 0), OFF);
        unavailable.put(new Location(0, 1), OFF);
        unavailable.put(new Location(1, 0), OFF);
        unavailable.put(new Location(6, 5), OFF);

        unavailable.put(new Location(2, 2), WATER);
        unavailable.put(new Location(2, 3), WATER);
        unavailable.put(new Location(3, 2), WATER);
        unavailable.put(new Location(3, 3), WATER);

        unavailable.put(new Location(2, 1), TREE);
        unavailable.put(new Location(1, 1), TREE);
        unavailable.put(new Location(1, 2), TREE);
        unavailable.put(new Location(1, 3), TREE);
        unavailable.put(new Location(7, 2), TREE);
        unavailable.put(new Location(7, 3), TREE);

        unavailable.put(new Location(0, 5), ROCKS);
        unavailable.put(new Location(1, 5), ROCKS);
        unavailable.put(new Location(2, 5), ROCKS);
        unavailable.put(new Location(3, 5), ROCKS);
        unavailable.put(new Location(6, 0), ROCKS);

        unavailable.put(new Location(0, 7), ROCKS);
        unavailable.put(new Location(1, 7), ROCKS);
        unavailable.put(new Location(2, 7), ROCKS);
        unavailable.put(new Location(3, 7), ROCKS);
        unavailable.put(new Location(4, 7), ROCKS);
        unavailable.put(new Location(5, 7), ROCKS);
        unavailable.put(new Location(6, 7), ROCKS);
        unavailable.put(new Location(7, 7), ROCKS);

        return new Battlefield(8, 8, unavailable);
    }

}
