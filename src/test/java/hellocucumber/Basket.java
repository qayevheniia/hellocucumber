package hellocucumber;

import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Basket {


    @JsonProperty("purchases")
    public Purchases purchases;
    @JsonProperty("cost")
    public Cost cost;
    @JsonProperty("quantity")
    public int quantity;

    @Override
    public String toString() {
        return "Basket{" +
                "purchases=" + purchases +
                ", quantity='" + quantity + '\'' +
                ", cost=" + cost + '\'' +
                '}';
    }
}


