package mx.uv.ale.copsboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CopsbootApplicationConfiguration {
    @Bean
    public UniqueIdGenerator<UUID> uniqueIdGenerator(){
        return new InMemoryUniqueIdGeneratoor();
    }
}
