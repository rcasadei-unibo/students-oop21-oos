package view;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Statistics;

public class GameOverViewImpl implements GameOverView {

    private final View view;
    private final Stage stage;
    private final Pane pane;
    private final Statistics statistics;

    public GameOverViewImpl(final View view, final Stage stage, final Pane pane, final Statistics statistics) {
        super();
        this.view = view;
        this.stage = stage;
        this.pane = pane;
        this.statistics = statistics;
    }

    @Override
    public void render() {
        // TODO Auto-generated method stub

    }

}
