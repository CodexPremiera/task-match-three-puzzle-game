package task.match_three_game.logic;

import android.widget.Toast;
import android.content.Context;

import java.util.ArrayList;

public class Column {
    /* FIELDS */
    private final ArrayList<Cell> cells;
    private int numberOfCells;
    private int uncoloredIndex;

    /* CONSTRUCTOR */
    public Column() {
        this.cells = new ArrayList<>();
        this.uncoloredIndex = -1;
        this.numberOfCells = 0;
    }

    /* METHODS */
    public void addColoredCell(Player player) {
        // skip if all cells are colored
        if(uncoloredIndex < 0)
            return;

        // color the cell
        Cell lastUncoloredCell = cells.get(uncoloredIndex);
        player.colorCell(lastUncoloredCell);
        uncoloredIndex--;
    }

    public void reset() {
        cells.forEach(Cell::resetCell);
    }

    public void addCell(Cell cell) {
        cells.add(cell);
        numberOfCells++;
        uncoloredIndex++;
    }
}
