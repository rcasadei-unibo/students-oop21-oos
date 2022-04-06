package input;

import java.util.Set;

public interface InputObserver {

    void notify(Command cmd);

    Set<Command> getCommands();

    void clear();

}
