package com.example.practicedrawone.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

import androidx.annotation.Nullable;

public class Practice2DrawCircleView extends View {
    private Paint mCirclePaint;

    private float mRoundXLineOne;
    private float mRoundXLineTwo;
    private float mRoundYLineOne;
    private float mRoundYLineTwo;



    private float mRadius;
    private float mPadding;
    private float mCircleStokeWith;

    public Practice2DrawCircleView(Context context) {
        this(context, null);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        mPadding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, displayMetrics);
        mCircleStokeWith = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, displayMetrics);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        int length = Math.min(getWidth(), getHeight());
        mRadius = (length - (mPadding * 3)) / 4;
        mRoundXLineOne = mPadding + mRadius;
        mRoundXLineTwo = getWidth() - mRoundXLineOne;
        mRoundYLineOne = mRoundXLineOne;
        mRoundYLineTwo = getHeight() - mRoundXLineOne;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆

        mCirclePaint.setColor(Color.BLACK);
        canvas.drawCircle(mRoundXLineOne, mRoundYLineOne, mRadius, mCirclePaint);

        mCirclePaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(mRoundXLineTwo, mRoundYLineOne, mRadius, mCirclePaint);

        mCirclePaint.setStyle(Paint.Style.FILL);
        mCirclePaint.setColor(Color.BLUE);
        canvas.drawCircle(mRoundXLineOne, mRoundYLineTwo, mRadius, mCirclePaint);

        mCirclePaint.setStyle(Paint.Style.STROKE);
        mCirclePaint.setColor(Color.BLACK);
        mCirclePaint.setStrokeWidth(mCircleStokeWith);
        float radius = mRadius - mCircleStokeWith;
        canvas.drawCircle(mRoundXLineTwo, mRoundYLineTwo, radius > 0 ? radius : mRadius, mCirclePaint);
    }
}
