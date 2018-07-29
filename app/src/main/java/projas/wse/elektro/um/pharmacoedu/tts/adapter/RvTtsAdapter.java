package projas.wse.elektro.um.pharmacoedu.tts.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import projas.wse.elektro.um.pharmacoedu.R;
import projas.wse.elektro.um.pharmacoedu.tts.pojo.RvTtsItemClickListener;

public class RvTtsAdapter extends RecyclerView.Adapter<RvTtsAdapter.ItemViewHolder> {

    private ArrayList<String> listTts;
    private RvTtsItemClickListener clickListener;

    public RvTtsAdapter(ArrayList<String> listTts, RvTtsItemClickListener clickListener) {
        this.listTts = listTts;
        this.clickListener = clickListener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_tts, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        String title = listTts.get(position);
        holder.tvTitle.setText(title);

        holder.cvGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickListener != null) clickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTts.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        CardView cvGroup;

        public ItemViewHolder(View itemView) {
            super(itemView);

            cvGroup = (CardView) itemView;
            tvTitle = (TextView) itemView.findViewById(R.id.item_tts_tv_title);
        }
    }

}
