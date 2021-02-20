import java.io.IOException;
import java.util.function.Predicate;

public class PickShareImperative {

    public static void main(String[] args) throws IOException {
        final Predicate isPriceLessThan500 = ShareUtil.isPriceLessThan(500);
        ShareInfo highPriced = ShareUtil.getPrice(Shares.symbols.get(0));
        for(String symbol : Shares.symbols) {
            ShareInfo shareInfo = ShareUtil.getPrice(symbol);
            if (isPriceLessThan500.test(shareInfo))
                highPriced = ShareUtil.pickHigh(highPriced, shareInfo);
        }

        System.out.println("High priced under $500 is " + highPriced);

        //final Predicate isPriceLessThan1000 = ShareUtil.isPriceLessThan(1000);
//        Shares.symbols.stream().allMatch(isPriceLessThan1000::test);

//        PickShareFunctional dummy = new PickShareFunctional();
//        dummy.findHighPrices(Shares.symbols.stream());
    }
}
