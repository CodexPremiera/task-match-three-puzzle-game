package task.match_three_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import task.match_three_game.logic.Cell;
import task.match_three_game.logic.Column;
import task.match_three_game.logic.Grid;
import task.match_three_game.logic.Player;

public class MainActivity extends AppCompatActivity {
    private Grid grid;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    /* INITIALIZERS */
    private void initializePlayers() {
        int yellow = ContextCompat.getColor(this, R.color.button_yellow);
        int blue = ContextCompat.getColor(this, R.color.button_blue);

        player1 = new Player("Player 1", blue);
        player2 = new Player("Player 2", yellow);
        currentPlayer = player1;
    }

    private void initializeTopCell(RelativeLayout cellButton, Column column) {
        cellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check the connect at current cell, catch error if column is full
                try {
                    grid.checkConnect3(column, currentPlayer);
                    currentPlayer = (currentPlayer == player1) ? player2 : player1;
                } catch (RuntimeException columnIsFullException) {
                    columnIsFullException.printStackTrace();
                }
            }
        });
    }


    private void initializeGrid() {
        this.grid = new Grid();

        // Column A
        Column columnA = new Column();
        RelativeLayout topOfA = findViewById(R.id.cellA1);
        initializeTopCell(topOfA, columnA);

        columnA.addCell(new Cell(findViewById(R.id.cellA5)));
        columnA.addCell(new Cell(findViewById(R.id.cellA4)));
        columnA.addCell(new Cell(findViewById(R.id.cellA3)));
        columnA.addCell(new Cell(findViewById(R.id.cellA2)));
        columnA.addCell(new Cell(topOfA));
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
        grid.addColumn(columnE);
    }


    /* ON CREATE */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initializePlayers();
        this.initializeGrid();
    }
}