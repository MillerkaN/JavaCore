package Lesson8;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.sql.*;

public class WeatherParsing {
    private static final String PROTOKOL = "https";
    private static final String BASE_HOST = "api.weather.yandex.ru";
    private static final String API_V2 = "v2";
    private static final String LAT = "lat";
    private static final String LON = "lon";
    private static final String SPB_LAT = "59.9386";
    private static final String SPB_LON = "30.3141";
    private static final String LANG = "lang";
    private static final String LANG_RU = "ru_RU";
    private static final String LIMIT = "limit";
    private static final String HOURS = "hours";
    private static final String EXTRA = "extra";
    private static final String FORECAST = "forecast";
    private static final String API_KEY = "11262f36-a94f-4b1d-ad6f-924c55e13a65";
    private static final String API_HEADER = "X-Yandex-API-Key";
    private static final String DAY_TEMP_AVG = "/parts/day/temp_avg";
    private static final String DATE = "/date";
    private static final String INSERT_WEATHER = "insert into weather (date, city, dayTemperature) values (?, ?, ?)";
    private static final String EXECUTE_QUERY = "select * from weather";

    public static void main(String[] args) throws IOException, SQLException {
        OkHttpClient okHttpClient = new OkHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        Connection connection = null;
        Statement statement = null;
        PreparedStatement saveWeather = null;

        HttpUrl url = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(API_V2)
                .addPathSegment(FORECAST)
                .addQueryParameter(LAT, SPB_LAT)
                .addQueryParameter(LON, SPB_LON)
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
        String todayDate = today.at(DATE).asText();
        String todayDayTemp = today.at(DAY_TEMP_AVG).asText();
        String tomorrowDate = tomorrow.at(DATE).asText();
        String tomorrowDayTemp = tomorrow.at(DAY_TEMP_AVG).asText();

        System.out.println("Сегодня " + todayDate + ". Дневная температура воздуха в городе " + city + " "
                + todayDayTemp + " градусов.");
        System.out.println("Завтра будет " + tomorrowDate + ". Дневная температура воздуха в городе " + city
                + " будет " + tomorrowDayTemp + " градусов.");

        System.out.println();

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:geekbrains.db");
            saveWeather = connection.prepareStatement(INSERT_WEATHER);
            saveWeather.setString(1, todayDate);
            saveWeather.setString(2, city);
            saveWeather.setString(3, todayDayTemp);
            saveWeather.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:geekbrains.db");
            Statement statement1 = connection.createStatement();
            ResultSet resultSet = statement1.executeQuery(EXECUTE_QUERY);
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("id"));
                System.out.print(" ");
                System.out.print(resultSet.getString("date"));
                System.out.print(" ");
                System.out.print(resultSet.getString("city"));
                System.out.print(" ");
                System.out.println(resultSet.getString("dayTemperature"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
//Первый вариант выполнения домашнего задания
//Продолжить развивать проект из 6 дз, где вы делали запросы к погодному api.
// В 7 уроке распарсили ответ от сервера и вывели в консоль в читабельном виде с помощью jackson,
// тут же надо подключить sqlLite к проекту и сохранить данные в базе на ваше усмотрение.
// Также считать сохраненные данные из базы данных.