package zhang.com.customerview_1.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import zhang.com.customerview_1.R;
import zhang.com.customerview_1.view.PieView;

/**
 * Created by beiyong14 on 2019/3/27.
 */

public class PieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie);

        initView();
    }

    private void initView(){
        PieView pieView = findViewById(R.id.pv);
    }
}
