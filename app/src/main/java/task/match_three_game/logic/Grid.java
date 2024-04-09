package task.match_three_game.logic;

import java.util.ArrayList;

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
    public void checkConnect3(int column, Player player) {
        Column currentColumn = columns.get(column);

        currentColumn.addColoredCell(player);
    }

    public void addColumn(Column column) {
        columns.add(column);
        numberOfColumns++;
    }
}
