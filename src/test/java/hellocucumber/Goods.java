package hellocucumber;

import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Goods {
    public Goods(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "idI=" + id +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", price_pcs='" + price_pcs + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getPrice_pcs() {
        return price_pcs;
    }

    @JsonProperty("id")
    int id;
    @JsonProperty("title")
    String title;
    @JsonProperty("price")
    String price;
    @JsonProperty("price_pcs")
    String price_pcs;
}
