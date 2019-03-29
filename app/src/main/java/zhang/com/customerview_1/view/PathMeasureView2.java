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
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.gcssloop.view.utils.CanvasAidUtils;

import zhang.com.customerview_1.R;

/**
 * Created by beiyong14 on 2019/3/27.
 */

public class PathMeasureView2 extends View{
    private String TAG = "PathMeasure";
    private Paint paint = new Paint();
    private int width;
    private int height;
    private Bitmap bitmap;
    private float totalTime = 24000;
    private float eachTime = 100;
    private float currentTime = 0;
    private Matrix matrix;
    public PathMeasureView2(Context context) {
        this(context,null);
    }

    public PathMeasureView2(Context context, AttributeSet attrs) {
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
        paint.setStrokeWidth(8);

        matrix = new Matrix();

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 4;       // 缩放图片
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.arrow,options);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.translate(width / 2, height / 2);
//        canvas.scale(1,-1);

        drawCoordinate(canvas);

        Path path = new Path();
        path.addCircle(0,0,200, Path.Direction.CW);
        PathMeasure pathMeasure = new PathMeasure(path,false);

//        float[] pos = new float[2];
//        float[] tan = new float[2];
//
//        pathMeasure.getPosTan(pathMeasure.getLength() * (currentTime / totalTime),pos,tan);
//
//        float degree = (float) (Math.atan2(tan[1],tan[0]) * (180 / Math.PI));
//
//        matrix.reset();
//
//        matrix.preTranslate(pos[0] - bitmap.getWidth() / 2, pos[1] - bitmap.getHeight() / 2);
//        matrix.preRotate(degree,bitmap.getWidth() / 2, bitmap.getHeight() / 2);

        pathMeasure.getMatrix(pathMeasure.getLength() * (currentTime / totalTime),matrix,
                PathMeasure.POSITION_MATRIX_FLAG | PathMeasure.TANGENT_MATRIX_FLAG);

        matrix.preTranslate(-bitmap.getWidth() / 2,-bitmap.getHeight() / 2);

        canvas.drawPath(path,paint);
        canvas.drawBitmap(bitmap,matrix,paint);

        currentTime += eachTime;
        if(currentTime >= totalTime){
            currentTime = 0;
        }

        invalidate();

    }

    private void drawCoordinate(Canvas canvas){
        // 绘制坐标系
        CanvasAidUtils.set2DAxisLength(400, 400, 600, 600);
        CanvasAidUtils.draw2DCoordinateSpace(canvas);
        CanvasAidUtils.setLineColor(Color.RED);
    }
}
