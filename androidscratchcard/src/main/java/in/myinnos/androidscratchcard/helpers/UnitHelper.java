package in.myinnos.androidscratchcard.helpers;

import android.content.Context;
import android.util.DisplayMetrics;

public class UnitHelper {

    private static DisplayMetrics mDisplayMetrics;

    public static void initialize(Context context) {
        mDisplayMetrics = context.getResources().getDisplayMetrics();
    }

    public static float pxToDip(float pxValue) {
        return pxValue / mDisplayMetrics.density;
    }

    public static float dipToPx(float dipValue) {
        return dipValue * mDisplayMetrics.density;
    }

    public static int dipToPxInt(float dipValue) {
        return MathHelper.pixel(dipValue * mDisplayMetrics.density);
    }

    public static float pxToSp(float pxValue) {
        return pxValue / mDisplayMetrics.scaledDensity;
    }

    public static float spToPx(float spValue) {
        return spValue * mDisplayMetrics.scaledDensity;
    }

    public static int spToPxInt(float spValue) {
        return MathHelper.pixel(spValue * mDisplayMetrics.scaledDensity);
    }

    public static float pxToPt(float pxValue) {
        return pxValue / mDisplayMetrics.xdpi * 72f;
    }

    public static float ptToPx(float ptValue) {
        return ptValue * mDisplayMetrics.xdpi / 72f;
    }

    public static int ptToPxInt(float ptValue) {
        return MathHelper.pixel(ptValue * mDisplayMetrics.xdpi / 72f);
    }

    public static float pxToIn(float pxValue) {
        return pxValue / mDisplayMetrics.xdpi;
    }

    public static float inToPx(float inValue) {
        return inValue * mDisplayMetrics.xdpi;
    }

    public static int inToPxInt(float inValue) {
        return MathHelper.pixel(inValue * mDisplayMetrics.xdpi);
    }

    public static float pxToMm(float pxValue) {
        return pxValue / mDisplayMetrics.xdpi * 25.4f;
    }

    public static float mmToPx(float mmValue) {
        return mmValue * mDisplayMetrics.xdpi / 25.4f;
    }

    public static float mmToPxInt(float mmValue) {
        return MathHelper.pixel(mmValue * mDisplayMetrics.xdpi / 25.4f);
    }

    public static float pxToDip(Context context, float pxValue) {
        float density = context.getResources().getDisplayMetrics().density;
        return pxValue / density;
    }

    public static float dipToPx(Context context, float dipValue) {
        float density = context.getResources().getDisplayMetrics().density;
        return dipValue * density;
    }

    public static int dipToPxInt(Context context, float dipValue) {
        float density = context.getResources().getDisplayMetrics().density;
        return MathHelper.pixel(dipValue * density);
    }

    public static float pxToSp(Context context, float pxValue) {
        float scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
        return pxValue / scaledDensity;
    }

    public static float spToPx(Context context, float spValue) {
        float scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
        return spValue * scaledDensity;
    }

    public static int spToPxInt(Context context, float spValue) {
        float scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
        return MathHelper.pixel(spValue * scaledDensity);
    }

    public static float pxToPt(Context context, float pxValue) {
        float xdpi = context.getResources().getDisplayMetrics().xdpi;
        return pxValue / xdpi * 72f;
    }

    public static float ptToPx(Context context, float ptValue) {
        float xdpi = context.getResources().getDisplayMetrics().xdpi;
        return ptValue * xdpi / 72f;
    }

    public static int ptToPxInt(Context context, float ptValue) {
        float xdpi = context.getResources().getDisplayMetrics().xdpi;
        return MathHelper.pixel(ptValue * xdpi / 72);
    }

    public static float pxToIn(Context context, float pxValue) {
        float xdpi = context.getResources().getDisplayMetrics().xdpi;
        return pxValue / xdpi;
    }

    public static float inToPx(Context context, float inValue) {
        float xdpi = context.getResources().getDisplayMetrics().xdpi;
        return inValue * xdpi;
    }

    public static int inToPxInt(Context context, float inValue) {
        float xdpi = context.getResources().getDisplayMetrics().xdpi;
        return MathHelper.pixel(inValue * xdpi);
    }

    public static float pxToMm(Context context, float pxValue) {
        float xdpi = context.getResources().getDisplayMetrics().xdpi;
        return pxValue / xdpi * 25.4f;
    }

    public static float mmToPx(Context context, float mmValue) {
        float xdpi = context.getResources().getDisplayMetrics().xdpi;
        return mmValue * xdpi / 25.4f;
    }

    public static float mmToPxInt(Context context, float mmValue) {
        float xdpi = context.getResources().getDisplayMetrics().xdpi;
        return MathHelper.pixel(mmValue * xdpi / 25.4f);
    }

}