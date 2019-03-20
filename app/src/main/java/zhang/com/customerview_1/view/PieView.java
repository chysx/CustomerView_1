package zhang.com.customerview_1.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import zhang.com.customerview_1.model.Pie;
import zhang.com.customerview_1.presenter.PiePresenter;

/**
 * Created by beiyong14 on 2019/3/20.
 */

public class PieView extends View {
    private int width;
    private int height;
    private Paint paint = new Paint();

    private List<Pie> pieList = new ArrayList<>();
    public PieView(Context context) {
        this(context,null);
    }

    public PieView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);

        initData();
    }

    private void initData(){
        PiePresenter presenter = new PiePresenter((Activity)getContext());
        presenter.initData();
        pieList.addAll(presenter.pieList);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(width / 2, height / 2); // 将画布原点移动到view中心的
        float r = Math.min(width,height) / 2 * 0.8f; // 饼状图的半径，为了不让饼状图超过视图区域，半径必须小于view的宽高的最小值
        int currentAnge = 0;
        for(Pie pie : pieList){
            RectF rectF = new RectF(-r,-r,r,r);
            paint.setColor(pie.color);
            canvas.drawArc(rectF,currentAnge,pie.angle,true,paint);
            currentAnge += pie.angle;
        }
    }
}
