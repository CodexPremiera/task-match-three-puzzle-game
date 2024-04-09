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
    }

    private void initializeTopCell(RelativeLayout cellButton, Column column) {
        cellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle onClick event here
                column.addColoredCell(player1);
            }
        });
    }


    private void initializeGrid() {
        this.grid = new Grid();

        // Column A
        Column columnA = new Column();
        RelativeLayout topOfA = findViewById(R.id.cellA1);
        initializeTopCell(topOfA, columnA);

        columnA.addCell(new Cell(topOfA));
        columnA.addCell(new Cell(findViewById(R.id.cellA2)));
        columnA.addCell(new Cell(findViewById(R.id.cellA3)));
        columnA.addCell(new Cell(findViewById(R.id.cellA4)));
        columnA.addCell(new Cell(findViewById(R.id.cellA5)));
        grid.addColumn(columnA);

        // Column B
        Column columnB = new Column();
        RelativeLayout topOfB = findViewById(R.id.cellB1);
        initializeTopCell(topOfB, columnB);

        columnB.addCell(new Cell(topOfB));
        columnB.addCell(new Cell(findViewById(R.id.cellB1)));
        columnB.addCell(new Cell(findViewById(R.id.cellB2)));
        columnB.addCell(new Cell(findViewById(R.id.cellB3)));
        columnB.addCell(new Cell(findViewById(R.id.cellB4)));
        columnB.addCell(new Cell(findViewById(R.id.cellB5)));
        grid.addColumn(columnB);

        // Column C
        Column columnC = new Column();
        RelativeLayout topOfC = findViewById(R.id.cellC1);
        initializeTopCell(topOfC, columnC);

        columnC.addCell(new Cell(topOfC));
        columnC.addCell(new Cell(findViewById(R.id.cellC1)));
        columnC.addCell(new Cell(findViewById(R.id.cellC2)));
        columnC.addCell(new Cell(findViewById(R.id.cellC3)));
        columnC.addCell(new Cell(findViewById(R.id.cellC4)));
        columnC.addCell(new Cell(findViewById(R.id.cellC5)));
        grid.addColumn(columnC);

        // Column D
        Column columnD = new Column();
        RelativeLayout topOfD = findViewById(R.id.cellD1);
        initializeTopCell(topOfD, columnD);

        columnD.addCell(new Cell(topOfD));
        columnD.addCell(new Cell(findViewById(R.id.cellD1)));
        columnD.addCell(new Cell(findViewById(R.id.cellD2)));
        columnD.addCell(new Cell(findViewById(R.id.cellD3)));
        columnD.addCell(new Cell(findViewById(R.id.cellD4)));
        columnD.addCell(new Cell(findViewById(R.id.cellD5)));
        grid.addColumn(columnD);

        // Column E
        Column columnE = new Column();
        RelativeLayout topOfE = findViewById(R.id.cellE1);
        initializeTopCell(topOfE, columnE);

        columnE.addCell(new Cell(topOfE));
        columnE.addCell(new Cell(findViewById(R.id.cellE2)));
        columnE.addCell(new Cell(findViewById(R.id.cellE3)));
        columnE.addCell(new Cell(findViewById(R.id.cellE4)));
        columnE.addCell(new Cell(findViewById(R.id.cellE5)));
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