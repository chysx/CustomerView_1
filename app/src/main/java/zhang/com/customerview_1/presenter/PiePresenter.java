package zhang.com.customerview_1.presenter;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import zhang.com.customerview_1.model.Pie;

/**
 * Created by beiyong14 on 2019/3/20.
 */

public class PiePresenter {
    private Activity context;
    public List<Pie> pieList = new ArrayList<>();
    public PiePresenter(Activity context){
        this.context = context;
    }

    public void initData(){
        createPieData();
        makePieData();
    }

    private void makePieData(){
        float totalValue = 0;
        for(Pie pie : pieList){
            totalValue += pie.value;
        }
        for(Pie pie : pieList){
            pie.percentage = pie.value / totalValue;
            pie.angle = (int) (pie.percentage * 360);
            Log.e("pie", "angle: " + pie.angle);
        }
    }

    private void createPieData() {
        Pie pie = new Pie();
        pie.name = "a";
        pie.value = 10;
        pie.color = Color.RED;

        Pie pie1 = new Pie();
        pie1.name = "b";
        pie1.value = 20;
        pie1.color = Color.GREEN;

        Pie pie2 = new Pie();
        pie2.name = "b";
        pie2.value = 30;
        pie2.color = Color.BLUE;

        Pie pie3 = new Pie();
        pie3.name = "a";
        pie3.value = 10;
        pie3.color = Color.YELLOW;

        pieList.add(pie);
        pieList.add(pie1);
        pieList.add(pie2);
        pieList.add(pie3);
    }
}
