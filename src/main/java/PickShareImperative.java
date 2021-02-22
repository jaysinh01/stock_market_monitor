import java.io.IOException;
import java.util.function.Predicate;

public class PickShareImperative {

    public static void main(String[] args) throws IOException {
        // Due to the API 5 calls per minute quota. Run each of the following header sections separately,
        // by commenting them out one at a time.

        PickShareFunctional stockInfo = new PickShareFunctional();
        //--------------- Using stream --------------------------
        long startTimeStream = System.nanoTime();

        System.out.println(stockInfo.findHighPrices(Shares.symbols.stream()));
        long endTimeStream = System.nanoTime(); //TIME: on AVG 4200 milliseconds (Based on 10 trials)

        System.out.print("Stream time: ");
        System.out.println((endTimeStream - startTimeStream)/1000000);

        //-------------- Using parallel stream --------------------

        long startTimeParallel = System.nanoTime();

        System.out.println(stockInfo.findHighPrices(Shares.symbols.parallelStream()));

        long endTimeParallel = System.nanoTime(); //TIME: on AVG 850 milliseconds (Based on 10 trials)
        System.out.print("Parallel stream time: ");
        System.out.println((endTimeParallel - startTimeParallel)/1000000);

        // Reason for parallel stream being faster: Parallel stream incorporates parallel processing on multiple cpu cores.
        // Hence the process of task is distributed, this will enhance scheduling and essentially the program threads will
        // get more cpu time than a single core execution.

    }
}
