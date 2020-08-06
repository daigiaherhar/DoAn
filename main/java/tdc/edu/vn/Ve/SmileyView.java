package tdc.edu.vn.Ve;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class SmileyView extends View {
    private Paint mCirclePaint;
    private Paint mBauTroi;
    private Paint mCay;
    private Paint mMatTroi;
    private Paint mLa;


    private float mCenterX;
    private float mCenterY;
    private float mRadius;
    private RectF mArcBounds = new RectF();
    Path path = new Path();
    Paint paint = new Paint();

    public SmileyView(Context context) {
        this(context, null);
    }

    public SmileyView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SmileyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaints();
    }

    @SuppressLint("ResourceAsColor")
    private void initPaints() {

        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint.setStyle(Paint.Style.FILL);
        mCirclePaint.setColor(Color.YELLOW);
        mBauTroi = new Paint(Paint.START_HYPHEN_EDIT_INSERT_ZWJ);
        mBauTroi.setStyle(Paint.Style.FILL);
        mBauTroi.setStrokeWidth(10 * getResources().getDisplayMetrics().density);
        mBauTroi.setStrokeCap(Paint.Cap.ROUND);
        mBauTroi.setColor(Color.rgb(21, 232, 244));


        mCay = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCay.setStyle(Paint.Style.FILL);
        mCay.setStrokeWidth(2 * getResources().getDisplayMetrics().density);
        mCay.setStrokeCap(Paint.Cap.ROUND);
        mCay.setColor(Color.rgb(165, 83, 7));

        mMatTroi = new Paint(Paint.ANTI_ALIAS_FLAG);
        mMatTroi.setStyle(Paint.Style.FILL);
        mMatTroi.setStrokeWidth(10 * getResources().getDisplayMetrics().density);
        mMatTroi.setStrokeCap(Paint.Cap.ROUND);
        mMatTroi.setColor(Color.rgb(215, 24, 24));

        mLa = new Paint(Paint.ANTI_ALIAS_FLAG);
        mLa.setStyle(Paint.Style.FILL);
        mLa.setStrokeWidth(10 * getResources().getDisplayMetrics().density);
        mLa.setStrokeCap(Paint.Cap.ROUND);
        mLa.setColor(Color.GREEN);


        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5 * getResources().getDisplayMetrics().density);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);
        int size = Math.min(w, h);
        setMeasuredDimension(size, size);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //canvas.drawCircle(mCenterX, mCenterY, mRadius, mCirclePaint);
        // draw eyesx<
        float eyeRadius = mRadius / 5f;

//        for (int x = 800; x >= 5; x = x - 5) {
//            for (int y = 200; y <= 800; y = y + 5) {
//                canvas.drawPoint(x, y, mEyeAndMouthPaint);
////                canvas.drawPoint(395,75,mEyeAndMouthPaint);
//            }
//        }
        canvas.drawRect(1, 1, 770, 300, mBauTroi);
        canvas.drawCircle(450, 100, eyeRadius, mMatTroi);

        mBauTroi.setColor(Color.rgb(177,243,237));
        canvas.drawRect(1, 300, 770, 800, mBauTroi);


        canvas.drawRect(60, 600, 100, 800, mCay);
        canvas.drawCircle(80, 550, eyeRadius, mLa);
        canvas.drawRect(660, 600, 700, 800, mCay);
        canvas.drawCircle(680, 550, eyeRadius, mLa);

        //duong
        mCay.setColor(Color.rgb(88,88,88));
        canvas.drawRect(260, 300, 500, 800, mCay);

        mCay.setColor(Color.WHITE);
        canvas.drawRect(270, 580, 290, 640, mCay);
        mCay.setColor(Color.WHITE);
        canvas.drawRect(320, 580, 340, 640, mCay);
        mCay.setColor(Color.WHITE);
        canvas.drawRect(370, 580, 390, 640, mCay);
        mCay.setColor(Color.WHITE);
        canvas.drawRect(420, 580, 440, 640, mCay);
        mCay.setColor(Color.WHITE);
        canvas.drawRect(470, 580, 490, 640, mCay);
        // canvas.drawPoint(400, 500, mEyeAndMouthPaint);

        //giam toc
        mCay.setColor(Color.YELLOW);
        mBauTroi.setColor(Color.BLACK);
        canvas.drawRect(260, 400, 500, 410, mCay);
        canvas.drawRect(280, 400, 290, 410, mBauTroi);
        canvas.drawRect(340, 400, 350, 410, mBauTroi);
        canvas.drawRect(400, 400, 410, 410, mBauTroi);
        canvas.drawRect(460, 400, 470, 410, mBauTroi);

        canvas.drawRect(260, 380, 500, 390, mCay);
        canvas.drawRect(280, 380, 290, 390, mBauTroi);
        canvas.drawRect(340, 380, 350, 390, mBauTroi);
        canvas.drawRect(400, 380, 410, 390, mBauTroi);
        canvas.drawRect(460, 380, 470, 390, mBauTroi);

        canvas.drawRect(260, 360, 500, 370, mCay);
        canvas.drawRect(280, 360, 290, 370, mBauTroi);
        canvas.drawRect(340, 360, 350, 370, mBauTroi);
        canvas.drawRect(400, 360, 410, 370, mBauTroi);
        canvas.drawRect(460, 360, 470, 370, mBauTroi);
        //reset lai mau` khi ve~ se k bi sai mau` mac dinh
        mCay.setColor(Color.rgb(165, 83, 7));
        mBauTroi.setColor(Color.rgb(21, 232, 244));

        canvas.drawPath(path, paint);
        canvas.save();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mCenterX = w / 2f;
        mCenterY = h / 2f;
        mRadius = Math.min(w, h) / 2f;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float eventX = event.getX();
        float eventY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(eventX, eventY);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(eventX, eventY);
                break;
//            case MotionEvent.ACTION_UP:
//                path.addCircle(eventX, eventY, 10, Path.Direction.CW);
//                break;
            case MotionEvent.ACTION_CANCEL: {
                path.addCircle(eventX, eventY, 10, Path.Direction.CW);
                break;
            }
            default:
                return false;
        }
        invalidate();
        return true;
    }
}
