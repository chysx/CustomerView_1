package zhang.com.customerview_1.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.gcssloop.view.utils.CanvasAidUtils;

/**
 * Created by beiyong14 on 2019/3/27.
 */

public class PathView extends View{
    private Paint paint = new Paint();
    private int width;
    private int height;
    public PathView(Context context) {
        this(context,null);
    }

    public PathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public void initPaint(){
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    private void drawCoordinate(Canvas canvas){
        // 绘制坐标系
        CanvasAidUtils.set2DAxisLength(300, 300, 400, 400);
        CanvasAidUtils.draw2DCoordinateSpace(canvas);
        CanvasAidUtils.setLineColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.translate(width / 2,height / 2);
        drawCoordinate(canvas);

        testAddPath(canvas);
    }

    private void testAddPath(Canvas canvas){
        Path path = new Path();
        Path src = new Path();

        path.addRect(-200,-200,200,200,Path.Direction.CW);
        src.addCircle(0,0,100, Path.Direction.CW);

        path.addPath(src,0,200);
        canvas.drawPath(path,paint);
    }

    private void testAddRect(Canvas canvas){
        Path path = new Path();
        path.addRect(-200,-200,200,200, Path.Direction.CW);
        canvas.drawPath(path,paint);
    }

    private void testMoveTo(Canvas canvas){
        Path path = new Path();
        path.lineTo(200,200);
        path.lineTo(400,300);
        path.moveTo(500,400);
        path.lineTo(500,0);
        canvas.drawPath(path,paint);
    }

    private void testSetLastPoint(Canvas canvas){
        Path path = new Path();
        path.lineTo(200,200);
        path.lineTo(400,300);
        path.setLastPoint(500,400);
        path.lineTo(500,0);
        canvas.drawPath(path,paint);
    }

    private void testClose(Canvas canvas){
        Path path = new Path();
        path.lineTo(200,200);
        path.lineTo(400,300);
        path.lineTo(500,0);
        path.close();
        canvas.drawPath(path,paint);
    }

}
