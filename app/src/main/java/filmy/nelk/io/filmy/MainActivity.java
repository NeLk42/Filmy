package filmy.nelk.io.filmy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import filmy.nelk.io.filmy.recyclerview.MovieAdapter;
import filmy.nelk.io.filmy.retrofit.Models.Movie;
import filmy.nelk.io.filmy.retrofit.MovieDBAPI;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    private MovieAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_movies_grid);

        // Attach LayoutManager to RecyclerView
        GridLayoutManager gridLayoutManager =
                new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        // Attach Adapter to RecyclerView
        List<Movie> movies = new ArrayList<>();
        mAdapter = new MovieAdapter(this, movies);
        mRecyclerView.setAdapter(mAdapter);

        //
        MovieDBAPI movieDBAPI = new MovieDBAPI();
        movieDBAPI.getPopular(mAdapter, movies);
    }
}
