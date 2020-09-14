package pl.thgteam.thehexgame.battlefield;

import pl.thgteam.thehexgame.hex.Hex;
import pl.thgteam.thehexgame.hex.Location;

import java.util.Map;

public interface IBattlefield {

    public Map<Location, Hex> getBattlefield();

}
