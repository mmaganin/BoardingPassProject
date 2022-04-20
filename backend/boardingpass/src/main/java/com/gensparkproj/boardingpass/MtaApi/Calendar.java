import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public record Calendar(
        String service_id,
        Set<DayOfWeek> days,
        LocalDate start_date,
        LocalDate end_date
) {
    public Calendar(String[] args) {
        this(args[0], getDays(args), getDate(args[8]), getDate(args[9]));
    }

    private static Set<DayOfWeek> getDays(String[] toParse) {
        Set<DayOfWeek> toReturn = new HashSet<>();
        for(int i = 1; i <= 7; i++) {
            if(toParse[i].equals("1"))
                toReturn.add(DayOfWeek.of(i));
        }
        return toReturn;
    }

    private static LocalDate getDate(String toParse) {
        return LocalDate.of(
                Integer.parseInt(toParse.substring(0, 4)),
                Integer.parseInt(toParse.substring(4, 6)),
                Integer.parseInt(toParse.substring(6, 8))
        );
    }
}
