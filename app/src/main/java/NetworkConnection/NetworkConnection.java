package NetworkConnection;

import android.util.Log;


import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkConnection {

    private static final String BASE_URL = "https://api.mapbox.com/geocoding/v5/mapbox.places/";

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private OkHttpClient client = null;
    private String results;

    public NetworkConnection () {
        client = new OkHttpClient();
    }

    public String searchDestination(String query, String params) {
        String methodPath = query.replace(" ", "%20") + ".json?autocomplete=true&limit=10&country=au&" + params + "&access_token=" + "pk.eyJ1IjoiZGV1Y2VzIiwiYSI6ImNrMjNubXNjMjB4aTkzYnBnMDhpbHY1ZmMifQ._627JhEDFJdUWPCf9NrLxA";
        Request.Builder builder = new Request.Builder();
        builder.url(BASE_URL + methodPath);
        Log.i("Hello", BASE_URL + methodPath);
        Request request = builder.build();

        try {
            Response response = client.newCall(request).execute();
            results = response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }


}
