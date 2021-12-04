package manytomany.customeraccounts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ConfigParser {

    public static LocalDate getLocalData(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(date, formatter);
    }

    public static long generateAccountNumberMathAPI(){
        long maxlong = 999999999999L;
        long minlong = maxlong / 2;
         return  (minlong + (long)(Math.random() * (maxlong - minlong)));

    }

    public static Set<Long> populateHashSet(List<Long> list) {

        return new HashSet<>(list);
    }
}
