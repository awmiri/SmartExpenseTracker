
package com.example.smartexpensetracker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class PersonalHeaderView extends LinearLayout {

    private TextView tvHeaderEyebrow;
    private TextView tvHeaderTitle;
    private TextView tvHeaderSubtitle;
    private View btnHeaderBack;

    public PersonalHeaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        LayoutInflater.from(context).inflate(
                R.layout.view_personal_header_content,
                this,
                true
        );

        tvHeaderEyebrow = findViewById(R.id.tvHeaderEyebrow);
        tvHeaderTitle = findViewById(R.id.tvHeaderTitle);
        tvHeaderSubtitle = findViewById(R.id.tvHeaderSubtitle);
        btnHeaderBack = findViewById(R.id.btnHeaderBack);

        if (attrs != null) {

            android.content.res.TypedArray typedArray =
                    context.obtainStyledAttributes(
                            attrs,
                            R.styleable.PersonalHeaderView
                    );

            String eyebrow = typedArray.getString(
                    R.styleable.PersonalHeaderView_personalHeaderEyebrow
            );

            String title = typedArray.getString(
                    R.styleable.PersonalHeaderView_personalHeaderTitle
            );

            String subtitle = typedArray.getString(
                    R.styleable.PersonalHeaderView_personalHeaderSubtitle
            );

            if (eyebrow != null) {
                tvHeaderEyebrow.setText(eyebrow);
            }

            if (title != null) {
                tvHeaderTitle.setText(title);
            }

            if (subtitle != null) {
                tvHeaderSubtitle.setText(subtitle);
            }

            typedArray.recycle();
        }
    }

    public void setHeaderTitle(String title) {
        tvHeaderTitle.setText(title);
    }

    public void setHeaderSubtitle(String subtitle) {
        tvHeaderSubtitle.setText(subtitle);
    }

    public void setHeaderEyebrow(String eyebrow) {
        tvHeaderEyebrow.setText(eyebrow);
    }

    public void setOnBackClickListener(OnClickListener listener) {
        btnHeaderBack.setOnClickListener(listener);
    }
}
