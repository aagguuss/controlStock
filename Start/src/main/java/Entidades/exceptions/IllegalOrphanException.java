package Entidades.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IllegalOrphanException extends Exception {
    private final List<String> messages;

    public IllegalOrphanException(List<String> messages) {
        super((messages != null && !messages.isEmpty() ? messages.get(0) : null));
        this.messages = Objects.requireNonNullElseGet(messages, ArrayList::new);
    }

    public List<String> getMessages() {
        return messages;
    }
}
