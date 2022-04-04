package view;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.GameState;
import model.Statistics;
import view.entity.EntityView;
import view.entity.EntityViewImpl;

public class GameViewImpl implements GameView {

    private final View view;
    private final Stage stage;
    private final Pane pane;
    private final PlayerView playerView;
    private final EntityView entityView;
    private final GameState gameState;
    private final Statistics statistics;

    public GameViewImpl(final View view, final Stage stage, final Pane pane, final GameState gameState, final Statistics statistics) {
        super();
        this.view = view;
        this.stage = stage;
        this.pane = pane;
        this.playerView = new PlayerViewImpl(pane, gameState.getPlayer());
        this.entityView = new EntityViewImpl(pane, gameState.getEntities());
        this.gameState = gameState;
        this.statistics = statistics;

    }

    @Override
    public void render() {
        this.playerView.render();
        this.entityView.render();

    }

}
