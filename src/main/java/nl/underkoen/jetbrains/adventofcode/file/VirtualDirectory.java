package nl.underkoen.jetbrains.adventofcode.file;

import com.intellij.openapi.vfs.VirtualFile;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public abstract class VirtualDirectory extends VirtualFile {
    private final VirtualFile parent;
    @Getter @Setter(AccessLevel.PROTECTED)
    private List<? extends VirtualFile> files;

    protected VirtualDirectory(VirtualFile parent, List<? extends VirtualFile> files) {
        this.parent = parent;
        this.files = files;
    }

    @Override
    public @NonNls @NotNull String getPath() {
        if (parent == null) return getName();
        return parent.getPath() + "/" + getName();
    }

    @Override
    public boolean isWritable() {
        return false;
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public VirtualFile getParent() {
        return parent;
    }

    @Override
    public VirtualFile[] getChildren() {
        return files.toArray(VirtualFile[]::new);
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
    public void refresh(boolean asynchronous, boolean recursive, @Nullable Runnable postRunnable) {

    }

    @Override
    public @NotNull InputStream getInputStream() throws IOException {
        return InputStream.nullInputStream();
    }
}
