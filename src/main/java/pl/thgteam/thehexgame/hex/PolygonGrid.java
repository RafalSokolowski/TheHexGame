package pl.thgteam.thehexgame.hex;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.function.BiConsumer;

import static pl.thgteam.thehexgame.util.Util.VAL;

@AllArgsConstructor
public class PolygonGrid {

    private final int rowNumber;
    private final int columnNumber;
    private final double sideLength;

    double getCenterX() {
        return 2 * VAL * sideLength * (columnNumber + (rowNumber % 2) * 0.5);
    }

    double getCenterY() {
        return 3 * sideLength / 2 * rowNumber;
    }

    void foreachVertex(BiConsumer<Double, Double> f) {
        double cx = getCenterX();
        double cy = getCenterY();
        f.accept(cx + 0, cy + sideLength);
        f.accept(cx - VAL * sideLength, cy + 0.5 * sideLength);
        f.accept(cx - VAL * sideLength, cy - 0.5 * sideLength);
        f.accept(cx + 0, cy - sideLength);
        f.accept(cx + VAL * sideLength, cy - 0.5 * sideLength);
        f.accept(cx + VAL * sideLength, cy + 0.5 * sideLength);
    }


    public String[][] generate(int width, int height, double sideLength) {
        String[][] grid = new String[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
//                grid[row][col] = new PolygonGrid(row, col, sideLength);
            }
        }
        return grid;
    }


}
