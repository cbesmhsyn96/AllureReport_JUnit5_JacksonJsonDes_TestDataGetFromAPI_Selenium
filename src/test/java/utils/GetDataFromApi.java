package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

import static utils.PasswordsAndKeys.xApiHubEndPoint;
import static utils.PasswordsAndKeys.xApiHubKey;

public class GetDataFromApi {
    private static CreditCardInfos creditCardInfos;
    private static HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    private static List<CreditCardInfos> getDatasFromCreditCardsApi() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://Faker-API.proxy-production.allthingsdev.co/api/v2/creditCards?_quantity=50"))
                .header("x-apihub-key", xApiHubKey)
                .header("x-apihub-host", "Faker-API.allthingsdev.co")
                .header("x-apihub-endpoint", xApiHubEndPoint)
                .timeout(Duration.ofSeconds(10))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        String jsonResponse = response.body();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonResponse);

        JsonNode dataNode = rootNode.get("data");
        List<CreditCardInfos> creditCards = objectMapper.readValue(dataNode.toString(), objectMapper.getTypeFactory().constructCollectionType(List.class, CreditCardInfos.class));
        return creditCards;
    }

    public static List<String> getExpirationOfCurrentCard() throws IOException, InterruptedException {
        List<CreditCardInfos> creditCardInfos = getDatasFromCreditCardsApi();
        for (CreditCardInfos cardInfo : creditCardInfos) {
            System.out.println(cardInfo.getExpiration());
        }
        return null;
    }

    protected static List<String> getNumberOfCurrentCard() throws IOException, InterruptedException {
        List<CreditCardInfos> creditCardInfos = getDatasFromCreditCardsApi();
        for (CreditCardInfos cardInfo : creditCardInfos) {
            System.out.println(cardInfo.getNumber());
        }
        return null;
    }

    protected static List<String> getOwnerOfCurrentCard() throws IOException, InterruptedException {
        List<CreditCardInfos> creditCardInfos = getDatasFromCreditCardsApi();
        for (CreditCardInfos cardInfo : creditCardInfos) {
            System.out.println(cardInfo.getOwner());
        }
        return null;
    }

    protected static List<String> getTypeOfCurrentCard() throws IOException, InterruptedException {
        List<CreditCardInfos> creditCardInfos = getDatasFromCreditCardsApi();
        for (CreditCardInfos cardInfo : creditCardInfos) {
            System.out.println(cardInfo.getType());
        }
        return null;
    }
}