package mx.uv.ale.copsboot.user;

import java.util.UUID;
import mx.uv.ale.copsboot.jpa.AbstractEntityId;

public class UserId  extends AbstractEntityId <UUID>{
    protected UserId(){

    }

    public UserId(UUID id){
        super(id);
    }
    
}
