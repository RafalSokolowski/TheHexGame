package pl.thgteam.thehexgame;

import pl.thgteam.thehexgame.battlefield.Battlefield;
import pl.thgteam.thehexgame.battlefield.PrintBattlefield;
import pl.thgteam.thehexgame.hex.Hex;
import pl.thgteam.thehexgame.hex.Location;
import pl.thgteam.thehexgame.json.CreateJSON;
import pl.thgteam.thehexgame.json.ParseJSON;
import pl.thgteam.thehexgame.predefine_maps.PredefinedMaps;

import java.util.Map;

import static pl.thgteam.thehexgame.util.Constans.FILE_PATH_NAME;

public class ManiTest {
    public static void main(String[] args) {

        // Create battlefield with predefined content of ROCKS, TREES, WATER (some fields could be OFF)
        Battlefield battlefield = PredefinedMaps.createRawBattlefield01();
        System.out.println(PrintBattlefield.inTerminal(battlefield));


        // write JSON to file - file is saved to ...\resources\output\BereNika_SolfugaSoft.txt
        new CreateJSON(battlefield.getBattlefield()).mapToJsonFile(FILE_PATH_NAME);


        // read JSON from file
        Map<Location, Hex> readBattlefield = new ParseJSON(FILE_PATH_NAME).fromFile();

        System.out.println("\nWhat was read in raw data:");
        System.out.println(readBattlefield);

        System.out.println("\nWhat was read in graphic version dedicated for terminal:");
        System.out.println(PrintBattlefield.inTerminal(readBattlefield,8));

    }
}
