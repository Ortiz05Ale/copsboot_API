package mx.uv.ale.copsboot.jpa;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.EmbeddedId;

import java.util.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;


@MappedSuperclass
public abstract class AbstractEntity <T extends EntityId> implements Entity<T> {

    @EmbeddedId
    private T id;

    @ArtifactForFramework
    protected AbstractEntity(){

    }

    public AbstractEntity(T id){
        this.id = checkNotNull(id);
    }

    @Override
    public T getId(){
        return id;
    }

    @Override
    public boolean equals(Object obj){
        boolean result = false;

        if (this == obj) {
            result = true;
        } else if (obj instanceof AbstractEntityId){
            AbstractEntityId other = (AbstractEntityId) obj;
            result = Objects.equals(id, other.getId());
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
