package RequestPojo;

import RequestPojo.initValues.Receipt;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestInit {

    @JsonProperty("TerminalKey")
    private String terminalKey;
    @JsonProperty("Amount")
    private String amount;
    @JsonProperty("OrderId")
    private String orderId;
    @JsonProperty ("Receipt")
    private Receipt receipt;

    public RequestInit (String terminalKey, String amount, String orderId){
        this.terminalKey=terminalKey;
        this.amount=amount;
        this.orderId=orderId;
    }

    public RequestInit(String terminalKey, String amount, String orderId, Receipt receipt){
        this.terminalKey = terminalKey;
        this.amount = amount;
        this.orderId = orderId;
        this.receipt = receipt;
    }


}
