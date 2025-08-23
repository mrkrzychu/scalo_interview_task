package org.example;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Main {
    public static void main(String[] args) throws Exception {
        // Load list of cities from file
        List<String> cities = Files.readAllLines(Paths.get("src\\main\\resources\\cities.txt"));

        // Choose a random city
        Random rand = new Random();
        String city = cities.get(rand.nextInt(cities.size()));
        System.out.println("Selected city: " + city);

        // Initialize Playwright and open browser
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            // Navigate to the weather website
            page.navigate("https://meteo.imgw.pl/");

            // Search for the city
            page.locator("input[role='searchbox']").first().fill(city);
            page.keyboard().press("Enter");

            // Wait for the results to load and get the temperature
            page.waitForSelector(".temperature--font");
            String temperature = page.locator(".temperature--font").innerText();

            System.out.println("Current temperature in " + city + ": " + temperature);

            browser.close();
        }
    }
}
