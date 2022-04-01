package main.view;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StartMenuViewImpl implements StartMenuView {

    private final View view;
    private final Stage stage;
    private final Pane pane;

    public StartMenuViewImpl(final View view, final Stage stage, final Pane pane) {
        super();
        this.view = view;
        this.stage = stage;
        this.pane = pane;
    }

    @Override
    public void render() {
        // TODO Auto-generated method stub

    }

}
