package task.match_three_game.logic;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.RelativeLayout;


public class Cell {
    /* FIELDS */
    private final RelativeLayout button;
    private final Drawable BUTTON_BASE_COLOR;
    private Player colorist;

    /* CONSTRUCTOR */
    public Cell(RelativeLayout button) {
        this.button = button;
        this.BUTTON_BASE_COLOR = button.getBackground();
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
        button.setBackground(colorist.getDrawable());
        this.setColorist(colorist);
    }

    public void setColor(Drawable newColor) {
        button.setBackground(newColor);
    }

    public void resetCell() {
        button.setBackground(BUTTON_BASE_COLOR);
        this.colorist = null;
    }
}
