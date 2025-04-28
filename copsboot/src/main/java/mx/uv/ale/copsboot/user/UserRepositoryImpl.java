package mx.uv.ale.copsboot.user;

import java.util.UUID;
import mx.uv.ale.copsboot.jpa.UniqueIdGenerator;
import mx.uv.ale.copsboot.user.UserRepositoryCustom;

public class UserRepositoryImpl implements UserRepositoryCustom{
    private final UniqueIdGenerator<UUID> generator;

    public UserRepositoryImpl(UniqueIdGenerator<UUID> generator){
        this.generator = generator;
    }

    @Override
    public UserId nextId(){
        return new UserId(generator.getNextUniqueId());
    }
    
}
