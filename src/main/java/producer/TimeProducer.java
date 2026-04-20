package producer;

import jakarta.enterprise.inject.Produces;
import java.time.LocalDateTime;

public class TimeProducer {

    @Produces
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}