import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import static io.restassured.RestAssured.given;


@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RestAssuredTest extends SetStoreBody{

    Response response;
    public static Store store;
    public static String URI = "";


    public RestAssuredTest() {

        store = generateOrder();
        URI = "https://petstore.swagger.io/v2/store/";
    }

    @Test
    @Order(1)
    @PostMapping
    public void postOrderTest() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(store);

        this.response =
                given().
                        log().all().
                        accept(ContentType.JSON).
                        header("Content-Type","application/json").
                        header("Connection","keep-alive").
                        body(jsonString).
                        when().
                        post(URI+"order");

        this.response.
                then().
                log().all().
                statusCode(200);

        Assertions.assertEquals(200, response.getStatusCode());

    }

    @Test
    @Order(2)
    @GetMapping
    public void getOrderByIdTest(){
        this.response =
                given().
                        log().all().
                        accept(ContentType.JSON).
                        header("Content-Type","application/json").
                        header("Connection","keep-alive").
                        param("id",5858).
                        param("complete",true).
                        get(URI+"order/"+store.getId());


        this.response.
                then().
                log().all().
                statusCode(200);

        Assertions.assertEquals(200, response.getStatusCode());
    }

    @Order(3)
    @Test
    public void deleteOrderTest(){
        this.response =
                given().
                        log().all().
                        accept(ContentType.JSON).
                        header("Content-Type","application/json").
                        header("Connection","keep-alive").
                        delete(URI+"order/"+store.getId());

        this.response.
                then().
                log().all().
                statusCode(200);

        Assertions.assertEquals(200, response.getStatusCode());
    }

    @Test
    @Order(4)
    @GetMapping
    public void getInventoryTest(){
        this.response =
                given().
                        log().all().
                        accept(ContentType.JSON).
                        header("Content-Type","application/json").
                        header("Connection","keep-alive").
                        get(URI+"inventory");
        this.response.
                then().
                log().all().
                statusCode(200);

        Assertions.assertEquals(200, response.getStatusCode());

    }
}
