package com.practice.listtypeapp.ui.post;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.practice.listtypeapp.BR;
import com.practice.listtypeapp.R;
import com.practice.listtypeapp.util.ViewBindingHolder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/*
* 게시 글 목록을 휘한 Adapter
* */
public class PostAdapter extends RecyclerView.Adapter<ViewBindingHolder> {

    private final List<PostItem> items = new ArrayList<>();

    // 생성자 인젝션
    @Inject
    public PostAdapter(){

    }

    //레이아웃 종류
    @Override
    public int getItemViewType(int position){
        return R.layout.view_post;
    }

    // 뷰 홀더 생성
    @NonNull
    @Override
    public ViewBindingHolder<?> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewBindingHolder(parent.getContext(), viewType);
    }


    // 뷰 홀더와 뷰 모델을 바인딩
    @Override
    public void onBindViewHolder(@NonNull ViewBindingHolder holder, int position) {
        holder.getBinding().setVariable(BR.item, items.get(position));
        holder.getBinding().executePendingBindings();
    }

    // 외부로부터 게시 글 목록을 받아서 UI를 갱신
    public void setItems(List<PostItem> items){
        this.items.clear();
        this.items.addAll(items);
        this.notifyDataSetChanged();
    }

    //게시글 목록 수
    @Override
    public int getItemCount() {
        return items.size();
    }

}
