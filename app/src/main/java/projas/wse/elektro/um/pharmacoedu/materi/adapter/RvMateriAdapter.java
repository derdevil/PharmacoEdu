package projas.wse.elektro.um.pharmacoedu.materi.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import projas.wse.elektro.um.pharmacoedu.R;
import projas.wse.elektro.um.pharmacoedu.materi.pojo.Materi;
import projas.wse.elektro.um.pharmacoedu.materi.pojo.RvMateriItemClickListener;

public class RvMateriAdapter extends RecyclerView.Adapter<RvMateriAdapter.ItemViewHolder> {

    private ArrayList<Materi> listMateri;
    private RvMateriItemClickListener clickListener;

    public RvMateriAdapter(ArrayList<Materi> listMateri, RvMateriItemClickListener clickListener) {
        this.listMateri = listMateri;
        this.clickListener = clickListener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_materi, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        final Materi materi = listMateri.get(position);

        holder.tvTitle.setText(materi.getTitle());
        holder.tvSubtitle.setText(materi.getSubtitle());

        holder.cvGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickListener != null) clickListener.onItemClick(materi);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMateri.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvSubtitle;
        CardView cvGroup;

        ItemViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.item_materi_tv_title);
            tvSubtitle = (TextView) itemView.findViewById(R.id.item_materi_tv_subtitle);
            cvGroup = (CardView) itemView.findViewById(R.id.item_materi_cv_group);
        }
    }
}
