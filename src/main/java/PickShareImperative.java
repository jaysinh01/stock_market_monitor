import java.io.IOException;
import java.util.function.Predicate;

public class PickShareImperative {

    public static void main(String[] args) throws IOException {
        final Predicate isPriceLessThan500 = ShareUtil.isPriceLessThan(500);
        ShareInfo highPriced = null;
        for(String symbol : Shares.symbols) {
            ShareInfo shareInfo = ShareUtil.getPrice(symbol);
            if (isPriceLessThan500.test(shareInfo))
                highPriced = ShareUtil.pickHigh(highPriced, shareInfo);
        }
        System.out.println("High priced under $500 is " + highPriced);
    }
}
