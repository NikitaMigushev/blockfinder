package ru.blockfinder.serializer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import it.unimi.dsi.fastutil.ints.Int2ShortMap;
import it.unimi.dsi.fastutil.ints.Int2ShortOpenHashMap;
import org.iq80.leveldb.DB;
import ru.blockfinder.model.ChunkException;
import ru.blockfinder.model.ChunkSection;
import ru.blockfinder.model.SimpleChunk;
import ru.blockfinder.repository.LevelDBKey;

public class ChunkSerializerV3 implements ChunkSerializer {

    static ChunkSerializer INSTANCE = new ChunkSerializerV3();

    private Int2ShortMap extraData;

    @Override
    public Int2ShortMap getExtraData() {
        return extraData;
    }

    @Override
    public void deserialize(DB db, SimpleChunk simpleChunk) {
        int chunkX = simpleChunk.getX();
        int chunkZ = simpleChunk.getZ();

        Int2ShortMap extraDataMap = null;

        byte[] extraData = db.get(LevelDBKey.BLOCK_EXTRA_DATA.getKey(chunkX, chunkZ));
        if (extraData != null) {
            extraDataMap = new Int2ShortOpenHashMap();
            ByteBuf extraDataBuf = Unpooled.wrappedBuffer(extraData);

            int count = extraDataBuf.readIntLE();
            for (int i = 0; i < count; i++) {
                int key = extraDataBuf.readIntLE();
                short value = extraDataBuf.readShortLE();
                extraDataMap.put(key, value);
            }
        }

        ChunkSection[] sections = new ChunkSection[SimpleChunk.SECTION_COUNT];
        for (int ySection = 0; ySection < SimpleChunk.SECTION_COUNT; ySection++) {
            byte[] sectionData = db.get(LevelDBKey.SUBCHUNK_PREFIX.getKey(chunkX, chunkZ, ySection));
            if (sectionData == null) {
                continue;
            }
            ByteBuf buf = Unpooled.wrappedBuffer(sectionData);
            if (!buf.isReadable()) {
                throw  new ChunkException("Empty sub-chunk " + ySection);
            }
            int subChunkVersion = buf.readUnsignedByte();
            System.out.println("check here");
        }
    }
}