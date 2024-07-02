package com.example.ecorecicla;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
import java.util.List;

public class StatisticsActivity extends AppCompatActivity {

    private PieChart pieChart;
    private BarChart barChart;
    private TextView tvAverage, tvMax, tvMin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics_activity);

        pieChart = findViewById(R.id.pieChart);
        barChart = findViewById(R.id.barChart);
        tvAverage = findViewById(R.id.tvAverage);
        tvMax = findViewById(R.id.tvMax);
        tvMin = findViewById(R.id.tvMin);

        setupPieChart();
        setupBarChart();
        showStatistics();
    }

    private void setupPieChart() {
        List<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(40f, "Plástico"));
        pieEntries.add(new PieEntry(30f, "Papel"));
        pieEntries.add(new PieEntry(20f, "Vidrio"));
        pieEntries.add(new PieEntry(10f, "Metal"));

        PieDataSet pieDataSet = new PieDataSet(pieEntries, "Materiales Reciclados");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.invalidate(); // refresh
    }

    private void setupBarChart() {
        List<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1f, 50f));
        barEntries.add(new BarEntry(2f, 30f));
        barEntries.add(new BarEntry(3f, 20f));
        barEntries.add(new BarEntry(4f, 40f));

        BarDataSet barDataSet = new BarDataSet(barEntries, "Reciclaje Mensual");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        BarData barData = new BarData(barDataSet);

        barChart.setData(barData);
        barChart.invalidate(); // refresh
    }

    private void showStatistics() {
        List<Float> data = new ArrayList<>();
        data.add(50f);
        data.add(30f);
        data.add(20f);
        data.add(40f);

        float average = calculateAverage(data);
        float max = findMax(data);
        float min = findMin(data);

        tvAverage.setText("Promedio: " + average);
        tvMax.setText("Máximo: " + max);
        tvMin.setText("Mínimo: " + min);
    }

    private float calculateAverage(List<Float> data) {
        float sum = 0f;
        for (float value : data) {
            sum += value;
        }
        return sum / data.size();
    }

    private float findMax(List<Float> data) {
        float max = data.get(0);
        for (float value : data) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    private float findMin(List<Float> data) {
        float min = data.get(0);
        for (float value : data) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
}


