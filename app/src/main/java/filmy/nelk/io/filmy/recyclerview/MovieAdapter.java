package filmy.nelk.io.filmy.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import filmy.nelk.io.filmy.DetailsActivity;
import filmy.nelk.io.filmy.R;
import filmy.nelk.io.filmy.retrofit.APIConfig;
import filmy.nelk.io.filmy.retrofit.Models.Movie;
import filmy.nelk.io.filmy.utils.MovieUtils;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{
    public static final String TAG = MovieAdapter.class.getSimpleName();

    public List<Movie> mMovies;
    private LayoutInflater mInflater;
    private Context mContext;

    public MovieAdapter(Context context, List<Movie> moviesList) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
        mMovies = moviesList;
    }

    // Inflate item Layout and return inflated ViewHolder
    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate layout
        View movieView = mInflater.inflate(R.layout.movie_grid_item, parent, false);

        // New ViewHolder instance
        MovieViewHolder movieViewHolder = new MovieViewHolder(movieView);
        return movieViewHolder;
    }

    // Populate data into item through ViewHolder
    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        // Get movie from list based on position
        final Movie movie = mMovies.get(position);

        // Get reference view items
        ImageView poster = holder.mPoster;

        // Set movie views based on views and network data
        Picasso.with(mContext)
                .load(MovieUtils.buildImagePath(movie.getPosterPath(), APIConfig.MDB_IMAGE_SIZE_S))
                .into(poster);

        // Attach clickListener to this item
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailsActivity.class);
                intent.putExtra(APIConfig.PARAM_MOVIE, movie);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public void updateMovieList(List<Movie> movieList){
        this.mMovies.clear();
        this.mMovies.addAll(movieList);
        notifyDataSetChanged();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder{
        ImageView mPoster;
        MovieViewHolder(View itemView) {
            super(itemView);
            this.mPoster = (ImageView) itemView.findViewById(R.id.iv_poster);
        }
    }
}