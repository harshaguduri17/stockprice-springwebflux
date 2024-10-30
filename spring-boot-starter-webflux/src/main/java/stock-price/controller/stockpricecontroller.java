@RestController
public class StockPriceController {

    @GetMapping("/stocks/{symbol}")
    public Flux<StockPrice> getStockPrices(@PathVariable String symbol) {
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> new StockPrice(symbol, (int) (Math.random() * 100)));
    }

    record StockPrice(String symbol, int price) {}
}