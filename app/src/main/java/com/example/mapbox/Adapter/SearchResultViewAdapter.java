package com.example.mapbox.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mapbox.Model.SearchResult;
import com.example.mapbox.R;

import java.util.List;

public class SearchResultViewAdapter extends RecyclerView.Adapter<SearchResultViewAdapter.ViewHolder> {

    private List<SearchResult> searchResults;

    public SearchResultViewAdapter(List<SearchResult> searchResults) {
        this.searchResults = searchResults;
    }
    public void updateResult(List<SearchResult> searchResults) {
        this.searchResults = searchResults;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvText;
        public TextView tvPlaceName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.tvText);
            tvPlaceName = itemView.findViewById(R.id.tvPlaceName);
        }
    }

    @NonNull
    @Override
    public SearchResultViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                                 int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View resultView = layoutInflater.inflate(R.layout.layout_recyclerview, parent, false);
        ViewHolder viewHolder = new ViewHolder(resultView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchResultViewAdapter.ViewHolder holder, int position) {
        final SearchResult searchResult = searchResults.get(position);
        TextView tvText = holder.tvText;
        tvText.setText(searchResult.getText());
        TextView tvPlaceName = holder.tvPlaceName;
        tvPlaceName.setText(searchResult.getPlaceName());
    }

    @Override
    public int getItemCount() {
        return searchResults.size();
    }
}
