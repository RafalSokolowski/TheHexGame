package pl.thgteam.thehexgame.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import pl.thgteam.thehexgame.hex.Hex;
import pl.thgteam.thehexgame.hex.Location;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

@Log4j2
@Getter
@AllArgsConstructor
public class CreateJSON {

//    @JsonSerialize(keyUsing = BattlefieldJsonSerializer.class)
//    Location mapKey;
//
//    @JsonSerialize(keyUsing = BattlefieldJsonSerializer.class)
//    Hex mapValue;

    @JsonSerialize(keyUsing = MapSerializer.class)
    private Map<Location, Hex> battlefield;


//    Approach with JSONObject
//
//    public void toFile(String filePathAndName) {
//        try (FileWriter fileWriter = new FileWriter(filePathAndName)) {
//            fileWriter.write(generate(battlefield).toString());
//            fileWriter.flush();
//        } catch (IOException e) {
//            log.error("Can not write to file: " + e.getMessage());
//        }
//    }
//
//    private JSONObject generate(Map<Location, Hex> battlefield) {
//        return new JSONObject(battlefield);
//    }

    public void mapToJsonFile(String filePathAndName) {
        try (FileWriter fileWriter = new FileWriter(filePathAndName)) {
            fileWriter.write(mapToJsonString());
            fileWriter.flush();
        } catch (IOException e) {
            log.error("Can not write to file: " + e.getMessage());
        }
    }

    private String mapToJsonString() {
        try {
            return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(battlefield);
        } catch (JsonProcessingException e) {
            log.error("JSON String cannot be created: " + e.getMessage());
            return "JSON String creation has failed";
        }

    }

//    public void battlefieldToFile(String filePathAndName) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        File file = new File(filePathAndName);
//        writeToFileWithObjectMapper(file, objectMapper);
//    }
//
//    private void writeToFileWithObjectMapper(File file, ObjectMapper objectMapper) {
//        try {
//            objectMapper.writeValue(file, battlefield);
//        } catch (IOException e) {
//            log.error("File " + file.getName() + " cannot be created: " + e.getMessage());
//        }
//    }

}
