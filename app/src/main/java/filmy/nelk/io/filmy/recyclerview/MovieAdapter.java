package filmy.nelk.io.filmy.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import filmy.nelk.io.filmy.DetailsActivity;
import filmy.nelk.io.filmy.R;
import filmy.nelk.io.filmy.retrofit.Models.Movie;
import filmy.nelk.io.filmy.utils.MovieUtils;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{
    public static final String TAG = MovieAdapter.class.getSimpleName();

    public List<Movie> mMovies;
    private LayoutInflater mInflater;
    private Context mContext;
    private MovieClickListener mMovieClickListener;

    public MovieAdapter(Context context, List<Movie> moviesList, MovieClickListener listener) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
        mMovies = moviesList;
        mMovieClickListener = listener;
    }

    // Inflate item Layout and return inflated ViewHolder
    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate layout
        View movieView = mInflater.inflate(R.layout.movie_grid_item, parent, false);

        // New ViewHolder instance
        MovieViewHolder movieViewHolder = new MovieViewHolder(mContext, movieView);
        return movieViewHolder;
    }

    // Populate data into item through ViewHolder
    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        // Get movie from list based on position
        Movie movie = mMovies.get(position);

        // Get reference view items
        ImageView poster = holder.mPoster;

        // Set movie views based on views and network data
        Picasso.with(mContext)
                .load(MovieUtils.buildPosterPath(movie.getPosterPath()))
                .into(poster);
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public interface MovieClickListener {
        public void onMovieItemClick (int position);
    }

    public void updateMovieList(List<Movie> movieList){
        this.mMovies.clear();
        this.mMovies.addAll(movieList);
        notifyDataSetChanged();
    }







    class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView mPoster;
        public Context context;

        MovieViewHolder(Context context, View itemView) {
            super(itemView);
            this.mPoster = (ImageView) itemView.findViewById(R.id.iv_poster);
            this.context = context;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();

            mMovies.get(position);

            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("itemPosition", mMovies.get(position).toString());
            context.startActivity(intent);
        }
    }
}