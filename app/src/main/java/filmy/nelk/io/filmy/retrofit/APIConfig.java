package filmy.nelk.io.filmy.retrofit;

public class APIConfig {

    public static final String MDB_API_KEY          = MovieDBKey.MOVIEDB_APIKEY;
    public static final String MDB_API_KEY_PARAM    = "api_key";

    public static final String MDB_BASE_URL         = "http://api.themoviedb.org/3/";
    public static final String MDB_SORTING_KEY      = "movie/{sorting}";
    public static final String MDB_TOP_RATED        = "top_rated";
    public static final String MDB_POPULAR          = "popular";

    public static final String MDB_BASE_IMAGE_URL   = "https://image.tmdb.org/t/p/";
    public static final String MDB_IMAGE_SIZE_S     = "w185";
    public static final String MDB_IMAGE_SIZE_M     = "w500";
    public static final String MDB_IMAGE_SIZE_L     = "w1000";

    public static final String PARAM_MOVIE          = "movie";
    public static final String PARAM_SORTING        = "sorting";

}
