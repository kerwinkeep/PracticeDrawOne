package com.example.practicedrawone.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Practice4DrawPointView extends View {

    private Paint mPointPaint;

    public Practice4DrawPointView(Context context) {
        this(context, null);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPointPaint = new Paint();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mPointPaint.setStrokeWidth(Math.min(w, h) * 0.1f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPoint() 方法画点
//        一个圆点，一个方点
//        圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点
        float baseLengthX = getWidth() / 3f;
        float y = getHeight() >>> 1;
        mPointPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(baseLengthX, y, mPointPaint);
        mPointPaint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(baseLengthX + baseLengthX, y, mPointPaint);
    }
}
