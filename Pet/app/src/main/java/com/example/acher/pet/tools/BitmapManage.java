package com.example.acher.pet.tools;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by Acher on 2016/1/25.
 */


public class BitmapManage {
    //将图片等化成圆形圆角  pixels=600 是即为圆形显示
    public static Bitmap toRoundCorner(Bitmap bitmap ,int pixels){
        Bitmap output=Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(),Bitmap.Config.ARGB_8888);

        Canvas canvas=new Canvas(output);

        final int color = 0xff424242;
        final Paint paint=new Paint();
        final Rect rect=new Rect(0,0,bitmap.getWidth(),bitmap.getHeight());
        final RectF rectF=new RectF(rect);
        final float roundPx=pixels;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap,rect,rect,paint);


        return output;

    }
}
