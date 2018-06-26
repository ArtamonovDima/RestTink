package RequestPojo.initValues;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Items {

    @JsonProperty ("Name")
    private String name;
    @JsonProperty ("Price")
    private String price;
    @JsonProperty ("Quantity")
    private String quantity;
    @JsonProperty ("Amount")
    private String amount;
    @JsonProperty ("Tax")
    private String tax;

    public Items(String name, String price, String quantity, String amount, String tax){
    this.name = name;
    this.price = price;
    this.quantity = quantity;
    this.amount = amount;
    this.tax = tax;
    }


}
