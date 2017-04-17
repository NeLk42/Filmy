package filmy.nelk.io.filmy.retrofit.Models;

import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("original_title")
    String title;
    @SerializedName("overview")
    String overview;
    @SerializedName("vote_average")
    String rating;
    @SerializedName("release_date")
    String releaseDate;
    @SerializedName("poster_path")
    String posterPath;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String path) {
        this.posterPath = path;
    }

}
