package task.match_three_game.logic;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.RelativeLayout;

import java.util.Objects;


public class Cell {
    /* FIELDS */
    private final RelativeLayout button;
    private final int BUTTON_BASE_COLOR;
    private Player colorist;

    /* CONSTRUCTOR */
    public Cell(RelativeLayout button) {
        this.button = button;
        this.BUTTON_BASE_COLOR = android.R.color.white;
        this.colorist = null;
    }

    /* GETTER AND SETTER */
    public void setColorist(Player colorist) {
        this.colorist = colorist;
    }

    public Player getColorist() {
        return colorist;
    }

    /* METHODS */
    public void colorizeBy(Player colorist) {
        button.setBackgroundColor(colorist.getColor());
        this.setColorist(colorist);
    }

    public void resetCell() {
        button.setBackgroundColor(BUTTON_BASE_COLOR);
        this.colorist = null;
    }
}
