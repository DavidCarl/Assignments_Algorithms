package utils;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Reader {

    //USING THIS SPLITTER http://www.admios.com/blog/how-to-split-a-file-using-java VERSION 3, CHANNELING

    private final String dir = "Files/split/";
    private final String suffix = ".splitPart";

    public List<Path> splitFile(final String fileName, final int mBperSplit) throws IOException {

        if (mBperSplit <= 0) {
            throw new IllegalArgumentException("mBperSplit must be more than zero");
        }

        List<Path> partFiles = new ArrayList<>();
        final long sourceSize = Files.size(Paths.get(fileName));
        final long bytesPerSplit = 1024L * 1024L * mBperSplit;
        final long numSplits = sourceSize / bytesPerSplit;
        final long remainingBytes = sourceSize % bytesPerSplit;
        int position = 0;

        long start = 0;
        long end = 0;

        try (RandomAccessFile sourceFile = new RandomAccessFile(fileName, "r");
             FileChannel sourceChannel = sourceFile.getChannel()) {
            for (; position < numSplits; position++) {
                for(long i = ((position*bytesPerSplit) + bytesPerSplit); i > 0; i--){
                    sourceFile.seek(i);
                    if(sourceFile.readByte() == 48) {
                        start = end;
                        end = i;
                        System.out.println((end - start) + " : " + end);
                        writePartToFile((end - start), start, sourceChannel, partFiles);
                        break;
                    }
                }
//                System.out.println("BYTE START!");
//                System.out.println(start);
//                System.out.println("BYTE END! FIRST I DIRECT AND SECOND IS NEWLINE SPLIT");
//                System.out.println((position*bytesPerSplit) + bytesPerSplit);
//                System.out.println(end);
//                System.out.println("");
            }
            if (remainingBytes > 0) {
                System.out.println(sourceSize + " REST FILE! " + (sourceSize - end));
                writePartToFile((sourceSize - end), end, sourceChannel, partFiles);
            }
        }
        return partFiles;
    }

    private void writePartToFile(long byteSize, long position, FileChannel sourceChannel, List<Path> partFiles) throws IOException {
        Path fileName = Paths.get(dir + UUID.randomUUID() + suffix);
//        System.out.println(fileName.toFile());
        try (RandomAccessFile toFile = new RandomAccessFile(fileName.toFile(), "rw");
             FileChannel toChannel = toFile.getChannel()) {
            sourceChannel.position(position);
            toChannel.transferFrom(sourceChannel, 0, byteSize);
        }
        partFiles.add(fileName);
    }
}
