package nl.underkoen.jetbrains.adventofcode.file;

import com.intellij.ide.FileIconProvider;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import nl.underkoen.jetbrains.adventofcode.general.Day;
import nl.underkoen.jetbrains.adventofcode.general.components.Icons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class AOCFileIconProvider implements FileIconProvider, DumbAware {
    @Override
    public @Nullable Icon getIcon(@NotNull VirtualFile file, int flags, @Nullable Project project) {
        if (file instanceof Day) {
            return Icons.AOC_FILE;
        }
        return null;
    }
}
