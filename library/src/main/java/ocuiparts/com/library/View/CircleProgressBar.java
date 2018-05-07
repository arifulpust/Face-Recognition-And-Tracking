package ocuiparts.com.library.View;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import ocuiparts.com.library.R;


public class CircleProgressBar extends View {

    private boolean isShowThree = false;
    private int strokeColor = 0xFFFC6B2A;
    private int strokeWidth = 10;
    private int fillColor = 0XFC6B2A;
    private int circleGap = 10;
    private float currentProgress = 0;
    private Paint progressPaint;
    private RectF progressBounds;
    private Bitmap tempBitmap;
    private Canvas tempCanvas;
    private boolean isProgress = false;
    private int apartCircle = 110;
    private Animation animation = null;
    public CircleProgressBar(Context context) {
        this(context, null);
    }

    public CircleProgressBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CircleProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        if(attrs !=null) {

            TypedArray aTypedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleProgressBar);
            if(aTypedArray != null) {
                strokeColor = aTypedArray.getColor(R.styleable.CircleProgressBar_strokeColorPro, strokeColor);
                strokeWidth = aTypedArray.getDimensionPixelSize(R.styleable.CircleProgressBar_strokeWidthPro, strokeWidth);
                fillColor = aTypedArray.getColor(R.styleable.CircleProgressBar_fillColorPro, fillColor);
                circleGap = aTypedArray.getInt(R.styleable.CircleProgressBar_circleGapPro, circleGap);
                isShowThree = aTypedArray.getBoolean(R.styleable.CircleProgressBar_isShowThree,isShowThree);
            }

            aTypedArray.recycle();
        }
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CircleProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        if(attrs !=null) {

            TypedArray aTypedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleProgressBar);
            if(aTypedArray != null) {
                strokeColor = aTypedArray.getColor(R.styleable.CircleProgressBar_strokeColorPro, strokeColor);
                strokeWidth = aTypedArray.getDimensionPixelSize(R.styleable.CircleProgressBar_strokeWidthPro, strokeWidth);
                fillColor = aTypedArray.getColor(R.styleable.CircleProgressBar_fillColorPro, fillColor);
                circleGap = aTypedArray.getInt(R.styleable.CircleProgressBar_circleGapPro, circleGap);
                isShowThree = aTypedArray.getBoolean(R.styleable.CircleProgressBar_isShowThree,isShowThree);
            }

            aTypedArray.recycle();
        }
        init();
    }

    private void init() {
        if(isShowThree) {
            apartCircle = 360/3 - circleGap;
        }
        initProgressPaint();

    }

    private void initAnimation() {
        animation = new RotateAnimation(0.0f, 36000.0f, getWidth()/2, getHeight()/2);

        animation.setDuration(100000);
        animation.setRepeatCount(ValueAnimator.INFINITE);
        animation.setInterpolator(new LinearInterpolator());

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        updateProgressBounds();
        resetTempCanvas();
        initAnimation();
        startAnimation(animation);
    }

    private void updateProgressBounds() {
        progressBounds = new RectF(
                strokeWidth, strokeWidth,
                getWidth() - strokeWidth, getWidth() - strokeWidth
        );
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawArcForCurrentProgress();
        int w = this.getWidth();
        int h = this.getHeight();

        int ox = w/2;
        int oy = h/2;
        canvas.drawBitmap(tempBitmap, 0, 0, null);

    }

    public void resetTempCanvas() {
        tempBitmap = Bitmap.createBitmap(getWidth(), getWidth(), Bitmap.Config.ARGB_8888);
        tempCanvas = new Canvas(tempBitmap);

    }
    private void drawArcForCurrentProgress() {
        if(isShowThree) {
            tempCanvas.drawArc(progressBounds, 0f, apartCircle , false, progressPaint);
            tempCanvas.drawArc(progressBounds, 120f, apartCircle , false, progressPaint);
            tempCanvas.drawArc(progressBounds, 240f, apartCircle , false, progressPaint);
        } else {
            tempCanvas.drawArc(progressBounds, 0, 360 - circleGap , false, progressPaint);
        }

    }

    private void initProgressPaint()
    {
        progressPaint = new Paint();
        progressPaint.setAntiAlias(true);
        progressPaint.setStrokeWidth(strokeWidth);
        progressPaint.setColor(strokeColor);
        progressPaint.setStyle(Paint.Style.STROKE);
    }

    public boolean isShowThree() {
        return isShowThree;
    }

    public void setShowStroke(boolean showStroke) {
        isShowThree = showStroke;
    }

    public int getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public int getFillColor() {
        return fillColor;
    }

    public void setFillColor(int fillColor) {
        this.fillColor = fillColor;
    }

    public int getCircleGap() {
        return circleGap;
    }

    public void setCircleGap(int circleGap) {
        this.circleGap = circleGap;
    }

    public float getCurrentProgress() {
        return currentProgress;
    }

    public void setCurrentProgress(float currentProgress) {
        this.currentProgress = currentProgress;
        postInvalidate();
    }

}

