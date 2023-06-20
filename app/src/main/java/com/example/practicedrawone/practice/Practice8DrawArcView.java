package com.example.practicedrawone.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Practice8DrawArcView extends View {

    private Paint mArcPaint;

    public Practice8DrawArcView(Context context) {
        this(context, null);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mArcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        float baseLengthX = getWidth() / 3f;
        float baseLengthY = getHeight() / 4f;
        canvas.drawArc(baseLengthX, baseLengthY * 2, baseLengthX * 2, baseLengthY * 3, -25f, -90f, true, mArcPaint);
        canvas.drawArc(baseLengthX, baseLengthY * 2, baseLengthX * 2, baseLengthY * 3, 25f, 120f, false, mArcPaint);
        mArcPaint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(baseLengthX, baseLengthY * 2, baseLengthX * 2, baseLengthY * 3, 160f, 60, false, mArcPaint);

    }
}
