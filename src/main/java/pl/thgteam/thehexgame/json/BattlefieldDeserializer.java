package pl.thgteam.thehexgame.json;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import pl.thgteam.thehexgame.hex.Location;

import java.io.IOException;

public class BattlefieldDeserializer extends KeyDeserializer {

    @Override
    public Object deserializeKey(String key, DeserializationContext context) throws IOException {
        return new Location(key);
    }
}
