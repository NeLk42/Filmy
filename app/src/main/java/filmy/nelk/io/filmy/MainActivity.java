package filmy.nelk.io.filmy;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import filmy.nelk.io.filmy.recyclerview.MovieAdapter;
import filmy.nelk.io.filmy.retrofit.Models.Movie;
import filmy.nelk.io.filmy.retrofit.MovieDBAPI;

public class MainActivity extends AppCompatActivity implements MovieAdapter.MovieClickListener{
    public static final String TAG = MainActivity.class.getSimpleName();

    private MovieAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private Toast mToast;

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
        List<Movie> movies = new ArrayList<>();
        mAdapter = new MovieAdapter(this, movies, this);
        mRecyclerView.setAdapter(mAdapter);

        // Call to MovieDB to retrieve data and update RecyclerView
        MovieDBAPI movieDBAPI = new MovieDBAPI();
        movieDBAPI.getPopular(mAdapter, movies);
    }

    @Override
    public void onMovieItemClick(int position) {
        //TODO: Use Intent to access Details Activity
        if (mToast != null){
            mToast.cancel();
        }
        mToast = Toast.makeText(this, "Clickity", Toast.LENGTH_SHORT);
        mToast.show();
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("itemPosition", mAdapter.mMovies.get(position).toString());
        startActivityForResult(intent, 1);
    }

}
