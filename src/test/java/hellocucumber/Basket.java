package hellocucumber;

import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)

@Getter
public class Basket {
    public Basket(int quantity) {
        this.quantity = quantity;
    }

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


