package rf.country.push.model;

import com.google.gson.Gson;

import jakarta.websocket.EncodeException;
import jakarta.websocket.Encoder;

public class CountryEncoder implements Encoder.Text<Country> {

    private static Gson gson = new Gson();

    @Override
    public String encode(Country country) throws EncodeException {
        return gson.toJson(country);
    }

}
