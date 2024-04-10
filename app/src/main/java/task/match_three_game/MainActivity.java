package task.match_three_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import task.match_three_game.logic.Cell;
import task.match_three_game.logic.Column;
import task.match_three_game.logic.Grid;
import task.match_three_game.logic.Player;

public class MainActivity extends AppCompatActivity {
    private Grid grid;
    private ArrayList<RelativeLayout> topCells;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    private TextView statusTextBar;

    /* INITIALIZERS */
    private void initializePlayers() {
        int player1Color = ContextCompat.getColor(this, R.color.button_blue);
        int player2Color = ContextCompat.getColor(this, R.color.button_orange);

        Drawable player1Button = ContextCompat.getDrawable(this, R.drawable.player1_button);
        Drawable player2Button = ContextCompat.getDrawable(this, R.drawable.player2_button);

        player1 = new Player("Player 1", player1Button, player1Color);
        player2 = new Player("Player 2", player2Button, player2Color);
        currentPlayer = player1;
    }

    private void initializeTopCell(RelativeLayout cellButton, Column column) {
        cellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check the connect at current cell, catch error if column is full
                try {
                    boolean hasConnected = grid.checkConnect3(column, currentPlayer);

                    // check if current player has won
                    if (hasConnected) {
                        // make top cells not clickable and announce win
                        topCells.forEach(cell -> cell.setEnabled(false));
                        announceWin(currentPlayer);
                        return;
                    }

                    // change turns
                    currentPlayer = (currentPlayer == player1) ? player2 : player1;
                    announceTurn(currentPlayer);
                } catch (RuntimeException columnIsFullException) {
                    columnIsFullException.printStackTrace();
                }
            }
        });
    }


    private void initializeGrid() {
        this.grid = new Grid();
        this.topCells = new ArrayList<>();

        // Column A
        Column columnA = new Column();
        RelativeLayout topOfA = findViewById(R.id.cellA1);
        initializeTopCell(topOfA, columnA);

        columnA.addCell(new Cell(findViewById(R.id.cellA5)));
        columnA.addCell(new Cell(findViewById(R.id.cellA4)));
        columnA.addCell(new Cell(findViewById(R.id.cellA3)));
        columnA.addCell(new Cell(findViewById(R.id.cellA2)));
        columnA.addCell(new Cell(topOfA));
        topCells.add(topOfA);
        grid.addColumn(columnA);

        // Column B
        Column columnB = new Column();
        RelativeLayout topOfB = findViewById(R.id.cellB1);
        initializeTopCell(topOfB, columnB);

        columnB.addCell(new Cell(findViewById(R.id.cellB5)));
        columnB.addCell(new Cell(findViewById(R.id.cellB4)));
        columnB.addCell(new Cell(findViewById(R.id.cellB3)));
        columnB.addCell(new Cell(findViewById(R.id.cellB2)));
        columnB.addCell(new Cell(topOfB));
        topCells.add(topOfB);
        grid.addColumn(columnB);

        // Column C
        Column columnC = new Column();
        RelativeLayout topOfC = findViewById(R.id.cellC1);
        initializeTopCell(topOfC, columnC);

        columnC.addCell(new Cell(findViewById(R.id.cellC5)));
        columnC.addCell(new Cell(findViewById(R.id.cellC4)));
        columnC.addCell(new Cell(findViewById(R.id.cellC3)));
        columnC.addCell(new Cell(findViewById(R.id.cellC2)));
        columnC.addCell(new Cell(topOfC));
        topCells.add(topOfC);
        grid.addColumn(columnC);

        // Column D
        Column columnD = new Column();
        RelativeLayout topOfD = findViewById(R.id.cellD1);
        initializeTopCell(topOfD, columnD);

        columnD.addCell(new Cell(findViewById(R.id.cellD5)));
        columnD.addCell(new Cell(findViewById(R.id.cellD4)));
        columnD.addCell(new Cell(findViewById(R.id.cellD3)));
        columnD.addCell(new Cell(findViewById(R.id.cellD2)));
        columnD.addCell(new Cell(topOfD));
        topCells.add(topOfD);
        grid.addColumn(columnD);

        // Column E
        Column columnE = new Column();
        RelativeLayout topOfE = findViewById(R.id.cellE1);
        initializeTopCell(topOfE, columnE);

        columnE.addCell(new Cell(findViewById(R.id.cellE5)));
        columnE.addCell(new Cell(findViewById(R.id.cellE4)));
        columnE.addCell(new Cell(findViewById(R.id.cellE3)));
        columnE.addCell(new Cell(findViewById(R.id.cellE2)));
        columnE.addCell(new Cell(topOfE));
        topCells.add(topOfE);
        grid.addColumn(columnE);
    }


    /* ON CREATE */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.statusTextBar = findViewById(R.id.statusTextBar);
        this.initializePlayers();
        this.initializeGrid();

        announceTurn(currentPlayer);
    }

    private void announceTurn(Player player) {
        String turnAnnouncement = player.getName() + " turn";
        statusTextBar.setText(turnAnnouncement);
        statusTextBar.setTextColor(player.getColor());
    }

    private void announceWin(Player player) {
        String winAnnouncement = player.getName() + " wins!";
        statusTextBar.setText(winAnnouncement);
        statusTextBar.setTextColor(player.getColor());
    }
}