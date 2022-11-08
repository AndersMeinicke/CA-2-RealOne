package dtos;

public class ChuckNorrisDTO {
String value;
String url;
String id;

    public ChuckNorrisDTO(String value, String url, String id) {
        this.value = value;
        this.url = url;
        this.id = id;
    }

    public String getJoke() {
        return value;
    }
}
