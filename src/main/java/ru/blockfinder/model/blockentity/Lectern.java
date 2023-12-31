package ru.blockfinder.model.blockentity;

import org.checkerframework.checker.index.qual.NonNegative;
import org.checkerframework.checker.nullness.qual.Nullable;
import ru.blockfinder.model.item.ItemStack;

public interface Lectern extends BlockEntity {

    boolean hasBook();

    @Nullable
    ItemStack getBook();

    void setBook(@Nullable ItemStack book);

    int getPage();

    void setPage(@NonNegative int page);

    int getTotalPages();
}
