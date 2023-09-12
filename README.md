# Blockfinder

## Description

Program is used to parse Minecraft levelDB world and find certain kinds of blocks

## Setup
minimum version of Java 17.0.6

## Usage
run program in the command line `java -jar blockfinder.jar`

pass program arguments:
    `-p=` path to world file, example: -p=C:\world
    `-f=` one of (chunk, tag or unique), example -f=chunk
    `-s=` Entity to search, example -s=Chunk. Only required for `chunk` and `tag` functions

example of full command line:
    `java -jar blockfinder -p=C:\world -f=tag -s=Chest`

