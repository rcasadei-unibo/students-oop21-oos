package view;
 
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
 
public final class StartMenuViewImpl implements StartMenuView {

    private static final double GAME_SCREEN_WIDTH = 854.0;
    private static final double GAME_SCREEN_HEIGHT = 445.0;
    private static final int FONT_SIZE = 18;
    private static final int BUTTON_WIDTH = 150;
    private static final int ALL_BUTTON_X = 340;
    private static final int START_BUTTON_Y = 300;
    private static final int EXIT_BUTTON_Y = 350;

    private final View view;
    private final Stage stage;
    private final Pane pane;

    /**
     * Creates a new StartMenuViewImpl.
     * @param view the {@link View} of the application.
     * @param stage the {@link Stage}.
     * @param pane the {@link Pane}.
     */
    public StartMenuViewImpl(final View view, final Stage stage, final Pane pane) {
        super();
        this.view = view;
        this.stage = stage;
        this.pane = pane;
        final Image backImage = new Image("GameScreen.png", GAME_SCREEN_WIDTH, GAME_SCREEN_HEIGHT, true, true);
        final BackgroundImage background = new BackgroundImage(backImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.pane.setBackground(new Background(background));
    }
 
    /**
     * {@inheritDoc}
     */
    @Override
    public void render() {
        final Button start = new Button();
        start.setLayoutX(ALL_BUTTON_X);
        start.setLayoutY(START_BUTTON_Y);
        start.setPrefWidth(BUTTON_WIDTH);
        start.setTextAlignment(TextAlignment.CENTER);
        start.setFont(new Font("Arial", FONT_SIZE));
        start.setText("START");
        start.setOnAction(e -> {
            pane.getChildren().clear();
            this.view.getController().start();
        });
 
        final Button exit = new Button();
        exit.setLayoutX(ALL_BUTTON_X);
        exit.setLayoutY(EXIT_BUTTON_Y);
        exit.setPrefWidth(BUTTON_WIDTH);
        exit.setTextAlignment(TextAlignment.CENTER);
        exit.setFont(new Font("Arial", FONT_SIZE));
        exit.setText("EXIT");
        exit.setOnAction(e -> {
            stage.close();
        });
 
        this.pane.getChildren().add(start);
        this.pane.getChildren().add(exit);
 
    }
 
}
