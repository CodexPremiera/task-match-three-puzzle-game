package task.match_three_game.logic;

import android.graphics.drawable.Drawable;

public class Player {
    /* FIELDS */
    private final String name;
    private final Drawable drawable;

    /* CONSTRUCTOR */
    public Player(String name, Drawable assignedDrawable) {
        this.name = name;
        this.drawable = assignedDrawable;
    }

    /* GETTERS */
    public String getName() {
        return name;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    /* METHOD */
    public void colorCell(Cell cell) {
        cell.colorizeBy(this);
    }
}
