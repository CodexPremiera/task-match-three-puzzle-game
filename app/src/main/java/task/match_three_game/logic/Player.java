package task.match_three_game.logic;

import android.graphics.drawable.Drawable;

public class Player {
    /* FIELDS */
    private final String name;
    private final Drawable drawable;
    private final int color;

    /* CONSTRUCTOR */
    public Player(String name, Drawable assignedDrawable, int color) {
        this.name = name;
        this.drawable = assignedDrawable;
        this.color = color;
    }

    /* GETTERS */
    public String getName() {
        return name;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public int getColor() {
        return color;
    }

    /* METHOD */
    public void colorCell(Cell cell) {
        cell.colorizeBy(this);
    }
}
