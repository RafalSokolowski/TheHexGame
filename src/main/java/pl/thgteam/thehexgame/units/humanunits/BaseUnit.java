package pl.thgteam.thehexgame.units.humanunits;

import lombok.*;
import pl.thgteam.thehexgame.gamestats.GameStatus;
import pl.thgteam.thehexgame.hex.Cord;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BaseUnit {

    private GameStatus gameStatus;
    private long id;
    private int skillPower;
    private String name;
    private int health;
    private boolean isDead;
    private Cord cord;

    public void killUnit() {
        if (health <= 0) {
            isDead = true;
        }
    }
}
