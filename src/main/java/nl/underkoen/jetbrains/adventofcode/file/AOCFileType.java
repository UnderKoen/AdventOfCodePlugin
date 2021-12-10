package nl.underkoen.jetbrains.adventofcode.file;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.openapi.vfs.VirtualFile;
import kotlin.text.Charsets;
import nl.underkoen.jetbrains.adventofcode.general.components.Icons;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class AOCFileType implements FileType, DumbAware {
    public static AOCFileType fileType = new AOCFileType();

    @Override
    public @NonNls @NotNull String getName() {
        return "AdventOfCode";
    }

    @Override
    public @NlsContexts.Label @NotNull String getDescription() {
        return "AdventOfCode";
    }

    @Override
    public @NlsSafe @NotNull String getDefaultExtension() {
        return "aoc";
    }

    @Override
    public @Nullable Icon getIcon() {
        return Icons.AOC_FILE;
    }

    @Override
    public boolean isBinary() {
        return false;
    }

    @Override
    public @NonNls @Nullable String getCharset(@NotNull VirtualFile file, byte @NotNull [] content) {
        return Charsets.UTF_8.name();
    }
}
