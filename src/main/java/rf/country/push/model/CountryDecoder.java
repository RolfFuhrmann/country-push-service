package rf.country.push.model;

import com.google.gson.Gson;

import jakarta.websocket.DecodeException;
import jakarta.websocket.Decoder;

public class CountryDecoder implements Decoder.Text<Country> {

    private static Gson gson = new Gson();

    @Override
    public Country decode(String s) throws DecodeException {
        return gson.fromJson(s, Country.class);

    }

    @Override
    public boolean willDecode(String country) {
        return (country != null);
    }

}
