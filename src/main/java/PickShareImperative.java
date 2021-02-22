import java.io.IOException;
import java.util.function.Predicate;

public class PickShareImperative {

    public static void main(String[] args) throws IOException {
//        final Predicate isPriceLessThan500 = ShareUtil.isPriceLessThan(500);
//        ShareInfo highPriced = ShareUtil.getPrice(Shares.symbols.get(0));
//        for(String symbol : Shares.symbols) {
//            ShareInfo shareInfo = ShareUtil.getPrice(symbol);
//            if (isPriceLessThan500.test(shareInfo))
//                highPriced = ShareUtil.pickHigh(highPriced, shareInfo);
//        }

//        System.out.println("High priced under $500 is " + highPriced);

        //final Predicate isPriceLessThan1000 = ShareUtil.isPriceLessThan(1000);
//        Shares.symbols.stream().allMatch(isPriceLessThan1000::test);

        PickShareFunctional dumAss = new PickShareFunctional();
        long startTime = System.nanoTime();

        System.out.println(dumAss.findHighPrices(Shares.symbols.stream()));
        long endTime = System.nanoTime(); //TIME: 3931 milliseconds


//        System.out.println(dumAss.findHighPrices(Shares.symbols.parallelStream()));
//        long endTime = System.nanoTime(); // TIME: 1603 milliseconds


        System.out.println((endTime - startTime)/1000000);
    }
}
