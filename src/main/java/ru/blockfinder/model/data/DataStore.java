package ru.blockfinder.model.data;

public interface DataStore {

    <T> T get(DataKey<T, ?> key);
}
