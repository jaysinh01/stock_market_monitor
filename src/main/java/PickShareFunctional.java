import java.io.IOException;
import java.math.BigDecimal;
import java.util.Comparator;

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


        return stream.map(this::safeFoo).filter(ShareUtil.isPriceLessThan(500)::test).max(Comparator.comparing(x -> x.price)).get();


    }

}
