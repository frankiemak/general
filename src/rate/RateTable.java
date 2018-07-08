package rate;

import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;

public interface RateTable {

	public Double getRate(JSONObject obj) throws JSONException, ParseException;

}