package filmy.nelk.io.filmy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import filmy.nelk.io.filmy.recyclerview.MovieAdapter;
import filmy.nelk.io.filmy.retrofit.Models.Movie;
import filmy.nelk.io.filmy.retrofit.MovieDBAPI;

public class MainActivity extends AppCompatActivity{
    public static final String TAG = MainActivity.class.getSimpleName();

    private MovieAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private List<Movie> movies = new ArrayList<>();
    MovieDBAPI movieDBAPI = new MovieDBAPI();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_movies_grid);

        // Attach LayoutManager to RecyclerView
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        // Attach Adapter to RecyclerView

        mAdapter = new MovieAdapter(this, movies);
        mRecyclerView.setAdapter(mAdapter);

        // Call MovieDB to retrieve data and update RecyclerView
        movieDBAPI.getMovies(mAdapter, movies);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){
            case R.id.menu_sort:
                mAdapter = new MovieAdapter(this, movies);
                mRecyclerView.setAdapter(mAdapter);
                movieDBAPI.getMovies(mAdapter, movies);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
