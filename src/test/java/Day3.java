import org.junit.Test;

import java.util.Collection;
import java.util.stream.Collectors;

public class Day3 {

    @Test
    public void day3_quest2() {
        Collection<String> input = Helper.readFile("day3-input");

        int oxygen = darwin(input, true,'1');
        int co2 = darwin(input, false, '0');

        System.out.println(oxygen*co2);
    }

    private int darwin(Collection<String> elements, boolean majorityWins, char winningBitWhenDraw) {
        int index = 0;

        while(elements.size() > 1) {
            char bitWhichStays = findBitWhichStays(elements, index, majorityWins, winningBitWhenDraw);
            elements = filter(elements, index, bitWhichStays);
            index++;
        }

        String winner = elements.iterator().next();
        return Integer.parseInt(winner, 2);
    }

    private Collection<String> filter(Collection<String> input, int index, char bitWhichStays) {
        return input.stream().filter(element -> element.charAt(index) == bitWhichStays).collect(Collectors.toList());
    }

    private char findBitWhichStays(Collection<String> input, int index, boolean majorityWins, char winningBitWhenDraw) {
        long ones = input.stream().filter(element -> element.charAt(index) == '1').count();
        long zeros = input.size() - ones;

        // oh gosh ...
        if (ones > zeros) {
            if (majorityWins)
                return '1';
            else return '0';
        } else if (zeros > ones) {
            if (majorityWins)
                return '0';
            else return '1';
        } else {
            return winningBitWhenDraw;
        }
    }
}
