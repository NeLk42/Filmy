package filmy.nelk.io.filmy.retrofit;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import filmy.nelk.io.filmy.retrofit.Models.Movie;
import filmy.nelk.io.filmy.retrofit.Models.MoviesList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieDBAPI implements Callback<MoviesList>{

    public static final String TAG = MovieDBAPI.class.getSimpleName();

    public void getPopular() {
        Log.d(TAG, "Getting Popular");
        MovieDBService mDBService = getMovieDBService();
        Log.d(TAG, "Loading PopularMovies");
        Call<MoviesList> call = mDBService.loadPopularMovies(APIConfig.MDB_API_KEY);
        Log.d(TAG, "Enqueing");
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
        Log.d(TAG, "onResponse");
        if(response.isSuccessful()){
            Log.d(TAG, "Response Successful");
            MoviesList movies = response.body();
            Log.d(TAG, "I has body");
            for (Movie movie : movies.getResults()) {
                //TODO : Handle info
                Log.d(TAG, "Movie " + movie.getTitle());
            }
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
}
