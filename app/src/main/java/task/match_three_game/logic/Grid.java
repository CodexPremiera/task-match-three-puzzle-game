package task.match_three_game.logic;

import android.content.Context;
import android.graphics.Color;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

import task.match_three_game.R;

public class Grid {
    /* FIELDS */
    private ArrayList<Column> columns;
    private int numberOfColumns;

    /* CONSTRUCTOR */
    public Grid() {
        this.columns = new ArrayList<>();
        this.numberOfColumns = 0;
    }

    /* METHODS */
    public Boolean checkConnect3(Column column, Player player) {
        // color the top of column and get origin
        int originY = column.addColoredCell(player);
        int originX = columns.indexOf(column);

        // throw error if column is full
        if (originY >= column.getSize())
            throw new RuntimeException("Column is full.");

        Cell origin = columns.get(originX).get(originY);

        // init range
        int minX, maxX, minY, maxY;
        minX = maxX = originX;
        minY = maxY = originY;

        // set range
        while (minX > 0 && minX > originX - 2) minX--;
        while (minY > 0 && minY > originY - 2) minY--;
        while (maxX < this.numberOfColumns && maxX < originX + 3) maxX++;
        while (maxY < this.numberOfColumns && maxY < originY + 3) maxY++;

        // check horizontal
        int connectCount = 0;
        for (int col = minX; col < maxX; col++) {
            Cell currentCell = columns.get(col).get(originY);
            connectCount = (currentCell.getColorist() == origin.getColorist()) ? connectCount + 1 : 0;

            if (connectCount == 3) {
                columns.get(0).get(numberOfColumns - 1).setColor(Color.BLACK);
                return true;
            }
        }

        return false;
    }

    public void addColumn(Column column) {
        columns.add(column);
        numberOfColumns++;
    }
}
