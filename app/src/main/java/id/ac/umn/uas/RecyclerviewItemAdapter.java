package id.ac.umn.uas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerviewItemAdapter extends RecyclerView.Adapter<RecyclerviewItemAdapter.MyViewHolder> {

    private List<Hotels> hotelsList;

    RecyclerviewItemAdapter(List<Hotels> mItemList){
        this.hotelsList = mItemList;
    }

    @Override
    public RecyclerviewItemAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerviewItemAdapter.MyViewHolder holder, final int position) {
        final Hotels item = hotelsList.get(position);
        holder.name.setText(item.getName());

    }

    @Override
    public int getItemCount() {
        return hotelsList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView name,price;
        private LinearLayout itemLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nama_hotel);
            itemLayout =  itemView.findViewById(R.id.hotelLayout);
        }
    }
}