package pl.thgteam.thehexgame.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import pl.thgteam.thehexgame.hex.Hex;
import pl.thgteam.thehexgame.hex.Location;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

@Log4j2
public class ParseJSON {

    private String filePathAndName;

//    @JsonProperty("map")
//    @JsonDeserialize(keyUsing = BattlefieldSerializer.class)
//    private Map<Location, Hex> battlefield;

    public ParseJSON(String filePathAndName) {
        if (!new File(filePathAndName).exists()) throw new IllegalArgumentException("File not exists !");
        this.filePathAndName = filePathAndName;
    }

    public Map<Location, Hex> fromFile() {
        File file = new File(filePathAndName);
        ObjectMapper objectMapper = new ObjectMapper();
        return readJsonFromFile(file, objectMapper);
    }

    private Map<Location, Hex> readJsonFromFile(File file, ObjectMapper objectMapper) {
        try {
            return objectMapper.readValue(file, new TypeReference <Map<Location, Hex>>() {});
        } catch (IOException e) {
            log.error("File " + filePathAndName + " cannot be read: " + e.getMessage());
        }
        return Collections.emptyMap();
    }


}
