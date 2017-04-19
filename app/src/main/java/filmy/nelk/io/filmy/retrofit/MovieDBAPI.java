package filmy.nelk.io.filmy.retrofit;

import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import filmy.nelk.io.filmy.recyclerview.MovieAdapter;
import filmy.nelk.io.filmy.retrofit.Models.Movie;
import filmy.nelk.io.filmy.retrofit.Models.MoviesList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieDBAPI implements Callback<MoviesList>{

    public static final String TAG = MovieDBAPI.class.getSimpleName();

    public List<Movie> moviesList;
    public MovieAdapter mAdapter;
    private String mSorting;

    public void getMovies(MovieAdapter adapter, List<Movie> rvList) {
        this.mAdapter = adapter;
        this.moviesList = rvList;

        MovieDBService mDBService = getMovieDBService();
        Call<MoviesList> call = mDBService.loadMovies(resolveSorting(), APIConfig.MDB_API_KEY);
        call.enqueue(this);
    }

    private MovieDBService getMovieDBService() {
        Log.d(TAG, "Getting Service");
        Retrofit retrofit = getRetrofit();
        return retrofit.create(MovieDBService.class);
    }

    @NonNull
    private Retrofit getRetrofit() {
        Log.d(TAG, "Getting Retrofit");
        return new Retrofit.Builder()
                    .baseUrl(APIConfig.MDB_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
    }

    @Override
    public void onResponse(Call<MoviesList> call, Response<MoviesList> response) {
        if(response.isSuccessful()){
            MoviesList movies = response.body();
            mAdapter.updateMovieList(movies.getResults());
        } else {
            try {
                Log.d(TAG, response.errorBody().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onFailure(Call<MoviesList> call, Throwable t) {
        Log.d(TAG, "onFailure");
        t.printStackTrace();
    }

    public String resolveSorting() {
        if (mSorting != null && mSorting.equals(APIConfig.MDB_POPULAR)){
            mSorting = APIConfig.MDB_TOP_RATED;
            return mSorting;
        }
        mSorting = APIConfig.MDB_POPULAR;
        return mSorting;
    }
}
