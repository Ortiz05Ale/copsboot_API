package mx.uv.ale.copsboot.jpa;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.MappedSuperclass;
import static com.google.common.base.MoreObjects.toStringHelper;



@MappedSuperclass
public abstract class AbstractEntityId <T extends Serializable> implements Serializable,
EntityId<T> {

    private T id;

    @ArtifactForFramework
    protected AbstractEntityId(){

    }
    protected AbstractEntityId(T id){
        this.id = Objects.requireNonNull(id);
    }

    @Override
    public T getId(){
        return id;
    }

    @Override
    public String aString(){
        return id.toString();
    }
    
    @Override
    public boolean equals(Object o){
        boolean result = false;

        if (this == o) {
            result = true;
        } else if (o instanceof AbstractEntityId){
            AbstractEntityId other = (AbstractEntityId) o;
            result = Objects.equals(id, other.id);
        }
        
        return result;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    @Override
    public String toString(){
        return toStringHelper(this).add("id", id).toString();
    }
}
