package filmy.nelk.io.filmy.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import filmy.nelk.io.filmy.R;
import filmy.nelk.io.filmy.retrofit.Models.Movie;
import filmy.nelk.io.filmy.utils.MovieUtils;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{
    public static final String TAG = MovieAdapter.class.getSimpleName();

    private final List<Movie> mMovies;
    private Context mContext;

    public MovieAdapter(Context context, List<Movie> moviesList) {
        mContext = context;
        mMovies = moviesList;
    }

    // Inflate item Layout and return inflated ViewHolder
    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean attachToParentImmediately = false;

        // Inflate layout
        View movieView = inflater.inflate(R.layout.movie_grid_item, parent, attachToParentImmediately);

        // New ViewHolder instance
        MovieViewHolder movieViewHolder = new MovieViewHolder(movieView);
        return movieViewHolder;
    }

    // Populate data into item through ViewHolder
    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        // Get movie from list based on position
        Movie movie = mMovies.get(position);

        // TODO : Remove debugging
        Log.d(TAG, movie.getTitle());
        Log.d(TAG, MovieUtils.buildPosterPath(movie.getPosterPath()));

        // Get reference view items
        TextView title = holder.mTitle;
        TextView rating = holder.mRating;
        ImageView poster = holder.mPoster;

        // Set movie views based on views and network data
        title.setText(movie.getTitle());
        rating.setText(movie.getPopularity());
        Picasso.with(mContext)
                .load(MovieUtils.buildPosterPath(movie.getPosterPath()))
                .into(poster);
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        TextView mTitle;
        TextView mRating;
        ImageView mPoster;

        MovieViewHolder(View itemView) {
            super(itemView);
            this.mTitle = (TextView) itemView.findViewById(R.id.tv_title);
            this.mRating = (TextView) itemView.findViewById(R.id.tv_rating);
            this.mPoster = (ImageView) itemView.findViewById(R.id.iv_poster);
        }
    }
}
