package filmy.nelk.io.filmy.retrofit;

import filmy.nelk.io.filmy.retrofit.Models.MoviesList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieDBService {

    @GET(APIConfig.MDB_SORTING_KEY)
    Call<MoviesList> loadMovies(@Path("sorting") String SortingKey,
                                       @Query(APIConfig.MDB_API_KEY_PARAM) String mBD_API_Key);

}
