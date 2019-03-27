package zhang.com.customerview_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.btn_pie:
                intent = new Intent(this, PieActivity.class);
                break;
        }
        startActivity(intent);
    }
}
