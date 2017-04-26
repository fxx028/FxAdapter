package com.fxx.fxadapter;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.fxx.fxadapterlibrary.CommonAdapter;
import com.fxx.fxadapterlibrary.MultiItemTypeAdapter;
import com.fxx.fxadapterlibrary.base.ItemViewDelegate;
import com.fxx.fxadapterlibrary.base.ViewHolder;
import com.fxx.fxadapterlibrary.wrapper.HeaderAndFooterWrapper;
import com.fxx.fxadapterlibrary.wrapper.LoadMoreWrapper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private LoadMoreWrapper mLoadMoreWrapper;
    private List<ChatMessage> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mDatas.addAll(ChatMessage.MOCK_DATAS);

        ChatAdapterForRv adapter = new ChatAdapterForRv(this, mDatas);

        mLoadMoreWrapper = new LoadMoreWrapper(adapter);
        mLoadMoreWrapper.setLoadMoreView(LayoutInflater.from(this).inflate(R.layout.default_loading, mRecyclerView, false));
        mLoadMoreWrapper.setOnLoadMoreListener(new LoadMoreWrapper.OnLoadMoreListener()
        {
            @Override
            public void onLoadMoreRequested()
            {
                new Handler().postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        boolean coming = Math.random() > 0.5;
                        ChatMessage msg = null;
                        msg = new ChatMessage(coming ? R.drawable.renma : R.drawable.xiaohei, coming ? "人马" : "xiaohei", "where are you " + mDatas.size(),
                                null, coming);
                        mDatas.add(msg);
                        mLoadMoreWrapper.notifyDataSetChanged();

                    }
                }, 3000);
            }
        });

        adapter.setOnItemClickListener(new CommonAdapter.OnItemClickListener()
        {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder,  int position)
            {
                Toast.makeText(MainActivity.this, "Click:" + position , Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position)
            {
                Toast.makeText(MainActivity.this, "LongClick:" + position , Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        mRecyclerView.setAdapter(mLoadMoreWrapper);
    }

}
