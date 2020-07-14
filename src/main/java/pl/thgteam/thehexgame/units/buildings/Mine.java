package pl.thgteam.thehexgame.units.buildings;

import pl.thgteam.thehexgame.units.humanunits.BaseUnit;

public class Mine extends BaseUnit {

    public void addGold() {
        getGameStatus().setQuantityOfGold(getGameStatus().getQuantityOfGold() + getSkillPower());
    }

}
