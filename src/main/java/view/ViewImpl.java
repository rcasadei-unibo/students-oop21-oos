package view;

import controller.Controller;
import controller.ControllerImpl;
import model.GameState;
import model.Statistics;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ViewImpl extends Application implements View {

    private Controller controller;

    private Pane pane;
    private Stage stage;

    private StartMenuView startMenuView;
    private GameView gameView;
    private GameOverView gameOverView;

    public ViewImpl() {
    }

    @Override
    public void startMenu() {
        this.controller = new ControllerImpl(this);
        this.pane = new Pane();
        this.startMenuView = new StartMenuViewImpl(this, this.stage, this.pane);
        this.startMenuView.render();

        //set stage
        this.stage.setWidth(854);
        this.stage.setHeight(480);
        this.stage.setScene(new Scene(this.pane));
        this.stage.setResizable(false);
        this.stage.show();

    }

    @Override
    public void game() {
        final GameState gameState = this.controller.getModel().getGameState();
        final Statistics statistics = this.controller.getModel().getStatistics();
        this.gameView = new GameViewImpl(this, this.stage, this.pane, gameState, statistics); 
        this.gameView.render();

    }

    @Override
    public void gameOver() {
        final Statistics statistics = this.controller.getModel().getStatistics();
        this.gameOverView = new GameOverViewImpl(this, this.stage, this.pane, statistics);
        this.gameOverView.render();

    }

    @Override
    public void shop() {
        // TODO Auto-generated method stub

    }

    @Override
    public void render() {
        this.game();

    }

    @Override
    public Controller getController() {
        return this.controller;

    }

    @Override
    public void start(final Stage stage) throws Exception {
        this.stage = stage;
        this.stage.setTitle("OOS");
        this.startMenu();

    }

}
