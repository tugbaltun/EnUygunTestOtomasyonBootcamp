import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import java.util.Locale;

public class SetStoreBody {

    private static Faker faker;
    FakeValuesService fakeValuesService;
    public SetStoreBody(){
        faker = new Faker();
        this.fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
    }

    public Store generateOrder(){
        int id = 96699329;
        int petId = faker.number().randomDigitNotZero();
        int quantity = faker.number().randomDigit();
        String shipDate = fakeValuesService.bothify("####-##-29T13:##:##.####");
        String status = faker.witcher().character();
        boolean complete = true;
        return new Store(id,petId,quantity,shipDate,status,complete);
    }


}
