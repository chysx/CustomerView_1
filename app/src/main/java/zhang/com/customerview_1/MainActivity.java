package zhang.com.customerview_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import zhang.com.customerview_1.view.PieView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
        PieView pieView = findViewById(R.id.pv);
    }
}
