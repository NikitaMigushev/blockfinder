package ru.blockfinder.model;

public interface BitArray {
    void set(int index, int value);

    int get(int index);

    int size();

    int[] getWords();

    BitArrayVersion getVersion();

    BitArray copy();
}
