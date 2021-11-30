package nl.underkoen.jetbrains.adventofcode.general;

import lombok.Getter;
import nl.underkoen.jetbrains.adventofcode.general.tree.TreeLeaf;

@Getter
public class Day extends TreeLeaf<Year> {
    private final int day;

    public Day(int day, Year year) {
        super(year);
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
}
