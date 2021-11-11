package hellocucumber;

import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Items {

    @JsonProperty("quantity")
    public int quantity;

    @JsonProperty("goods")
    public Goods goods;


    @Override
    public String toString() {
        return "Items{" +
                "quantity=" + quantity +
                "goods=" + goods +
                '}';
    }
}
