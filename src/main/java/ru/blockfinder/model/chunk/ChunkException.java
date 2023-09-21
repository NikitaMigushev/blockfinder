package ru.blockfinder.model.chunk;

public class ChunkException extends RuntimeException {

    public ChunkException(String message) {
        super(message);
    }

    public ChunkException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChunkException(Throwable cause) {
        super(cause);
    }

}
