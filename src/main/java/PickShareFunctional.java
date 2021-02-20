import java.io.IOException;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PickShareFunctional {

    public static <T> T uncheckCall(Callable<T> callable) {
        try {
            return callable.call();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void findHighPrices(Stream<String> stream){
//        1- Create a list of ​ShareInfo​ filled with the price for each of the symbols in ​Share
        List<ShareInfo> shareInfos = stream.map(x -> ShareUtil.getPrice(x)).collect(Collectors.toList());

        System.out.println(shareInfos);
//        2- Trim down this list to a list of shares whose prices under $500
        final Predicate isPriceLessThan500 = ShareUtil.isPriceLessThan(500);
        List<ShareInfo> trimmedDown = shareInfos.stream().filter(isPriceLessThan500::test).collect(Collectors.toList());
//        3- Return the highest-priced share.
       // ShareInfo share = trimmedDown.sort(Comparator.comparing(ShareInfo -> ShareInfo.price));
        trimmedDown.sort(Comparator.comparing(x -> x.price));
        ShareInfo share = trimmedDown.get(0);
        System.out.println(share);

    }

}
