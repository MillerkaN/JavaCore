package Lesson7;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;

public class WeatherParsing {
    private static final String PROTOKOL = "https";
    private static final String BASE_HOST = "api.weather.yandex.ru";
    private static final String API_V2 = "v2";
    private static final String LAT = "lat";
    private static final String LON = "lon";
    private static final String SPb_LAT = "59.9386";
    private static final String SPb_LON = "30.3141";
    private static final String LANG = "lang";
    private static final String LANG_RU = "ru_RU";
    private static final String LIMIT = "limit";
    private static final String HOURS = "hours";
    private static final String EXTRA = "extra";
    private static final String FORECAST = "forecast";
    private static final String API_KEY = "11262f36-a94f-4b1d-ad6f-924c55e13a65";
    private static final String API_HEADER = "X-Yandex-API-Key";
    private static final String dayAvTemp = "/parts/day/temp_avg";
    private static final String date = "/date";

    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();

        HttpUrl url = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(API_V2)
                .addPathSegment(FORECAST)
                .addQueryParameter(LAT, SPb_LAT)
                .addQueryParameter(LON, SPb_LON)
                .addQueryParameter(LANG, LANG_RU)
                .addQueryParameter(LIMIT, "5")
                .addQueryParameter(HOURS, "false")
                .addQueryParameter(EXTRA, "false")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .addHeader(API_HEADER, API_KEY)
                .get()
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();
        String city = objectMapper.readTree(responseString).at("/geo_object/locality/name").asText();
        JsonNode today = objectMapper.readTree(responseString).at("/forecasts").get(0);
        JsonNode tomorrow = objectMapper.readTree(responseString).at("/forecasts").get(1);
        String todayDate = today.at(date).asText();
        String todayDayTemp = today.at(dayAvTemp).asText();
        String tomorrowDate = tomorrow.at(date).asText();
        String tomorrowDayTemp = tomorrow.at(dayAvTemp).asText();

      System.out.println("Сегодня " + todayDate + ". Дневная температура воздуха в городе " + city + " " + todayDayTemp + " градусов.");
      System.out.println("Завтра будет " + tomorrowDate + ". Дневная температура воздуха в городе " + city + " будет " + tomorrowDayTemp + " градусов.");
    }
}

//Второй вариант выполнения ДЗ - доработать свою программу, выводящую погоду, из 6 урока так, чтобы в консоль
// выводилась информация в читабельном формате на ваше усмотрение - например
// "Сегодня в Санкт-Петербурге 5 градусов тепла". Главное - распарсить json ответ, достать оттуда нужные данные.
