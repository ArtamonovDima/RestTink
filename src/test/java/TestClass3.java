import Helpers.GenerateOrderId;
import org.testng.annotations.Test;

import static ApiMethods.ApiMethods.*;
import static ApiMethods.ApiMethods.responseState2;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestClass3 {

    @Test
    public void test(){
        String orderId = GenerateOrderId.createOrder(2);
        responseInit2 = initMethod2(orderId);

        assertTrue(responseInit2.getSuccess());
        assertEquals("0", responseInit2.getErrorCode());
        assertEquals("testRegressTwoFiscalCPBank", responseInit2.getTerminalKey());
        assertEquals("NEW", responseInit2.getStatus());
        assertEquals(orderId, responseInit2.getOrderId());
        assertEquals("1000", responseInit2.getAmount());
          System.out.println(responseInit2.getPaymentUrl());
        given().when().get(responseInit2.getPaymentUrl()).then().statusCode(200);
          System.out.println(responseInit2.getPaymentUrl());

        resp2 = finishAuthorize("testRegressTwoFiscalCPBank", responseInit2);
        System.out.println(resp2.asString());
        assertTrue(resp2.asString().contains("https://rest-api-test.tcsbank.ru/html/payForm/success.html"));


        responseConfirm = confirm(responseInit2);
        assertTrue(responseConfirm.isSuccess());
        assertEquals("0", responseConfirm.getErrorCode());
        assertEquals("testRegressTwoFiscalCPBank", responseConfirm.getTerminalKey());
        System.out.println(responseConfirm.getStatus());
        assertEquals("CONFIRMED", responseConfirm.getStatus());
        assertEquals(responseInit2.getPaymentId(), responseConfirm.getPaymentId());
        assertEquals(orderId, responseConfirm.getOrderId());

        responseState2 = getState2(responseInit2);
        assertTrue(responseState2.getSuccess());
        assertEquals("0", responseState2.getErrorCode());
        System.out.println(responseState2.getMessage());
        assertEquals("OK", responseState2.getMessage());
        assertEquals("testRegressTwoFiscalCPBank", responseState2.getTerminalKey());
        assertEquals("CONFIRMED", responseState2.getStatus());
        //assertEquals(responseInit.getPaymentId(), responseState2.getPaymentId());
        assertEquals(orderId, responseState2.getOrderId());
        assertEquals("1000", responseState2.getAmount());

    }
}
