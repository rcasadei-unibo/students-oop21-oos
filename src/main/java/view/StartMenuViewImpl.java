package view;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public final class StartMenuViewImpl implements StartMenuView {

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
        Button start = new Button();

        start.setOnAction(e -> {
            pane.getChildren().clear();
            this.view.getController().start();
        });

        Button exit = new Button();

        exit.setOnAction(e -> {
            stage.close();
        });

        Button shop = new Button();

    }

}
