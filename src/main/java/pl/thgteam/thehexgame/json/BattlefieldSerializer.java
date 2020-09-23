package pl.thgteam.thehexgame.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import pl.thgteam.thehexgame.hex.Hex;
import pl.thgteam.thehexgame.hex.Location;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public class BattlefieldSerializer extends JsonSerializer<Map<Location, Hex>> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void serialize(Map<Location, Hex> battlefield, JsonGenerator generator, SerializerProvider provider) throws IOException {
        StringWriter writer = new StringWriter();
        objectMapper.writeValue(writer, battlefield);
        generator.writeFieldName(writer.toString());
    }

}
