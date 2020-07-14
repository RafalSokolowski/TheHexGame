package pl.thgteam.thehexgame.units.humanunits;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DudeWithSpear extends BaseUnit {

    private int attack;

    public int stabb(int attack) {
        return attack;
    }


}
