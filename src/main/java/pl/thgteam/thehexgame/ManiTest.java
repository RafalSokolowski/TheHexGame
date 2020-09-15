package pl.thgteam.thehexgame;

import lombok.extern.java.Log;
import org.json.JSONObject;
import pl.thgteam.thehexgame.battlefield.RawBattlefield;
import pl.thgteam.thehexgame.hex.Location;
import pl.thgteam.thehexgame.hex.type.Status;
import pl.thgteam.thehexgame.json.GenerateJson;

import java.util.HashMap;
import java.util.Map;

@Log
public class ManiTest {
    public static void main(String[] args) {

        Map<Location,Status> unavailable = new HashMap<>();

        unavailable.put(new Location(0, 0), Status.OFF);
        unavailable.put(new Location(2, 2), Status.WATER);
        unavailable.put(new Location(2, 3), Status.WATER);
        unavailable.put(new Location(3, 2), Status.WATER);
        unavailable.put(new Location(3, 3), Status.WATER);
        unavailable.put(new Location(6, 5), Status.OFF);

        unavailable.put(new Location(2, 1), Status.TREE);
        unavailable.put(new Location(1, 1), Status.TREE);
        unavailable.put(new Location(1, 2), Status.TREE);
        unavailable.put(new Location(1, 3), Status.TREE);

        unavailable.put(new Location(0, 5), Status.ROCKS);
        unavailable.put(new Location(1, 5), Status.ROCKS);
        unavailable.put(new Location(2, 5), Status.ROCKS);
        unavailable.put(new Location(3, 5), Status.ROCKS);
        unavailable.put(new Location(6, 0), Status.ROCKS);


        RawBattlefield rawRectangleMap = new RawBattlefield(7, 6, unavailable);
        System.out.println(rawRectangleMap.printBattlefield());

        GenerateJson generateJson = new GenerateJson(rawRectangleMap.getBattlefield());
        JSONObject toBeSentToSolfugaSoft = generateJson.getJsonBattlefield();

        System.out.println("The JSON version: ");
        System.out.println(toBeSentToSolfugaSoft);

        generateJson.toFile(".\\src\\main\\resources\\output\\", "SolfugaSoft.txt"); // only for work in progress solutions (not recommended)

    }
}
