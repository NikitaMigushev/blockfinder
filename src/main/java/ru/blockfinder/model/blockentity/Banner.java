package ru.blockfinder.model.blockentity;

import com.google.common.collect.ImmutableList;
import ru.blockfinder.util.data.BannerPattern;
import ru.blockfinder.util.data.DyeColor;

public interface Banner extends BlockEntity {

    DyeColor getBase();

    void setBase(DyeColor color);

    int getBannerType();

    void setBannerType(int type);

    void addPattern(BannerPattern pattern);

    BannerPattern getPattern(int index);

    ImmutableList<BannerPattern> getPatterns();

    void removePattern(int index);
}
