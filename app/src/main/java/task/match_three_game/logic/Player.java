package task.match_three_game.logic;

public class Player {
    /* FIELDS */
    private final String name;
    private final int color;

    /* CONSTRUCTOR */
    public Player(String name, int assignedColor) {
        this.name = name;
        this.color = assignedColor;
    }

    /* GETTERS */
    public String getName() {
        return name;
    }

    public int getColor() {
        return color;
    }

    /* METHOD */
    public void colorCell(Cell cell) {
        cell.colorizeBy(this);
    }
}
