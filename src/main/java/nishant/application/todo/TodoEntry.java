package nishant.application.todo;

import java.util.Date;
import java.util.UUID;

public record TodoEntry(UUID uuid, Date date, String text, Boolean completed) {

    public TodoEntry(String text) {
        this(UUID.randomUUID(), new Date(), text, false);
    }
}
