FxAdapter
----

使得 recyclerview 的 adapter 更加易用，省去viewholder：


#Download：

   	compile 'com.github.fxx028:FxAdapter:1.0' 
   	
   	
#Usage:

       private CommonAdapter<String> adapter;
       private List<String> list = new ArrayList<>();
       nineRecyclerview.setLayoutManager(new FullyLinearLayoutManager(this,3));
       adapter = new CommonAdapter<String>(this, R.layout.item_outappraise_problem_img, list) {
            @Override
            protected void convert(ViewHolder viewHolder, String s, int i) {
              // viewHolder.setText(int viewId, String text);
              // viewHolder.setVisible(int viewId, boolean visible)
              // viewHolder.setImageResource(int viewId, int resId)
              .
              .
              .
            }
        };
        nineRecyclerview.setAdapter(adapter);
