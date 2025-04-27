package mx.uv.ale.copsboot.jpa;

public interface UniqueIdGenerator<T> {
    T getNextUniqueId();
}
