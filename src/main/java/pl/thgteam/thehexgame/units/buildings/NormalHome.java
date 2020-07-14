package pl.thgteam.thehexgame.units.buildings;

import lombok.*;
import pl.thgteam.thehexgame.gamestats.GameStatus;
import pl.thgteam.thehexgame.units.humanunits.BaseUnit;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NormalHome extends BaseUnit {

  public void addUnitsMaxQuantity(){
   getGameStatus().setMaxUnitQuantity(getGameStatus().getMaxUnitQuantity()+getSkillPower());
  }


}
