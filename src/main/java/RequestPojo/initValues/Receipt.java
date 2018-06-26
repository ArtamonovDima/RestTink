package RequestPojo.initValues;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Receipt {

    @JsonProperty ("Email")
    private String email;
    @JsonProperty ("Taxation")
    private String taxation;
    @JsonProperty ("Items")
    private List<Items> items;

    public Receipt(String email, String taxation, List<Items> items){
        this.email = email;
        this.taxation = taxation;
        this.items = items;
    }
}
