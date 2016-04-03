package com.bit_makers.saikat.stratupbd;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ASUS on 3/22/2016.
 */
public class AllArticle extends Fragment implements  AsyncResponse{

    Context context;
    RecyclerView recyclerView;
    JSONObject[] jsonObject;
    JSONExecuter jsonExecuter;
    ArrayList<Article> articles;

    public AllArticle(Context ctx){
        context = ctx; //192.168.5.202
        String url = "http://192.168.5.202/saikat/get_all_article.php";
        jsonExecuter = new JSONExecuter(context);
        jsonExecuter.delegate = this;
        jsonExecuter.execute(url);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.article_name, null);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(0);
        LinearLayoutManager llm = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(llm);
        return  view;
    }

    @Override
    public void processFinish(JSONObject[] jsonObject) {
        this.jsonObject = jsonObject;
        JSONArray jsonArray = jsonObject[0].optJSONArray("data");
        articles = new ArrayList<Article>();
        JSONObject object = null;
        for(int i=0; i<jsonArray.length(); i++){
            try {
                object = jsonArray.getJSONObject(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Article article = new Article();
            article.setTitle(object.optString("title"));
            article.setAuthor("by "+object.optString("author"));
            article.setCommment(object.optString("comment") + " comment(s)");
            article.setDate(object.optString("time"));
            articles.add(article);
        }
        RVAdapter adapter = new RVAdapter(context,articles);
        recyclerView.setAdapter(adapter);
    }
}
