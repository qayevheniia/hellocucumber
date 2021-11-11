package hellocucumber;

import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonProperty;

//}
public class Cost {

    @Override
    public String toString() {
        return "Cost{" +
                "old_price=" + old_price +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }

    @JsonProperty("old_prices")
    public int old_price;
    @JsonProperty("price")
    public int price;
    @JsonProperty("discount")
    public int discount;
}
