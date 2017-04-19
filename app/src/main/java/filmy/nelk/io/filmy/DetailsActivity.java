package filmy.nelk.io.filmy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import filmy.nelk.io.filmy.retrofit.APIConfig;
import filmy.nelk.io.filmy.retrofit.Models.Movie;
import filmy.nelk.io.filmy.utils.MovieUtils;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent storage = getIntent();

        if (storage.hasExtra(APIConfig.PARAM_MOVIE)){
            loadDetails(storage);
        } else {
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    private void loadDetails(Intent storage) {
        Movie movie = (Movie) storage.getExtras().get(APIConfig.PARAM_MOVIE);

        ImageView backdrop = (ImageView) findViewById(R.id.iv_details_backdrop);
        Picasso.with(this)
                .load(MovieUtils.buildImagePath(movie.getBackdropPath(), APIConfig.MDB_IMAGE_SIZE_L))
                .into(backdrop);

        ImageView poster = (ImageView) findViewById(R.id.fab_poster);
        Picasso.with(this)
                .load(MovieUtils.buildImagePath(movie.getPosterPath(), APIConfig.MDB_IMAGE_SIZE_S))
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
