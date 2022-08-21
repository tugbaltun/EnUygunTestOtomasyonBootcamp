import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HttpEntityTest extends SetStoreBody{

    public static Store store;
    public static HttpHeaders headers;
    public static RestTemplate restTemplate;
    public static ObjectMapper objectMapper;
    JSONObject jsonObject;

    public static String URI = "";

    public HttpEntityTest(){
        URI = "https://petstore.swagger.io/v2/store/";
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        restTemplate = new RestTemplate();
        store = generateOrder();
        objectMapper = new ObjectMapper();
        store = generateOrder();
        jsonObject = new JSONObject();
    }

    @Order(1)
    @PostMapping
    @Test
    public void postOrderTest() {

        HttpEntity<Store> request =
                new HttpEntity<>(store, headers);

        String resultAsJson =
                restTemplate.postForObject(
                        URI+"order",
                        request,
                        String.class,
                        HttpMethod.POST);

        Assertions.assertNotNull(resultAsJson);
    }

    @Test
    @Order(2)
    @GetMapping
    public void getOrderByIdTest() throws JsonProcessingException {

        String resultAsJson = restTemplate.getForObject(
                URI+"order/"+store.getId(),
                String.class,
                HttpMethod.GET);

        JsonNode root = objectMapper.readTree(resultAsJson);
        Assertions.assertNotNull(root);
    }

    @Test
    @Order(3)
    @DeleteMapping
    public void deleteOrderTest() throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> httpEntity = new HttpEntity<>(jsonObject.toString(), headers);
        String res = restTemplate.exchange(
                URI+"order/"+store.getId(),
                HttpMethod.DELETE,
                httpEntity,
                String.class
        ).getBody();

        JsonNode msgResponse = objectMapper.readTree(res);
        Assertions.assertNotNull(msgResponse);
    }

    @Test
    @Order(4)
    @GetMapping
    public void getInventoryTest() throws JsonProcessingException {

        HttpEntity<String> httpEntity = new HttpEntity<>(jsonObject.toString(), headers);
        String res = restTemplate.exchange(URI+"inventory", HttpMethod.GET, httpEntity, String.class).getBody();

        JsonNode msgResponse = objectMapper.readTree(res);
        Assertions.assertNotNull(msgResponse);
        System.out.println(msgResponse);
    }
}
