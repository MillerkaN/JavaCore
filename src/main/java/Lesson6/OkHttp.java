package Lesson6;

import okhttp3.*;

import java.io.IOException;

public class OkHttp {
    public static final String KEY = "11262f36-a94f-4b1d-ad6f-924c55e13a65";

    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("api.weather.yandex.ru")
                .addPathSegment("v2")
                .addPathSegment("forecast")
                .addQueryParameter("lat", "59.9386")
                .addQueryParameter("lon","30.3141")
                .addQueryParameter("lang","ru_RU")
                .addQueryParameter("limit", "5")
                .addQueryParameter("hours","true")
                .addQueryParameter("extra", "true")
                .build();


        Request request = new Request.Builder()
                .url(url)
                .addHeader("X-Yandex-API-Key", "11262f36-a94f-4b1d-ad6f-924c55e13a65")
                .get()
                .build();

        Response response = okHttpClient.newCall(request).execute();

        System.out.println(response.body().string());
    }
}


//    1 С помощью http запроса получить в виде json строки погоду в Санкт-Петербурге на период времени,
//    пересекающийся со следующим занятием (например, выборка погода на следующие 5 дней - подойдет)
//    2 Подобрать источник самостоятельно. Можно использовать api accuweather, порядок следующий:
//    зарегистрироваться, зарегистрировать тестовое приложение для получения api ключа,
//    найдите нужный endpoint и изучите документацию.
//    Бесплатный тарифный план предполагает получение погоды не более чем на 5 дней вперед
//    (этого достаточно для выполнения д/з).