package demo.jadyn.cm.pullarclayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class ArcContainer extends RelativeLayout {

    Context mContext;

    Path mClipPath;

    int width = 0;
    int height = 0;

    Paint mPaint;
    private PorterDuffXfermode porterDuffXfermode;

    private int orignalHeight;
    private boolean firstGetHeight = true;

    public ArcContainer(Context context) {
        super(context);
        init(context, null);
    }

    public ArcContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mContext = context;

        porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.WHITE);
        mClipPath = new Path();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        width = getMeasuredWidth();
        height = getMeasuredHeight();


        if (firstGetHeight) {
            orignalHeight = height;
            firstGetHeight = false;
        }
        mClipPath = PathProvider.getClipPath(width, height, orignalHeight);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        
        int saveCount = canvas.saveLayer(0, 0, getMeasuredWidth(), getMeasuredHeight(), null, Canvas.ALL_SAVE_FLAG);
        super.dispatchDraw(canvas);
        mPaint.setXfermode(porterDuffXfermode);
        canvas.drawPath(mClipPath, mPaint);
        mPaint.setXfermode(null);
        canvas.restoreToCount(saveCount);
    }
}
