import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.jupiter.api.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UniRestTest extends SetStoreBody{
    public static Store store;
    public static String URI = "";

    public UniRestTest() {

        store = generateOrder();
        URI = "https://petstore.swagger.io/v2/store/";
    }

    @Test
    @PostMapping
    @Order(1)
    public void postOrderTest() throws UnirestException, JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(store);

        HttpResponse<String> response =
                Unirest
                        .post(URI+"order")
                        .header("Content-Type","application/json")
                        .body(jsonString)
                        .asString();

        assertEquals(200,response.getStatus());
    }

    @Test
    @Order(2)
    @GetMapping
    public void getOrderByIdTest() throws UnirestException {
        store = generateOrder();
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest
                        .get(URI+"order/" + store.getId())
                        .header("accept", "application/json")
                        .asString();

        assertEquals(200,response.getStatus());
    }

    @Test
    @Order(3)
    @DeleteMapping
    public void deleteOrderTest() throws UnirestException{

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.delete(URI+"order/" + store.getId())
                .asString();

        assertEquals(200,response.getStatus());
    }

    @Test
    @Order(4)
    @GetMapping
    public void getInventoryTest() throws UnirestException {

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest
                .get(URI+"inventory")
                .asString();

        assertEquals(200,response.getStatus());
    }
}
