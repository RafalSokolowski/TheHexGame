package pl.thgteam.thehexgame.units.buildings;

import pl.thgteam.thehexgame.units.humanunits.BaseUnit;

public class Farm extends BaseUnit {

    public void addFood(){
        getGameStatus().setQuantityOfFood(getGameStatus().getQuantityOfFood() + getSkillPower());
    }

}
