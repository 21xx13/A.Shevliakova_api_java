package com.company;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        //адрес для запроса рандомного факта о котиках
        String apiUrl = "https://cat-fact.herokuapp.com/facts/random?animal_type=cat";

        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL(apiUrl);
            //чтение ответа
            BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream()));
            int read = bf.read();
            while (read > 0) {
                result.append((char) read);
                read = bf.read();
            }
            //получение факта по ключу "text"
            String jsonResult = new JSONObject(result.toString()).get("text").toString();
            //вывод
            System.out.println("Ответ в формате json: " + result.toString()); //вывод полного ответа
            System.out.println("Факт о котиках: " + jsonResult); //вывод отдельного факта
        } catch (Exception ignored) {
        }
    }
}
