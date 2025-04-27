package mx.uv.ale.copsboot.jpa;

import java.io.Serializable;

public interface EntityId <T> extends Serializable{
    T getId();

    String aString();
    
}
