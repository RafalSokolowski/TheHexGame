package pl.thgteam.thehexgame.json;

import lombok.Getter;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import pl.thgteam.thehexgame.hex.Hex;
import pl.thgteam.thehexgame.hex.Location;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Log4j2
@Getter
public class GenerateJson {

    private JSONObject jsonBattlefield;

    public GenerateJson(Map<Location, Hex> battlefield) {
        this.jsonBattlefield = new JSONObject(battlefield);
    }

    public void toFile(String filePath, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(filePath + fileName);
            fileWriter.write(jsonBattlefield.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            log.error("Can not write to file: " + e.getMessage());
        }
    }

}
