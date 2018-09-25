package com.ygsoft.utilslib.utils;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Created by mopengfei on 2018-09-21.
 */

public class NumberFormatter {
    /**
     * 保留两位小数patten
     */
    public static final String PATTEN_KEEP_TWO_DECIMAL_PLACES = "##########0.00";

    private DecimalFormat decimalFormat;

    private NumberFormatter(Builder builder) {

        DecimalFormatSymbols formatSymbols = DecimalFormatSymbols.getInstance(builder.locale);
        decimalFormat = new DecimalFormat();
        //最多整数位10位
        decimalFormat.setMaximumIntegerDigits(builder.maxIntDigits);
        //最少整数位
        decimalFormat.setMinimumIntegerDigits(builder.minIntDigits);
        //最多小数位
        decimalFormat.setMaximumFractionDigits(builder.maxFractionDigits);
        //最少小数位
        decimalFormat.setMinimumFractionDigits(builder.minFractionDigits);
        //数字分组
        decimalFormat.setGroupingSize(builder.groupingSize);
        //是否使用分组
        decimalFormat.setGroupingUsed(builder.groupingUsed);
        //格式化模式
        if (!TextUtils.isEmpty(builder.patten)) {
            decimalFormat.applyPattern(builder.patten);
        }
        decimalFormat.setDecimalFormatSymbols(formatSymbols);
    }

    public String format(double number) {
        return decimalFormat.format(number);
    }

    public DecimalFormat getDecimalFormat() {
        return decimalFormat;
    }

    public static class Builder {
        private Locale locale;
        private String patten = "";
        private int maxIntDigits = 10;
        private int minIntDigits = 1;
        private int maxFractionDigits = 16;
        private int minFractionDigits = 0;
        private int groupingSize = 3;
        private boolean groupingUsed = true;

        public Builder(@NonNull Locale locale) {
            this.locale = locale;
        }

        public Builder() {
            this(Locale.getDefault());
        }

        public Builder setMaximumIntegerDigits(int maxIntDigits) {
            this.maxIntDigits = maxIntDigits;
            return this;
        }

        public Builder setMinimumIntegerDigits(int minIntDigits) {
            this.minIntDigits = minIntDigits;
            return this;
        }

        public Builder setMaximumFractionDigits(int maxFractionDigits) {
            this.maxFractionDigits = maxFractionDigits;
            return this;
        }

        public Builder setMinimumFractionDigits(int minFractionDigits) {
            this.minFractionDigits = minFractionDigits;
            return this;
        }

        public Builder setGroupingSize(int groupingSize) {
            this.groupingSize = groupingSize;
            return this;
        }

        public Builder setGroupingUsed(boolean groupingUsed) {
            this.groupingUsed = groupingUsed;
            return this;
        }

        public Builder applyPattern(String patten) {
            this.patten = patten;
            return this;
        }

        public NumberFormatter build() {
            return new NumberFormatter(this);
        }
    }

}
