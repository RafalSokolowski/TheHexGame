package pl.thgteam.thehexgame.units.buildings;

import pl.thgteam.thehexgame.units.humanunits.BaseUnit;

public class Sawmill extends BaseUnit {

    public void addWood() {
        getGameStatus().setQuantityOfWood(getGameStatus().getQuantityOfWood() + getSkillPower());
    }
}
