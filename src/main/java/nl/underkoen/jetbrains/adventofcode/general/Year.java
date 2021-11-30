package nl.underkoen.jetbrains.adventofcode.general;

import lombok.Getter;
import nl.underkoen.jetbrains.adventofcode.general.tree.AbstractTreeNode;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Vector;

@Getter
public class Year extends AbstractTreeNode<Day, AdventOfCode> {
    private final int year;

    public Year(int year, AdventOfCode parent) {
        super(parent);
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("Year %s", year);
    }

    @Override
    protected Vector<Day> construct() {
        Vector<Day> days = new Vector<>();

        LocalDateTime dateTime = LocalDateTime.now(ZoneId.of("UTC-5")).plusDays(1);
        int day = 25;
        if (dateTime.getYear() == year) day = Math.min(dateTime.getDayOfMonth(), 25);

        for (int i = 1; i <= day; i++) {
            days.add(new Day(i, this));
        }
        return days;
    }

    public int stars() {
        return getList().stream()
                .mapToInt(Day::stars)
                .sum();
    }

    public String starsText() {
        int stars = stars();
        if (stars == 0) return "";
        return String.format("%02d *", stars);
    }
}
