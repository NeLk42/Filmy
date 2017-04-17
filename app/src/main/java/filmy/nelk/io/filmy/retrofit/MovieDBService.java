package filmy.nelk.io.filmy.retrofit;

import filmy.nelk.io.filmy.retrofit.Models.MoviesList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDBService {

    @GET(APIConfig.MDB_POPULAR)
    Call<MoviesList> loadPopularMovies(@Query(APIConfig.MDB_API_KEY_PARAM) String mBD_API_Key);

}
