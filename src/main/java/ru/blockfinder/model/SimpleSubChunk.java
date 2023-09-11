package ru.blockfinder.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SimpleSubChunk {
    private int x;
    private int z;
    private int y;

    byte[] rawKey;

    byte[] rawData;


    public SimpleSubChunk(int x, int z, int y) {
        this.x = x;
        this.z = z;
        this.y = y;
    }

    public SimpleSubChunk(byte[] rawKey) {
        this.rawKey = rawKey;
        x = defineX(rawKey);
        z = defineZ(rawKey);
        y = rawKey[rawKey.length - 1];
    }

    public SimpleSubChunk(byte[] rawKey, byte[] data) {
        this.rawKey = rawKey;
        x = defineX(rawKey);
        z = defineZ(rawKey);
        y = rawKey[rawKey.length - 1];
        rawData = data;
    }

    private int defineX(byte[] byteArray) {
        int value = 0;
        for (int i = 0; i < 4; i++) {
            value |= (byteArray[0 + i] & 0xFF) << (8 * i);
        }
        return value;
    }

    private int defineZ(byte[] byteArray) {
        int value = 0;
        for (int i = 0; i < 4; i++) {
            value |= (byteArray[4 + i] & 0xFF) << (8 * i);
        }
        return value;
    }
}
