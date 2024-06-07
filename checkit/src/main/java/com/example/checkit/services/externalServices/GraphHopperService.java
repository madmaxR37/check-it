package com.example.checkit.services.externalServices;

import com.example.checkit.models.Address;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
@Service
public class GraphHopperService {

    private final RestTemplate restTemplate;

    @Value("${graph.hopper.api-key}")
    private String api_key;

    public GraphHopperService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public float distance(Address addressDpt, Address addressDst) {

        String endpoint = "https://graphhopper.com/api/1/route?";
        String url = endpoint + "point=" +
                addressDpt.getAddressLatitude() +
                "," + addressDpt.getAddressLongitude() + "&point=" +
                addressDst.getAddressLatitude() + "," +
                addressDst.getAddressLongitude() + "&profile=car&key=" +
                api_key;

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url).get().build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody = response.body().string();

                return parseDistance(responseBody);
            } else return (float) 0;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
        private float parseDistance (String responseBody){
            try {
                JSONObject jsonObject = new JSONObject(responseBody);
                JSONArray paths = jsonObject.getJSONArray("paths");
                JSONObject pathObject = paths.getJSONObject(0);
                return pathObject.getFloat("distance");
            } catch (JSONException e) {
                throw new RuntimeException("Failed to parse distance from response", e);
            }
        }


        public Object geoCode(String name){

        String url = "https://graphhopper.com/api/1/geocode?q="+ name+"&key="+api_key;

        return restTemplate.getForObject(url,Object.class);
        }
}
