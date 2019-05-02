package com.example.graphplot;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity {

    LineGraphSeries<DataPoint> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int horizontal[] = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int vertical[] = {2, 4, 6, 8, 10, 11, 11, 11, 15, 24};

        GraphView graph = findViewById(R.id.graph);
        series = new LineGraphSeries<DataPoint>();
        for(int i = 0; i < horizontal.length; i++){
            series.appendData(new DataPoint(horizontal[i], vertical[i]), true, 900);
        }
        graph.addSeries(series);
    }
}
