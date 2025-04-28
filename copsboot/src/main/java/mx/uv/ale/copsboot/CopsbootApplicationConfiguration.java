package mx.uv.ale.copsboot;

import mx.uv.ale.copsboot.jpa.UniqueIdGenerator;
import java.util.UUID;
import mx.uv.ale.copsboot.jpa.InMemoryUniqueIdGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CopsbootApplicationConfiguration {
    @Bean
    public UniqueIdGenerator<UUID> uniqueIdGenerator(){
        return new InMemoryUniqueIdGenerator();
    }
}
