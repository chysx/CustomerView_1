package zhang.com.customerview_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import zhang.com.customerview_1.activity.BezierActivity;
import zhang.com.customerview_1.activity.PathActivity;
import zhang.com.customerview_1.activity.PathMeasureActivity;
import zhang.com.customerview_1.activity.PieActivity;
import zhang.com.customerview_1.view.PieView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }


    private void initView(){
        Button btnPie = findViewById(R.id.btn_pie);
        btnPie.setOnClickListener(this);

        Button btnPath = findViewById(R.id.btn_path);
        btnPath.setOnClickListener(this);

        Button btnBezier = findViewById(R.id.btn_bezier);
        btnBezier.setOnClickListener(this);

        Button btnPathMeasure = findViewById(R.id.btn_path_measure);
        btnPathMeasure.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.btn_pie:
                intent = new Intent(this, PieActivity.class);
                break;
            case R.id.btn_path:
                intent = new Intent(this, PathActivity.class);
                break;
            case R.id.btn_bezier:
                intent = new Intent(this, BezierActivity.class);
                break;
            case R.id.btn_path_measure:
                intent = new Intent(this, PathMeasureActivity.class);
                break;
        }
        startActivity(intent);
    }
}
