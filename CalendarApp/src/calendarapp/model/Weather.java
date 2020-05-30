package calendarapp.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Weather {

    private final HashMap<Integer, ArrayList<String>> dayHashMap;

    public Weather() {
        dayHashMap = new HashMap<>();
        try {
            populateHashMap();
        } catch (IOException | JSONException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void populateHashMap() throws IOException, JSONException {
        JSONObject weatherJson = readJSONFromUrl("http://dataservice.accuweather.com/forecasts/v1/daily/5day/335315?apikey=CyMC943SS5frBXf4EsU2E1Z7KyADxiPV");
        JSONArray weatherJSONArray = (JSONArray) weatherJson.get("DailyForecasts");
        for (int i = 0; i < weatherJSONArray.length(); i++) {
            ArrayList<String> values = new ArrayList<>();
            JSONObject dayNumber = (JSONObject) weatherJSONArray.get(i);

            JSONObject temperature = (JSONObject) dayNumber.get("Temperature");
            JSONObject minimum = (JSONObject) temperature.get("Minimum");
            values.add(minimum.get("Value").toString());
            JSONObject maximum = (JSONObject) temperature.get("Maximum");
            values.add(maximum.get("Value").toString());

            JSONObject day = (JSONObject) dayNumber.get("Day");
            values.add(day.get("Icon").toString());
            dayHashMap.put(i, values);
        }
    }

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private JSONObject readJSONFromUrl(String url) throws IOException, JSONException {
        try (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        }
    }

    public HashMap<Integer, ArrayList<String>> getDayHashMap() {
        return dayHashMap;
    }
}
