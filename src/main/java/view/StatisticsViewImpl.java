package view;

import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.Statistics;
import model.player.Player;

public final class StatisticsViewImpl implements StatisticsView {

    private static final int FONT_SIZE = 18;
    private static final int TEXT_XY = 25;
    private final Pane pane;
    private final Statistics statistics;
    private final Player player;

    public StatisticsViewImpl(final Pane pane, final Statistics statistics, final Player player) {
        this.pane = pane;
        this.statistics = statistics;
        this.player = player;
    }

    @Override
    public void render() {
        final Text text = new Text("Coin: " + statistics.getGameCoins() + "\nLives: " + player.getLives());
        text.setFont(new Font(FONT_SIZE));
        text.setX(TEXT_XY);
        text.setY(TEXT_XY);
        this.pane.getChildren().add(text);
    }

}
