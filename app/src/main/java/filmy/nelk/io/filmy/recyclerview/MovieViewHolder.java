package filmy.nelk.io.filmy.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import filmy.nelk.io.filmy.R;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public TextView rating;
    public ImageView poster;

    public MovieViewHolder(View itemView) {
        super(itemView);
        this.title = (TextView) itemView.findViewById(R.id.tv_title);
        this.rating = (TextView) itemView.findViewById(R.id.tv_rating);
        this.poster = (ImageView) itemView.findViewById(R.id.iv_poster);
    }
}
