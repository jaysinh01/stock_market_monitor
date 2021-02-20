import java.io.IOException;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PickShareFunctional {

    //https://stackoverflow.com/a/23548793/10861074
    private ShareInfo safeFoo(final String a) {
        try {
            return ShareUtil.getPrice(a);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public ShareInfo findHighPrices(Stream<String> stream){
////        1- Create a list of ​ShareInfo​ filled with the price for each of the symbols in ​Share
//        List<ShareInfo> shareInfos = stream.map(this::safeFoo).collect(Collectors.toList());
//        System.out.println(shareInfos);
////        2- Trim down this list to a list of shares whose prices under $500
//        final Predicate isPriceLessThan1000 = ShareUtil.isPriceLessThan(1000);
//        List<ShareInfo> trimmedDown = shareInfos.stream().filter(isPriceLessThan1000::test).collect(Collectors.toList());
////        3- Return the highest-priced share.
//       // ShareInfo share = trimmedDown.sort(Comparator.comparing(ShareInfo -> ShareInfo.price));
//        trimmedDown.sort(Comparator.comparing(x -> x.price));
//        ShareInfo share = trimmedDown.get(trimmedDown.size() - 1);
//        System.out.println(share);

        final Predicate isPriceLessThan1000 = ShareUtil.isPriceLessThan(4000);
        return stream.map(this::safeFoo).filter(isPriceLessThan1000::test).max(Comparator.comparing(x -> x.price)).get();


    }

}
