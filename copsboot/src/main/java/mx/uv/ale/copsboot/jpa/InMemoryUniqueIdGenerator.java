package mx.uv.ale.copsboot.jpa;

import java.util.UUID;

public class InMemoryUniqueIdGenerator implements UniqueIdGenerator<UUID> {
    @Override
    public UUID getNextUniqueId(){
        return UUID.randomUUID();
    }
    
}
