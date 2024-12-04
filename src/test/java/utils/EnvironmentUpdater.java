package utils;

import java.io.*;
import java.util.Properties;

public class EnvironmentUpdater {
    private static String fileName = "allure-results/environment.properties";

    private static Properties properties = new Properties();

    public static void typeInfosToEnvironmentVeriablesProperties(){
        try {
            File file = new File(fileName);
            if (file.exists()) {
                try (FileInputStream input = new FileInputStream(file)) {
                    properties.load(input);
                }
            }
            String osPlatform = System.getProperty("os.name").toLowerCase();
            String osVersion = System.getProperty("os.version");
            String osRelease = getOsRelease();
            String javaVersion = System.getProperty("java.version");

            properties.setProperty("os_platform", osPlatform);
            properties.setProperty("os_release", osRelease);
            properties.setProperty("os_version", osVersion);
            properties.setProperty("java_version", javaVersion);

            try (FileOutputStream output = new FileOutputStream(fileName)) {
                properties.store(output, "Environment Properties");
                System.out.println("Bilgiler başarıyla eklendi: " + fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getOsRelease() {
        try {
            ProcessBuilder builder = new ProcessBuilder("uname", "-r");
            Process process = builder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "unknown";
    }
}
