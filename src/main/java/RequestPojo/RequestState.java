package RequestPojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestState {
    @JsonProperty("TerminalKey")
    private String terminalKey;
    @JsonProperty("PaymentId")
    private String paymentId;
    @JsonProperty("Token")
    private String token;



    public RequestState(String terminalKey, String paymentId, String token){
        this.terminalKey=terminalKey;
        this.paymentId=paymentId;
        this.token=token;
    }
}
