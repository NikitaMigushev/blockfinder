package ru.blockfinder.model.blockentity;

public interface Comparator extends BlockEntity {

    int getOutputSignal();

    void setOutputSignal(int outputSignal);
}
