package com.example.news.SQL;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.news.R;
import com.example.news.RSS.RSSFeedActivity;

import java.util.List;

/**
 * @author Bonta A
 * @version : 2.0
 */

/**
 * Main adapter class for displaying links_row
 * Each row has delete button and links text from database
 * It extends RecyclerView
 * @see RecyclerView
 */
public class    MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {


    private static final String TAG = "TEST getLink";
    private final List<Link> linkList;
    private Activity context;
    private LinksDatabase database;

    /**
     * Constructor of MainAdapter object
     * @param context Interface to global information about an application environment
     * @param linkList list of RSS links
     * @see Context
     * @see Link
     */
    public MainAdapter(Activity context, List<Link> linkList) {
        this.context = context;
        this.linkList = linkList;
        notifyDataSetChanged();
    }

    /**
     * Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item
     * @param parent a special view that can contain other views (called children)
     * @param viewType The view type of the new View
     * @return A new ViewHolder that holds a View of the given view type
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.links_row, parent, false);
        return new ViewHolder(view);
    }

    /**
     * updates the RecyclerView.ViewHolder contents with the item at the given position and also sets up some private fields to be used by RecyclerView
     * @param holder an object of view holder
     * @param position the stable ID for the item at position
     * @see androidx.recyclerview.widget.RecyclerView.ViewHolder
     */
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        Link link = linkList.get(position);
        database = LinksDatabase.getInstance(context);
        holder.linkView.setText(link.getLink());

        /**
         * Handler for delete button from holder
         * @see holder
         * @see holder.btnDelete
         */
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Link link1 = linkList.get(holder.getAdapterPosition());
                database.linkDao().delete(link1);
                int position = holder.getAdapterPosition();
                linkList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, linkList.size());

            }
        });

        /**
         * Handler for row from holder
         * @see holder
         * @see holder.row
         */
        holder.row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String linkText = (String) holder.linkView.getText();
                Log.d(TAG, linkText);

                Context context = view.getContext();
                Intent intent = new Intent(view.getContext(), RSSFeedActivity.class);
                intent.putExtra("url", linkText);
                context.startActivity(intent);

            }
        });
    }

    /**
     * Counts items
     * @return the nubmer of items
     */
    @Override
    public int getItemCount() {
        return linkList.size();
    }

    /**
     * Class View holder
     * Elements represented in each row
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView linkView;
        ImageView btnDelete;
        LinearLayout row;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            linkView = itemView.findViewById(R.id.link_view);
            btnDelete = itemView.findViewById(R.id.btn_delete);
            row = itemView.findViewById(R.id.row_id);
        }
    }
}