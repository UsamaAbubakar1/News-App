package com.example.newswave;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ScienceFrag extends Fragment {
    String apikey = "e70554fc587e468bb1871853d919c2de";

    ArrayList<articlesModel> articlesModelArrayList;
    String country = "in";

    RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewScience;

    private String category = "science";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_science, container, false);


        recyclerViewScience = view.findViewById(R.id.rvScience);
        articlesModelArrayList = new ArrayList<>();
        recyclerViewScience.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new recyclerAdapter(getContext(), articlesModelArrayList);
        recyclerViewScience.setAdapter(adapter);

        findNews();
        return view;
    }

    private void findNews() {
        apiUtilities.getapiInterface().getCategoryNews(country, category, 100, apikey).enqueue(new Callback<resultModel>() {
            @Override
            public void onResponse(Call<resultModel> call, Response<resultModel> response) {
                if (response.isSuccessful()) {
                    articlesModelArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<resultModel> call, Throwable t) {

            }
        });
    }
}