package ru.blockfinder.repository;

import lombok.Getter;
import net.daporkchop.ldbjni.LevelDB;
import org.cloudburstmc.nbt.NBTInputStream;
import org.cloudburstmc.nbt.NbtMap;
import org.cloudburstmc.nbt.NbtUtils;
import org.iq80.leveldb.CompressionType;
import org.iq80.leveldb.DB;
import org.iq80.leveldb.DBIterator;
import org.iq80.leveldb.Options;
import ru.blockfinder.model.SimpleChunk;
import ru.blockfinder.model.SimpleSubChunk;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

@Getter
public class SimpleLevelDBRepository implements LevelDBRepository {
    private final Path path;

    private final DB db;

    public SimpleLevelDBRepository(Path path) throws IOException {
        this.path = path;
        Path dbPath = this.path.resolve("db");

        Options options = new Options()
                .compressionType(CompressionType.ZLIB_RAW)
                .blockSize(64 * 1024);
        this.db = LevelDB.PROVIDER.open(dbPath.toFile(), options);
    }

    @Override
    public DB getDb() {
        return db;
    }

    @Override
    public Set<SimpleChunk> getAllChunks() throws IOException {
        List<SimpleSubChunk> simpleSubChunkList = new ArrayList<>();
        byte searchKey = LevelDBKey.getEncoded(LevelDBKey.SUBCHUNK_PREFIX);
        DBIterator iterator = db.iterator();
        try {
            for (iterator.seekToFirst(); iterator.hasNext(); iterator.next()) {
                byte[] key = iterator.peekNext().getKey();
                if (key.length == 9) {
                    SimpleSubChunk simpleSubChunk = new SimpleSubChunk(key);
                    simpleSubChunkList.add(simpleSubChunk);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Set<SimpleChunk> result = new HashSet<>();
        for (SimpleSubChunk simpleSubChunk : simpleSubChunkList) {
            SimpleChunk simpleChunk = new SimpleChunk(simpleSubChunk.getX(), simpleSubChunk.getZ());
            result.add(simpleChunk);
        }
        populateChunksWithEntityTags(result);
        return result;
    }

    private void populateChunksWithEntityTags(Set<SimpleChunk> chunks) {
        for (SimpleChunk chunk : chunks) {
            byte[] key = LevelDBKey.BLOCK_ENTITIES.getKey(chunk.getX(), chunk.getZ());
            byte[] value = db.get(key);

            if (value != null) {
                List<NbtMap> entityTags = new ArrayList<>();
                try (ByteArrayInputStream stream = new ByteArrayInputStream(value);
                     NBTInputStream nbtInputStream = NbtUtils.createReaderLE(stream)) {
                    while (stream.available() > 0) {
                        entityTags.add((NbtMap) nbtInputStream.readTag());
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                chunk.setTags(entityTags);
            }
        }
    }

    @Override
    public Set<SimpleChunk> findChunksWithEntitiesByName(String name) throws IOException {
        Set<SimpleChunk> chunks = getAllChunks();
        Set<SimpleChunk> result = new HashSet<>();
        for (SimpleChunk chunk : chunks) {
            if (chunk.getTags() != null && chunk.getTags().size() > 0) {
                var tags = chunk.getTags();
                for (NbtMap tag : tags) {
                    if (tag.get("id").equals(name)) {
                        result.add(chunk);
                    }
                }
            }
        }
        return result;
    }

    @Override
    public Set<SimpleChunk> findChunksWithEntitiesByName(String[] names) throws IOException {
        Set<SimpleChunk> chunks = getAllChunks();
        Set<SimpleChunk> result = new HashSet<>();
        for (String name : names) {
            for (SimpleChunk chunk : chunks) {
                if (chunk.getTags() != null && chunk.getTags().size() > 0) {
                    var tags = chunk.getTags();
                    for (NbtMap tag : tags) {
                        if (tag.get("id").equals(name)) {
                            result.add(chunk);
                        }
                    }
                }
            }
        }
        return result;
    }

    @Override
    public List<NbtMap> findTagsByName(String name) throws IOException {
        List<NbtMap> result = new ArrayList<>();
        Set<SimpleChunk> chunks = getAllChunks();
        for (SimpleChunk chunk : chunks) {
            if (chunk.getTags() != null && chunk.getTags().size() > 0) {
                var tags = chunk.getTags();
                for (NbtMap tag : tags) {
                    if (tag.get("id").equals(name)) {
                        result.add(tag);
                    }
                }
            }
        }
        return result;
    }

    @Override
    public List<NbtMap> findTagsByName(String[] names) throws IOException {
        List<NbtMap> result = new ArrayList<>();
        Set<SimpleChunk> chunks = getAllChunks();
        for (String name : names) {
            for (SimpleChunk chunk : chunks) {
                if (chunk.getTags() != null && chunk.getTags().size() > 0) {
                    var tags = chunk.getTags();
                    for (NbtMap tag : tags) {
                        if (tag.get("id").equals(name)) {
                            result.add(tag);
                        }
                    }
                }
            }
        }
        return result;
    }

    @Override
    public Set<String> getUniqueEntities() throws IOException {
        Set<SimpleChunk> chunks = getAllChunks();
        Set<String> result = new HashSet<>();
        for (SimpleChunk chunk : chunks) {
            if (chunk.getTags() != null && chunk.getTags().size() > 0) {
                var tags = chunk.getTags();
                for (NbtMap tag : tags) {
                    result.add(tag.get("id").toString());
                }
            }
        }
        List<String> sortedList = new ArrayList<>(result);
        Collections.sort(sortedList);
        Set<String> sortedSet = new LinkedHashSet<>(sortedList);
        return sortedSet;
    }
}
