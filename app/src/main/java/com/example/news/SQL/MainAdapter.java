package com.example.news.SQL;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news.R;

import java.util.List;

public class    MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private final List<Link> linkList;
    private Activity context;
    private LinksDatabase database;

    public MainAdapter(Activity context, List<Link> linkList) {
        this.context = context;
        this.linkList = linkList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.links_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        Link link = linkList.get(position);
        database = LinksDatabase.getInstance(context);
        holder.linkView.setText(link.getLink());

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
    }

    @Override
    public int getItemCount() {
        return linkList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView linkView;
        ImageView btnDelete;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            linkView = itemView.findViewById(R.id.link_view);
            btnDelete = itemView.findViewById(R.id.btn_delete);
        }
    }
}