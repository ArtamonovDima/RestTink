package RequestPojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestAuthorize {

    @JsonProperty("TerminalKey")
    private String terminalKey;
    @JsonProperty("PaymentId")
    private String paymentId;
    @JsonProperty("CardData")
    private String cardData;



    public RequestAuthorize(String terminalKey, String paymentId, String cardData){
        this.terminalKey=terminalKey;
        this.paymentId=paymentId;
        this.cardData=cardData;
    }
}
