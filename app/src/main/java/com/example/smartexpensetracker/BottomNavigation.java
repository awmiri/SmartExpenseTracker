
package com.example.smartexpensetracker;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;

public class BottomNavigation {

    private final Activity activity;
    private final int currentTab;

    public BottomNavigation(Activity activity, int currentTab) {
        this.activity = activity;
        this.currentTab = currentTab;

        setupNavigation();
        updateSelectedTab();
    }

    private void setupNavigation() {
        setClick(R.id.tabTransaction, TransactionsActivity.class, 0);
        setClick(R.id.tabCategories, CategoriesActivity.class, 1);
        setClick(R.id.tabHome, MainActivity.class, 2);
        setClick(R.id.tabAnalytics, AnalyticsActivity.class, 3);
        setClick(R.id.tabProfile, ProfileActivity.class, 4);
    }

    private void setClick(int tabId, Class<?> destination, int tabIndex) {
        View tab = activity.findViewById(tabId);

        if (tab == null) {
            return;
        }

        tab.setOnClickListener(v -> {
            if (tabIndex == currentTab) {
                return;
            }

            Intent intent = new Intent(activity, destination);
            activity.startActivity(intent);
        });
    }

    private void updateSelectedTab() {
        int[] iconIds = {
                R.id.iconTransaction,
                R.id.iconCategory,
                R.id.iconHome,
                R.id.iconAnalytics,
                R.id.iconProfile
        };

        int activeColor = Color.parseColor("#477A61");
        int inactiveColor = Color.parseColor("#ced4da");

        for (int i = 0; i < iconIds.length; i++) {
            ImageView icon = activity.findViewById(iconIds[i]);

            if (icon == null) {
                continue;
            }

            if (i == currentTab) {
                icon.setColorFilter(activeColor);
                icon.setAlpha(1f);
            } else {
                icon.setColorFilter(inactiveColor);
                icon.setAlpha(0.65f);
            }
        }
    }
}
