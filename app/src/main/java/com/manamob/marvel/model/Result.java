
package com.manamob.marvel.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "comics")
public class Result implements Parcelable {

    public Result() {
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo (name = "idComic")
    private long idComic;

    private Characters characters;
    private List<Object> collectedIssues;
    private List<Object> collections;
    private Creators creators;
    private List<Date> dates;
    private String description;
    private String diamondCode;
    private Long digitalId;
    private String ean;
    private Events events;
    private String format;
    private Long id;
    private List<Image> images;
    private String isbn;
    private String issn;
    private Long issueNumber;
    private String modified;
    private Long pageCount;
    private List<Price> prices;
    private String resourceURI;
    private Series series;
    private Stories stories;
    private List<TextObject> textObjects;
    private Thumbnail thumbnail;
    private String title;
    private String upc;
    private List<Url> urls;
    private String variantDescription;
    private List<Object> variants;

    protected Result(Parcel in) {
        characters = in.readParcelable(Characters.class.getClassLoader());
        creators = in.readParcelable(Creators.class.getClassLoader());
        dates = in.createTypedArrayList(Date.CREATOR);
        description = in.readString();
        diamondCode = in.readString();
        if (in.readByte() == 0) {
            digitalId = null;
        } else {
            digitalId = in.readLong();
        }
        ean = in.readString();
        events = in.readParcelable(Events.class.getClassLoader());
        format = in.readString();
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        images = in.createTypedArrayList(Image.CREATOR);
        isbn = in.readString();
        issn = in.readString();
        if (in.readByte() == 0) {
            issueNumber = null;
        } else {
            issueNumber = in.readLong();
        }
        modified = in.readString();
        if (in.readByte() == 0) {
            pageCount = null;
        } else {
            pageCount = in.readLong();
        }
        prices = in.createTypedArrayList(Price.CREATOR);
        resourceURI = in.readString();
        series = in.readParcelable(Series.class.getClassLoader());
        stories = in.readParcelable(Stories.class.getClassLoader());
        textObjects = in.createTypedArrayList(TextObject.CREATOR);
        thumbnail = in.readParcelable(Thumbnail.class.getClassLoader());
        title = in.readString();
        upc = in.readString();
        urls = in.createTypedArrayList(Url.CREATOR);
        variantDescription = in.readString();
    }

    public static final Creator<Result> CREATOR = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };


    public long getIdComic() {
        return idComic;
    }

    public void setIdComic(long idComic) {
        this.idComic = idComic;
    }


    public Characters getCharacters() {
        return characters;
    }

    public void setCharacters(Characters characters) {
        this.characters = characters;
    }

    public List<Object> getCollectedIssues() {
        return collectedIssues;
    }

    public void setCollectedIssues(List<Object> collectedIssues) {
        this.collectedIssues = collectedIssues;
    }

    public List<Object> getCollections() {
        return collections;
    }

    public void setCollections(List<Object> collections) {
        this.collections = collections;
    }

    public Creators getCreators() {
        return creators;
    }

    public void setCreators(Creators creators) {
        this.creators = creators;
    }

    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiamondCode() {
        return diamondCode;
    }

    public void setDiamondCode(String diamondCode) {
        this.diamondCode = diamondCode;
    }

    public Long getDigitalId() {
        return digitalId;
    }

    public void setDigitalId(Long digitalId) {
        this.digitalId = digitalId;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public Long getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(Long issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public Long getPageCount() {
        return pageCount;
    }

    public void setPageCount(Long pageCount) {
        this.pageCount = pageCount;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public Stories getStories() {
        return stories;
    }

    public void setStories(Stories stories) {
        this.stories = stories;
    }

    public List<TextObject> getTextObjects() {
        return textObjects;
    }

    public void setTextObjects(List<TextObject> textObjects) {
        this.textObjects = textObjects;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public List<Url> getUrls() {
        return urls;
    }

    public void setUrls(List<Url> urls) {
        this.urls = urls;
    }

    public String getVariantDescription() {
        return variantDescription;
    }

    public void setVariantDescription(String variantDescription) {
        this.variantDescription = variantDescription;
    }

    public List<Object> getVariants() {
        return variants;
    }

    public void setVariants(List<Object> variants) {
        this.variants = variants;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(characters, flags);
        dest.writeParcelable(creators, flags);
        dest.writeTypedList(dates);
        dest.writeString(description);
        dest.writeString(diamondCode);
        if (digitalId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(digitalId);
        }
        dest.writeString(ean);
        dest.writeParcelable(events, flags);
        dest.writeString(format);
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
        dest.writeTypedList(images);
        dest.writeString(isbn);
        dest.writeString(issn);
        if (issueNumber == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(issueNumber);
        }
        dest.writeString(modified);
        if (pageCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(pageCount);
        }
        dest.writeTypedList(prices);
        dest.writeString(resourceURI);
        dest.writeParcelable(series, flags);
        dest.writeParcelable(stories, flags);
        dest.writeTypedList(textObjects);
        dest.writeParcelable(thumbnail, flags);
        dest.writeString(title);
        dest.writeString(upc);
        dest.writeTypedList(urls);
        dest.writeString(variantDescription);
    }
}