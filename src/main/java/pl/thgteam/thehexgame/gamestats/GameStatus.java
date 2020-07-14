package pl.thgteam.thehexgame.gamestats;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GameStatus {
    int maxUnitQuantity;
    int numberOfUnits;
    int maxBuildingQuantity;
    int numberOfBuildings;
    int quantityOfWood;
    int quantityOfGold;
    int quantityOfFood;

    public String winLoseGame() {
        if (numberOfBuildings <= 0 || numberOfUnits <= 0) {
            return "Looser";
        } else return "Grande Dictatore, usurper of the Universe";
    }
}
