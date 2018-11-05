package in.myinnos.androidscratchcard;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import in.myinnos.androidscratchcard.helpers.UnitHelper;

public class ScratchCard extends View {

    public interface OnScratchListener {
        public void onScratch(ScratchCard scratchCard, float visiblePercent);
    }

    public ScratchCard(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        resolveAttr(context, attrs);
    }

    public ScratchCard(Context context, AttributeSet attrs) {
        super(context, attrs);
        resolveAttr(context, attrs);
    }

    public ScratchCard(Context context) {
        super(context);
        resolveAttr(context, null);
    }

    private void resolveAttr(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ScratchCard);
        mDrawable = a.getDrawable(R.styleable.ScratchCard_scratchDrawable);
        mScratchWidth = a.getDimension(R.styleable.ScratchCard_scratchWidth, UnitHelper.dipToPx(context, 20));
        a.recycle();
    }

    private Drawable mDrawable;
    private float mScratchWidth;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Path mPath;
    private Paint mInnerPaint;
    private Paint mOuterPaint;
    private OnScratchListener mListener;

    public void setScratchDrawable(Drawable drawable) {
        mDrawable = drawable;
    }

    public void setScratchWidth(float width) {
        mScratchWidth = width;
    }

    public void setOnScratchListener(OnScratchListener listener) {
        mListener = listener;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if (mBitmap != null)
            mBitmap.recycle();

        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);

        if (mDrawable != null) {
            mDrawable.setBounds(0, 0, mBitmap.getWidth(), mBitmap.getHeight());
            mDrawable.draw(mCanvas);
        } else {
            mCanvas.drawColor(0xFFC0C0C0);
        }

        if (mPath == null) {
            mPath = new Path();
        }

        if (mInnerPaint == null) {
            mInnerPaint = new Paint();
            mInnerPaint.setAntiAlias(true);
            mInnerPaint.setDither(true);
            mInnerPaint.setStyle(Paint.Style.STROKE);
            mInnerPaint.setFilterBitmap(true);
            mInnerPaint.setStrokeJoin(Paint.Join.ROUND);
            mInnerPaint.setStrokeCap(Paint.Cap.ROUND);
            mInnerPaint.setStrokeWidth(mScratchWidth);
            mInnerPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        }

        if (mOuterPaint == null) {
            mOuterPaint = new Paint();
        }
    }

    private float mLastTouchX;
    private float mLastTouchY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float currentTouchX = event.getX();
        float currentTouchY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.reset();
                mPath.moveTo(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                float dx = Math.abs(currentTouchX - mLastTouchX);
                float dy = Math.abs(currentTouchY - mLastTouchY);
                if (dx >= 4 || dy >= 4) {
                    float x1 = mLastTouchX;
                    float y1 = mLastTouchY;
                    float x2 = (currentTouchX + mLastTouchX) / 2;
                    float y2 = (currentTouchY + mLastTouchY) / 2;
                    mPath.quadTo(x1, y1, x2, y2);
                }
                break;
            case MotionEvent.ACTION_UP:
                mPath.lineTo(currentTouchX, currentTouchY);
                if (mListener != null) {
                    int width = mBitmap.getWidth();
                    int height = mBitmap.getHeight();
                    int total = width * height;
                    int count = 0;
                    for (int i = 0; i < width; i += 3) {
                        for (int j = 0; j < height; j += 3) {
                            if (mBitmap.getPixel(i, j) == 0x00000000)
                                count++;
                        }
                    }
                    mListener.onScratch(this, ((float) count) / total * 9);
                }
                break;
        }

        mCanvas.drawPath(mPath, mInnerPaint);

        mLastTouchX = currentTouchX;
        mLastTouchY = currentTouchY;

        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mBitmap, 0, 0, mOuterPaint);
        super.onDraw(canvas);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mBitmap != null) {
            mBitmap.recycle();
            mBitmap = null;
        }
    }

}