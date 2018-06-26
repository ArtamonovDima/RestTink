import Helpers.GenerateOrderId;
import ResponsePojo.ResponseInit;
import org.testng.annotations.Test;
import static ApiMethods.ApiMethods.*;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestClass2 {


    @Test(description = "Вызов метода init")
    public void init(){
        String orderId = GenerateOrderId.createOrder(2);
        responseInit2 = initMethod2(orderId);
        assertTrue(responseInit2.getSuccess());
        assertEquals("0", responseInit2.getErrorCode());
        assertEquals("testRegressTwoFiscalCPBank", responseInit2.getTerminalKey());
        assertEquals("NEW", responseInit2.getStatus());
        assertEquals(orderId, responseInit2.getOrderId());
        assertEquals("1000", responseInit2.getAmount());
        System.out.println(responseInit2.getPaymentUrl());
        checkMethodAuthorize(responseInit2, orderId);
    }

    @Test (description = "клик по ссылке PaymentURL")
    public void checkMethodAuthorize(ResponseInit responseInit2, String orderId){
        System.out.println(responseInit2.getPaymentUrl());
        given().when().get(responseInit2.getPaymentUrl()).then().statusCode(200);
        testFinishAuthorize(responseInit2, orderId);
    }

    @Test
    public void testFinishAuthorize(ResponseInit responseInit2, String orderId){
        resp2 = finishAuthorize("testRegressTwoFiscalCPBank", responseInit2);
        System.out.println(resp2.asString());
        assertTrue(resp2.asString().contains("https://rest-api-test.tcsbank.ru/html/payForm/success.html"));
        testConfirm(responseInit2, orderId);
    }

    @Test
    public void testConfirm(ResponseInit responseInit2, String orderId){
        responseConfirm = confirm(responseInit2);
        assertTrue(responseConfirm.isSuccess());
        assertEquals("0", responseConfirm.getErrorCode());
        assertEquals("testRegressTwoFiscalCPBank", responseConfirm.getTerminalKey());
        assertEquals("CONFIRMED", responseConfirm.getStatus());
        assertEquals(responseInit2.getPaymentId(), responseConfirm.getPaymentId());
        assertEquals(orderId, responseConfirm.getOrderId());
        testState(responseInit2, orderId);
        }

    @Test
    public void testState(ResponseInit responseInit2, String orderId){
        responseState2 = getState2(responseInit2);
        assertTrue(responseState2.getSuccess());
        assertEquals("0", responseState2.getErrorCode());
        assertEquals("OK", responseState2.getMessage());
        assertEquals("testRegressTwoFiscalCPBank", responseState2.getTerminalKey());
        assertEquals("CONFIRMED", responseState2.getStatus());
        //assertEquals(responseInit.getPaymentId(), responseState2.getPaymentId());
        assertEquals(orderId, responseState2.getOrderId());
        assertEquals("1000", responseState2.getAmount());
    }


}
