package com.manamob.marvel.data.database;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.manamob.marvel.model.Characters;
import com.manamob.marvel.model.Creators;
import com.manamob.marvel.model.Events;
import com.manamob.marvel.model.Image;
import com.manamob.marvel.model.Price;
import com.manamob.marvel.model.Series;
import com.manamob.marvel.model.Stories;
import com.manamob.marvel.model.TextObject;
import com.manamob.marvel.model.Thumbnail;
import com.manamob.marvel.model.Url;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

public class Converters {
    @TypeConverter
    public Date toDate(Long timestamp) {
        if (timestamp == null) {
            return null;
        } else {
            return new Date(timestamp);
        }
    }

    @TypeConverter
    public Long toTimestamp(Date date) {
        return date.getTime();
    }

    //Type converter para lista de String
    @TypeConverter
    public List<String> fromString(String value) {
        Type listType = (Type) new TypeToken<List<String>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromList(List<String> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    //Type converter para Characters
    @TypeConverter
    public Characters fromCharacters(String value) {
        Type listType = (Type) new TypeToken<Characters>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromCharacters(Characters list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }


    //Type converter para Creators
    @TypeConverter
    public Creators fromCreators(String value) {
        Type listType = (Type) new TypeToken<Creators>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromCreators(Creators list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }


    // Type converter para List<Date>
    @TypeConverter
    public List<com.manamob.marvel.model.Date> fromDate(String value) {
        Type listType = (Type) new TypeToken<List<com.manamob.marvel.model.Date>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromDate(List<com.manamob.marvel.model.Date> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }


    //Type converter para Events
    @TypeConverter
    public Events fromEvents(String value) {
        Type listType = (Type) new TypeToken<Events>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromEvents(Events list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }



    // Type converter para List<Image>
    @TypeConverter
    public List<Image> fromImage(String value) {
        Type listType = (Type) new TypeToken<List<Image>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromImage(List<Image> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }



    // Type converter para List<Price>
    @TypeConverter
    public List<Price> fromPrice(String value) {
        Type listType = (Type) new TypeToken<List<Price>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromPrice(List<Price> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }


    //Type converter para Series
    @TypeConverter
    public Series fromSeries(String value) {
        Type listType = (Type) new TypeToken<Series>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromSeries(Series list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }


    //Type converter para Stories
    @TypeConverter
    public Stories fromStories(String value) {
        Type listType = (Type) new TypeToken<Stories>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromStories(Stories list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }


    // Type converter para List<Price>
    @TypeConverter
    public List<TextObject> fromTextObject(String value) {
        Type listType = (Type) new TypeToken<List<TextObject>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromTextObject(List<TextObject> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }


    //Type converter para Thumbnail
    @TypeConverter
    public Thumbnail fromThumbnail(String value) {
        Type listType = (Type) new TypeToken<Thumbnail>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromThumbnail(Thumbnail list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    // Type converter para List<Url>
    @TypeConverter
    public List<Url> fromUrl(String value) {
        Type listType = (Type) new TypeToken<List<Url>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromUrl(List<Url> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    // Type converter para List<Object>
    @TypeConverter
    public List<Object> fromObject(String value) {
        Type listType = (Type) new TypeToken<List<Object>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromObject(List<Object> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }
}
