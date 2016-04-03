package com.bit_makers.saikat.stratupbd;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ASUS on 3/22/2016.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ArticleViewHolder> {

    Context context;
    ArrayList<Article> articles;

    public RVAdapter (Context ctx, ArrayList<Article> articles){
        context= ctx;
        this.articles = articles;
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView;
        TextView title;
        TextView author;
        TextView comment;
        public ArticleViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.card_view);
            imageView = (ImageView)itemView.findViewById(R.id.view_image);
            title = (TextView)itemView.findViewById(R.id.title);
            author = (TextView)itemView.findViewById(R.id.author);
            comment = (TextView)itemView.findViewById(R.id.comment);
        }
    }

    @Override
    public RVAdapter.ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_view, parent, false);
        ArticleViewHolder holder = new ArticleViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RVAdapter.ArticleViewHolder holder, int position) {
        holder.imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.image));
        holder.title.setText(articles.get(position).getTitle());
        holder.author.setText(articles.get(position).getAuthor());
        holder.comment.setText(articles.get(position).getDate()+" / "+articles.get(position).getCommment());
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }
}
