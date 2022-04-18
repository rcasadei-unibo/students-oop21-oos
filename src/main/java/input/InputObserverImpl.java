package input;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * An input observer of the {@link GameViewImpl}.
 * Implements {@link InputOsberver} interface.
 *
 */
public class InputObserverImpl implements InputObserver {

    private final Set<Command> commands;

    /**
     * Creates a new InputObserverImpl with a set of commands initially empty.
     * 
     */
    public InputObserverImpl() {
        this.commands = new HashSet<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notify(final Command cmd) {
        this.commands.add(cmd);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Command> getCommands() {
        return this.commands;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        this.commands.clear();
    }

}
