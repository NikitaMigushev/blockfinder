package ru.blockfinder.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.cloudburstmc.nbt.NbtMap;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SimpleChunk {
    private int x;

    private int z;

    @JsonFormat(with = JsonFormat.Feature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)
    private List<NbtMap> tags;

    public SimpleChunk(int x, int z) {
        this.x = x;
        this.z = z;
    }

    @Override
    public String toString() {
        return "SimpleChunk{"
                + "x=" + x
                + ", z=" + z
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleChunk that = (SimpleChunk) o;
        return x == that.x && z == that.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, z);
    }
}


