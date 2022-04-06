package input;

import java.util.HashSet;
import java.util.Set;

public class InputObserverImpl implements InputObserver {

    private final Set<Command> commands;

    public InputObserverImpl() {
        this.commands = new HashSet<>();
    }

    @Override
    public void notify(final Command cmd) {
        this.commands.add(cmd);
    }

    @Override
    public Set<Command> getCommands() {
        return this.commands;
    }

    @Override
    public void clear() {
        this.commands.clear();
    }

}
