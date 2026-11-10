package com.example.smartexpensetracker;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
public class SpendingDonutView extends View {
    private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private  final RectF rect = new RectF();

    private final float[] values = {
            30,40,20,10
    };

    private final int[] colors = {
            0xFF34745C, // Forest Green
            0xFF83B69A, // Fresh Sage
            0xFFE3B66D, // Warm Gold
            0xFFD58D91  // Dusty Rose
    };
    private float total = 100;

    public SpendingDonutView(Context context) {
        super(context);
        init();
    }

    public SpendingDonutView(Context context , AttributeSet attrs) {
        super(context , attrs);
        init();
    }

    public SpendingDonutView(
            Context context,
            AttributeSet attrs,
            int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setStrokeWidth(dp(22));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float size = Math.min(getWidth(), getHeight());

        float centerX = getWidth() / 2f;
        float centerY = getHeight() / 2f;

        float radius = size / 2f - dp(20);

        rect.set(
                centerX - radius,
                centerY - radius,
                centerX + radius,
                centerY + radius
        );

        float startAngle = -90f;

        for (int i = 0; i < values.length; i++) {

            float sweepAngle = (values[i] / total) * 360f;

            paint.setColor(colors[i]);

            canvas.drawArc(
                    rect,
                    startAngle,
                    sweepAngle,
                    false,
                    paint
            );

            startAngle += sweepAngle;
        }
    }

    private float dp(float value) {
        return value * getResources()
                .getDisplayMetrics().density;
    }


}
