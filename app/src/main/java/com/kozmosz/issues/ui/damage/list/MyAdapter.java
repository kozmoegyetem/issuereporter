package com.kozmosz.issues.ui.damage.list;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kozmosz.issues.R;
import com.kozmosz.issues.config.MainConfig;
import com.kozmosz.issues.model.DamageDTO;

import java.text.SimpleDateFormat;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<DamageDTO> mDataset;
    private SimpleDateFormat dfMMDD = new SimpleDateFormat("MM.dd");
    private SimpleDateFormat dfHHMM = new SimpleDateFormat("hh.mm");

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView title;
        public TextView roomNumber;
        public TextView status;
        public TextView description;

        public ViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.row_title);
            roomNumber = v.findViewById(R.id.row_roomNumber);
            status = v.findViewById(R.id.row_status);
            description = v.findViewById(R.id.row_description);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<DamageDTO> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.damage_list_row, parent, false);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = ((TextView) view.findViewById(R.id.row_title)).getText().toString();
                try {
                    Long id = getIdFromDatasetByName(title);
                    ((DamageListScreen) view.getContext()).navigateToDamageDetail(id);
                } catch (Exception e) {
                    Log.e(MainConfig.LOG_TAG, e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        return new ViewHolder(itemView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        if (mDataset == null) return;
        if (mDataset.size() == 0 || mDataset.get(position) == null) return;
        DamageDTO damageDTO = mDataset.get(position);
        holder.title.setText(damageDTO.getTitle());
        holder.roomNumber.setText(String.valueOf(damageDTO.getRoomNumber()));
        if (damageDTO.getStatus() != null)
            holder.status.setText(damageDTO.getStatus().toString());
        holder.description.setText(damageDTO.getDescription());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        if (mDataset == null) return 0;
        return mDataset.size();
    }

    private Long getIdFromDatasetByName(String name) throws Exception {
        for (DamageDTO damageDTO : mDataset) {
            if (damageDTO.getTitle().equals(name)) {
                return damageDTO.getId();
            }
        }
        throw new Exception("Entity not found in dataset");
    }
}