package hellocucumber;

import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Purchases {
    @Override
    public String toString() {
        return "Purchases{" +
                "items=" + items +
                '}';
    }

    @JsonProperty("items")
    public List<Items> items;

}
