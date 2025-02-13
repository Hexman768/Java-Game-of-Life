package com.javolife.application;

import com.javolife.game.GameBoard;
import com.javolife.game.GameCell;
import com.javolife.game.GameConfiguration;
import com.javolife.game.IGameCell;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class handles events triggered by the user in the application interface.
 *
 * @author Zachary Pedigo
 */
public class HelloController implements Initializable {
    @FXML
    private Canvas canvasMain;

    @FXML
    private MenuItem closeMenuItem;

    @FXML
    private Spinner<Integer> rowSpinner;

    @FXML
    private Spinner<Integer> colSpinner;
    @FXML
    private Accordion accdnMain;
    @FXML
    private TitledPane tltPaneMain;
    @FXML
    private Slider sliderDensity;
    @FXML
    private Spinner<Double> spinnerDensity;

    private GameBoard gameBoard;
    private GameConfiguration config;
    private GraphicsContext graphicsContext;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        accdnMain.setExpandedPane(tltPaneMain);
        graphicsContext = canvasMain.getGraphicsContext2D();
        config = new GameConfiguration(Color.BLACK, Color.WHITE, 25, 27, 15, 375, 375, 50);
        IGameCell[][] board = new GameCell[config.getRows()][config.getColumns()];
        for (int i = 0; i < config.getRows(); i++) {
            IGameCell[] column = new GameCell[config.getColumns()];
            for (int j = 0; j < config.getColumns(); j++) {
                column[j] = GameCell.createGameCell(j, i, false);
            }
            board[i] = column;
        }
        gameBoard = new GameBoard(config.getRows(), config.getColumns(), board);
        setDefaultSettings();
        drawGameBoard(gameBoard);
    }

    @FXML
    protected void onCloseMenuItemAction() {
        Platform.exit();
    }

    @FXML
    protected void onBtnRandomizePressed() {
        gameBoard.randomize(config.getRandomDensity());
        drawGameBoard(gameBoard);
    }

    @FXML
    protected void onBtnClearPressed() {
        gameBoard.clear();
        drawGameBoard(gameBoard);
    }

    private void drawGameBoard(GameBoard board) {
        // canvas borders
        graphicsContext.setStroke(Color.BLACK);
        for (int row = 0; row < config.getRows(); row++) {
            graphicsContext.strokeLine(0, row * config.getCellSize(), config.getCanvasWidth(), row * config.getCellSize());
        }
        for (int col = 0; col < config.getColumns(); col++) {
            graphicsContext.strokeLine(col * config.getCellSize(), 0, col * config.getCellSize(), config.getCanvasHeight());
        }
        // Rectangles
        for (int i = 0; i < config.getRows(); i++) {
            for (int j = 0; j < config.getColumns(); j++) {
                graphicsContext.setStroke(Color.BLACK);
                graphicsContext.strokeRect(j * config.getCellSize(), i * config.getCellSize(), config.getCellSize(), config.getCellSize());
                graphicsContext.setFill(Color.WHITE);
                graphicsContext.fillRect(j * config.getCellSize(), i * config.getCellSize(), config.getCellSize(), config.getCellSize());
                if (board.getRow(i)[j].getState()) {
                    graphicsContext.setFill(Color.BLACK);
                    graphicsContext.fillRect(j * config.getCellSize(), i * config.getCellSize(), config.getCellSize(), config.getCellSize());
                }
            }
        }
    }

    private void setDefaultSettings() {
        SpinnerValueFactory<Integer> rowSpinnerValueFactory = new SpinnerValueFactory<>() {
            @Override
            public void decrement(int i) {
                int value = this.getValue();
                this.setValue(value -= i);
            }

            @Override
            public void increment(int i) {
                int value = this.getValue();
                this.setValue(value += i);
            }
        };
        SpinnerValueFactory<Integer> colSpinnerValueFactory = new SpinnerValueFactory<>() {
            @Override
            public void decrement(int i) {
                int value = this.getValue();
                this.setValue(value -= i);
            }

            @Override
            public void increment(int i) {
                int value = this.getValue();
                this.setValue(value += i);
            }
        };
        SpinnerValueFactory<Double> densitySpinnerValueFactory = new SpinnerValueFactory<Double>() {
            @Override
            public void decrement(int i) {
                double value = this.getValue();
                this.setValue(value -= i);
                config.setRandomDensity(this.getValue());
            }

            @Override
            public void increment(int i) {
                double value = this.getValue();
                this.setValue(value += i);
                config.setRandomDensity(this.getValue());
            }
        };
        sliderDensity.valueProperty().addListener(((observableValue, oldValue, newValue) -> {
            double value = (double) newValue;
            config.setRandomDensity(value);
            if (spinnerDensity.getValueFactory() != null) {
                spinnerDensity.getValueFactory().setValue((double) newValue);
            }
        }));
        rowSpinner.setValueFactory(rowSpinnerValueFactory);
        colSpinner.setValueFactory(colSpinnerValueFactory);
        rowSpinner.getValueFactory().setValue(config.getRows());
        colSpinner.getValueFactory().setValue(config.getColumns());
        spinnerDensity.setValueFactory(densitySpinnerValueFactory);
        spinnerDensity.getValueFactory().setValue(config.getRandomDensity());
    }
}
