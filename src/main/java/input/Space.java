package input;

import model.GameState;

public class Space implements Command {

    private final GameState gameState;

    public Space(final GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void execute() {
        this.gameState.getPlayer().jump();
    }

}
