package filmy.nelk.io.filmy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import filmy.nelk.io.filmy.retrofit.MovieDBAPI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MovieDBAPI movieDBAPI = new MovieDBAPI();
        movieDBAPI.getPopular(mAdapter, movies);
    }
}
