package trendYol.Bölüm2;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonPropertyOrder(value = {
        "id",
        "author",
        "title"
})
@JsonRootName(value = "books")
public class BookData {

    private int id;

    private String author;
    private String title;

    @JsonCreator
    public BookData(
            @JsonProperty( value = "author",required = true) String author,
            @JsonProperty( value = "title",required = true) String title) {
        super();
        this.author = author;
        this.title = title;
    }

    public  BookData() {

    }

    @JsonProperty(value = "id", required = true)
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty(value = "author", required = true)
    public String getAuthor() {
        return author;
    }

    @JsonProperty(value = "author", required = true)
    public void setAuthor(String author) {
        this.author = author;
    }

    @JsonProperty(value = "title", required = true)
    public String getTitle() {
        return title;
    }

    @JsonProperty(value = "title", required = true)
    public String setTitle(String title) {
        this.title = title;
        return title;
    }

}