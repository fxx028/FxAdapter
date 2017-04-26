package com.fxx.fxadapterlibrary.base;


import android.view.View;


/**
 * Created by 冯焮
 * Time：2017/4/26 0026
 * instruction：
 */
public interface ItemViewDelegate<T>
{

    int getItemViewLayoutId();

    boolean isForViewType(T item, int position);

    void convert(ViewHolder holder, T t, int position);

}
