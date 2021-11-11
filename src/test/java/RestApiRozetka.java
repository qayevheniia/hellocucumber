import com.google.gson.Gson;
import hellocucumber.Basket;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class RestApiRozetka {

    String cookie = "ab-cart-se=new; xab_segment=90; slang=ru; af_source=adwords; af_sources={\"adwords\":[\"1636490052\",\"0\"]}; uid=rB4eBmGK20UA3Ef+dcoXAg==; visitor_city=1; _gcl_au=1.1.1654239370.1636490059; _gcl_aw=GCL.1636490059.CjwKCAiA1aiMBhAUEiwACw25MRCMF-iReF-2qlXrZcfE9cOLZiRwggFvBauRiTE2QaLQISz_Kdf3MhoC1rQQAvD_BwE; afclid=32717867621636490059; utm_source=adwords; _ga=GA1.3.1988932885.1636490059; _gid=GA1.3.2036784743.1636490059; _gac_UA-203518-6=1.1636490059.CjwKCAiA1aiMBhAUEiwACw25MRCMF-iReF-2qlXrZcfE9cOLZiRwggFvBauRiTE2QaLQISz_Kdf3MhoC1rQQAvD_BwE; _uss-csrf=om8QpXB9ZWu0ASOW3IdSmtemJi0/eESxflDuXBH/zJKOmYVb; ussat_exp=1636533260; ussajwt=eyJhbGciOiJSUzI1NiIsImtpZCI6InVzc2F0LnYwIiwidHlwIjoiSldUIn0.eyJkZXRhaWxzIjoiMTdkZWQ0N2YxOGVhM2RlZjFiNmI5MTkzNmZhMDQ4NzY1Y2VjMWVkZTZjY2EzZTMyYmI3MTgzZjgyZWYxZDU1MzZjNmI0Y2JiZWQzYjEzZWZiZjA5YzIxMjhkZjFlZDdkZTFlN2U4OTA4NWQ3MTQ3MGY0ZDE3ZDQ2ZTk4OWYzZmNlY2U5NTg5YzZmMGIwNzdkZjlmN2VmMTkwMWQ0NTYwMjhkODIyZDA2ZThhMzg2NzBmMjE4OGYzYTgxMjAwMDY1N2NmMDJhN2ZjZGM5NjE0YWU1OWFhNTI2YzA5NzJhN2E4ODkzZTM4MmE0N2EwNjdhM2Q4YmI1NmVmZTUzNTBmZCIsImV4cCI6IjE2MzY1MzMyNjAiLCJ1c3NhdCI6IjVjNzg0NjQ0ODgzYjMxYTkzNDgyODE4OGE0YWQ2MTlkLnVhLTdmMzY4NGJjMjEwMzVhNzMxNjQzYzA5NDU5MDllODUzLjE2MzY1MzMyNjAifQ.FmPC0-nC4Cdzg8tM0IZhTyS7d1LetgwRljaGNhvZ5pDLQ9APnfM-XXVh_smMwVNjpx3c7AN31foAobRjjonBzzp9h4BV390ZdISCfVW4WcPWjirTM9sjUdqu88Hl8tLFtJsJmAsPPIBZwIAPm1j_hKyr--iCee8K7u48jnUKQle83kJS92KVQC-78c9kSfIwSpbFyJKzyOM6vg__YKdCdwZM8XgYdOaUtUTBbcvlTn1qyrl0bq4jHwP1RVpRL9qWvossB9aXFOClRQRO0wBDZyBpTERN98Bipl6iRqLXSwQX1sx53WFYva7OKbyuG_RNWhhwZ2fJSkR0SbQoxLoupQ; ussat=5c784644883b31a934828188a4ad619d.ua-7f3684bc21035a731643c0945909e853.1636533260; ussrt=1c1bbcc8425ffc18798d3be83958636b.ua-7f3684bc21035a731643c0945909e853.1639082060; ussapp=CzTK5ZHN2avfTHtKee-8icGNPB9Wzicw5pvqoLpA; _dc_gtm_UA-203518-6=1; _fbp=fb.2.1636490059828.1960418001; __exponea_etc__=06f16644-ec04-4127-b16f-3665b607ec52; __exponea_time2__=0.6869595050811768; __utmz_gtm=utmcsr=google|utmccn=(none)|utmcmd=organic; var_block=old; cto_bundle=C5lNnl9IY3Z6MXg5SmFtQjBUSzAzTVdNYXNHJTJCRjNtQzliWkVDelZCYWNtSENWR0Y5OFYlMkZQd1U5YXZOa0NtTkNPWlpQd0gzZ1ZUa2tEWFdZSHhIU0tYZFJuMGttd0g2eTM5d2VCc3hVeSUyRkR1SGJKNXJDS3FFZ0tnaDhoeDZ2NVhINjY0S2VJdndmUVlWUnJxTzBXdm9sbkFSaEElM0QlM0Q";
    String tempraryToken = "om8QpXB9ZWu0ASOW3IdSmtemJi0/eESxflDuXBH/zJKOmYVb";
    int quantity =2;
    int goods_id = 296932928;

    @Test
    public void JsonPost() {

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-Type","application/json");
        requestSpecification.header("Cookie",cookie);
        requestSpecification.header("Csrf-Token", tempraryToken);

        JSONObject requestBody = new JSONObject();
        requestBody.put("goods_id", goods_id);
        requestBody.put("quantity", quantity);
        System.out.println(requestBody);

        requestSpecification.body("["+requestBody +"]");
        Response response = requestSpecification.post("https://uss.rozetka.com.ua/session/cart-se/add");
        response.then()
                .statusCode(200)
                 .body("purchases.goods[0].quantity", equalTo(2))
                 .body("purchases.goods[0].goods.id", equalTo(296932928));

//        response.body().print();

        String res = response.body().asString().replaceFirst("goods", "items");
//        System.out.println(request);



        Gson gson = new Gson();
        Basket result = gson.fromJson((res), Basket.class);

        System.out.println(result.quantity);
        Assert.assertTrue(result.quantity==quantity);

        System.out.println(result.purchases.items.get(0).goods);
        Assert.assertTrue(result.purchases.items.get(0).goods.getId()==goods_id);





//        ResponseSpecification responseSpec = new ResponseSpecBuilder()
//                .expectStatusCode(200)
//                .expectBody(containsString("success"))
//                .build();
    }
    }

