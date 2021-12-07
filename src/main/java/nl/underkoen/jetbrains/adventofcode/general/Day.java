package nl.underkoen.jetbrains.adventofcode.general;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileSystem;
import lombok.Getter;
import nl.underkoen.jetbrains.adventofcode.file.AOCFileType;
import nl.underkoen.jetbrains.adventofcode.general.tree.TreeLeaf;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Getter
public class Day extends VirtualFile implements TreeLeaf<Year> {
    private final int day;
    @Getter private final Year year;

    public Day(int day, Year year) {
        this.year = year;
        this.day = day;
    }

    @Override
    public String toString() {
        return String.format("Day %02d", day);
    }

    public int stars() {
        return day % 3;
    }

    public String starsString() {
        switch (stars()) {
            case 1:
                return "*";
            case 2:
                return "**";
            default:
                return "  ";
        }
    }

    @Override
    public @NotNull @NlsSafe String getName() {
        return toString();
    }

    @Override
    public @NotNull VirtualFileSystem getFileSystem() {
        return year.getFileSystem();
    }

    @Override
    public @NonNls @NotNull String getPath() {
        return year.getPath() + "/" + getName();
    }

    @Override
    public boolean isWritable() {
        return false;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public Year getParent() {
        return year;
    }

    @Override
    public VirtualFile[] getChildren() {
        return null;
    }

    @Override
    public @NotNull OutputStream getOutputStream(Object requestor, long newModificationStamp, long newTimeStamp) throws IOException {
        return OutputStream.nullOutputStream();
    }

    @Override
    public byte @NotNull [] contentsToByteArray() throws IOException {
        return new byte[0];
    }

    @Override
    public long getTimeStamp() {
        return 0;
    }

    @Override
    public long getLength() {
        return 0;
    }

    @Override
    public long getModificationStamp() {
        return 0;
    }

    @Override
    public void refresh(boolean asynchronous, boolean recursive, @Nullable Runnable postRunnable) {

    }

    @Override
    public @NotNull InputStream getInputStream() throws IOException {
        return InputStream.nullInputStream();
    }

    @Override
    public @NotNull FileType getFileType() {
        return AOCFileType.fileType;
    }
}
