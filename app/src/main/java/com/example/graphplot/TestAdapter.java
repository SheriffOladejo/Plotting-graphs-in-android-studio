package com.example.graphplot;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {

    private List<TestModels> list;
    private String post_data = new String();
    private TextView Test_post;
    private static final String TAG = "Favorite";

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.test, viewGroup, false);
        return new ViewHolder(view);
    }


    public TestAdapter(List<TestModels> list){
        this.list = list;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        try {
            FileReader file = new FileReader("C:\\Users\\HunchoMufasa\\Desktop\\Radical Facts\\Car Facts.txt");
            //InputStreamReader input = new InputStreamReader(file);
            BufferedReader br = new BufferedReader(file);
            String line;

        for(int t = 0; (line = br.readLine()) != null; t++){
            post_data = line;
            viewHolder.setCaption(post_data);
        }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View view;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }

        public void setCaption(String post){

            Test_post = view.findViewById(R.id.test_post);
            Test_post.setText(post);

        }

    }
}


