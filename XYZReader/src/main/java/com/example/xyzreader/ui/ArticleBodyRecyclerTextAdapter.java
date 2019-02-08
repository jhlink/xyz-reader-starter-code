package com.example.xyzreader.ui;

import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.LeadingMarginSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xyzreader.R;

import java.util.List;

public class ArticleBodyRecyclerTextAdapter extends RecyclerView.Adapter<ArticleBodyRecyclerTextAdapter.ViewHolder> {

    private List<String> mValues;

    public ArticleBodyRecyclerTextAdapter(List<String> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_article_body_tv, parent, false);
        return new ViewHolder(view);
    }

    private SpannableString applyParagraphStyling(String input) {
        LeadingMarginSpan span = new LeadingMarginSpan.Standard(100, 0); // right exmaple
        SpannableString spannableString = new SpannableString(input);
        spannableString.setSpan(span, 0, spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        SpannableString styledText = applyParagraphStyling(mValues.get(position));
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(styledText);

    }

    public void setValues(List<String> items) {
        mValues = items;
    }

    @Override
    public int getItemCount() {
        Log.d("ADAPTER", "" + mValues.size());
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentView;
        public String mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mContentView = (TextView) view.findViewById(R.id.tv_article_body_item);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
