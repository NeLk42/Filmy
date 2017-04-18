package filmy.nelk.io.filmy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import filmy.nelk.io.filmy.recyclerview.MovieAdapter;
import filmy.nelk.io.filmy.retrofit.Models.Movie;
import filmy.nelk.io.filmy.utils.MovieUtils;

public class DetailsActivity extends AppCompatActivity {

    private MovieAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent storage = getIntent();

        if (storage.hasExtra("movie")){
            loadDetails(storage);

        } else {
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    private void loadDetails(Intent storage) {
        Movie movie = (Movie) storage.getExtras().get("movie");

        ImageView poster = (ImageView) findViewById(R.id.iv_details_poster);
        Picasso.with(this)
                .load(MovieUtils.buildPosterPath(movie.getPosterPath()))
                .into(poster);

        TextView title = (TextView) findViewById(R.id.tv_details_title);
        title.setText(movie.getTitle());

        TextView overview = (TextView) findViewById(R.id.tv_details_overview);
        overview.setText(movie.getOverview());

        TextView rating = (TextView) findViewById(R.id.tv_details_rating);
        rating.setText(movie.getRating());

        TextView release = (TextView) findViewById(R.id.tv_details_release);
        release.setText(movie.getReleaseDate());
    }
}
