package ru.blockfinder.model.blockentity;

public interface Sign extends BlockEntity {

    String getTextOwner();

    void setTextOwner(String textOwner);

    String[] getText();

    void setText(String... lines);
}
