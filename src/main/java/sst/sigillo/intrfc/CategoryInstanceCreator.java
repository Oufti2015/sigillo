package sst.sigillo.intrfc;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import sst.sigillo.model.Category;
import sst.sigillo.model.SigilloModel;

class CategoryInstanceCreator implements JsonDeserializer<Category> {

    @Override
    public Category deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
	JsonElement name = json.getAsJsonObject().get("name");
	return SigilloModel.getInstance().getCategoryByName(name.getAsString());
    }
}
