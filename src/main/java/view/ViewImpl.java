package view;

import controller.Controller;
import controller.ControllerImpl;
import input.InputObserver;
import input.InputObserverImpl;
import model.Model;
import model.Statistics;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * 
 * Entry point of the application.
 * Implementation of {@link View}.
 * Extends {@link Application}.
 *
 */
public class ViewImpl extends Application implements View {

    private Controller controller;
    private Pane pane;
    private Stage stage;
    private GameView gameView;
    private InputObserver observer;

    /**
     * {@inheritDoc}
     */
    @Override
    public void startMenu() {
        this.observer = new InputObserverImpl();
        this.controller = new ControllerImpl(this, this.observer);
        this.pane = new Pane();

        final StartMenuView startMenuView = new StartMenuViewImpl(this, this.stage, this.pane);
        startMenuView.render();

        //set stage
        this.stage.setWidth(this.controller.getWidth());
        this.stage.setHeight(this.controller.getHeight());
        this.stage.setScene(new Scene(this.pane));
        this.stage.setResizable(false);
        this.stage.setOnCloseRequest(e -> {
            System.exit(0);
        });
        this.stage.show();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void game() {
        final Model model = this.controller.getModel();
        this.gameView = new GameViewImpl(this.pane, this.observer, model); 
        this.gameView.render();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void gameOver() {
        final Statistics statistics = this.controller.getModel().getStatistics();
        final GameOverView gameOverView = new GameOverViewImpl(this, this.stage, this.pane, statistics);
        gameOverView.render();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shop() {
        final ShopView shopView = new ShopViewImpl(this, this.pane);
        shopView.render();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void render() {
        this.gameView.render();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Controller getController() {
        return this.controller;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(final Stage stage) throws Exception {
        this.stage = stage;
        this.stage.setTitle("OOS");
        this.startMenu();
    }

}
