
import ResponsePojo.ResponseInit;
import org.testng.annotations.Test;
import static ApiMethods.ApiMethods.*;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class TestClass {



        @Test(description = "Вызов метода init")
        public void init(){
            responseInit = initMethod();
            assertTrue(responseInit.getSuccess());
            assertEquals("0", responseInit.getErrorCode());
            assertEquals("testRegressBank", responseInit.getTerminalKey());
            assertEquals("NEW", responseInit.getStatus());
            assertEquals("ch22", responseInit.getOrderId());
            assertEquals("2000", responseInit.getAmount());
            System.out.println(responseInit.toString());
            checkMethodAuthorize(responseInit);
        }

        @Test (description = "клик по ссылке PaymentURL")
        public void checkMethodAuthorize(ResponseInit responseInit){
            System.out.println(responseInit.getPaymentUrl());
            given().when().get(responseInit.getPaymentUrl()).then().statusCode(200);
            testFinishAuthorize(responseInit);
        }

        @Test
        public void testFinishAuthorize(ResponseInit responseInit){
            resp = finishAuthorize("testRegressBank", responseInit);
            System.out.println(resp.asString());
            assertTrue(resp.asString().contains("https://rest-api-test.tinkoff.ru/html/payForm/success.html"));
            testState(responseInit);
        }

        @Test
        public void testState(ResponseInit responseInit){
            responseState = getState(responseInit);
            assertTrue(responseState.getSuccess());
            assertEquals("0", responseState.getErrorCode());
            assertEquals("OK", responseState.getMessage());
            assertEquals("testRegressBank", responseState.getTerminalKey());
            assertEquals("CONFIRMED", responseState.getStatus());
            assertEquals(responseInit.getPaymentId(), responseState.getPaymentId());
            assertEquals("ch22", responseState.getOrderId());
            assertEquals("2000", responseState.getAmount());
            }

}
