package utils;

import base.Base;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.input.SwappedDataInputStream;
import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.print.DocFlavor;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static base.Base.driver;
import static base.Base.wait;

public class LocatorManager{
    private static String dir = "src/test/resources";
    private static File file = new File(dir);
    private static List<File> files = Arrays.asList(file.listFiles());
    private static List<File> jsonFiles = files.stream().filter(file1 -> file1.toString().endsWith(".json")).toList();
    private static ObjectMapper objectMapper = new ObjectMapper();

    protected static JsonNode getJsonNode(String searchedKey) throws IOException {
        for (File file : jsonFiles){
            JsonNode nodes = objectMapper.readTree(file);
            for (JsonNode currentNode : nodes){
                if (currentNode.get("key").asText().contains(searchedKey)){
                    return currentNode;
                }
            }
        }
        return null;
    }
}