package zhang.com.customerview_1.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.gcssloop.view.utils.CanvasAidUtils;

import zhang.com.customerview_1.R;

/**
 * Created by beiyong14 on 2019/3/27.
 */

public class PathMeasureView3 extends View{
    private String TAG = "PathMeasure";
    private Paint paint = new Paint();
    private int width;
    private int height;
    private float totalTime = 24000;
    private float eachTime = 100;
    private float currentTime = 0;
    private boolean isAdd = true;
    public PathMeasureView3(Context context) {
        this(context,null);
    }

    public PathMeasureView3(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    public void init(){
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(16);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.translate(width / 2, height / 2);
        drawCoordinate(canvas);

        Path path = new Path();
        path.moveTo(100,100);
        RectF arc = new RectF(-100,-100,100,100);
        path.addArc(arc,45,359.9f);
        path.lineTo(200,200);
        PathMeasure pathMeasure = new PathMeasure(path,false);

        Path dst = new Path();

        if(isAdd){
            pathMeasure.getSegment(0,pathMeasure.getLength() * (currentTime / totalTime),dst,true);
            if(currentTime >= totalTime){
                currentTime = 0;
                isAdd = false;
            }
        }else{
            pathMeasure.getSegment(0,pathMeasure.getLength() * (1 - currentTime / totalTime),dst,true);
            if(currentTime >= totalTime){
                currentTime = 0;
                isAdd = true;
            }
        }
        currentTime += eachTime;

        canvas.drawPath(dst,paint);

        invalidate();

    }

    private void drawCoordinate(Canvas canvas){
        // 绘制坐标系
        CanvasAidUtils.set2DAxisLength(400, 400, 600, 600);
        CanvasAidUtils.draw2DCoordinateSpace(canvas);
        CanvasAidUtils.setLineColor(Color.RED);
    }
}
