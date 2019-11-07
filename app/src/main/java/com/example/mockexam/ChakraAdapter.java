package com.example.mockexam;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChakraAdapter extends RecyclerView.Adapter<ChakraAdapter.ChakraViewHolder> {

    private Activity activity;
    private ChakraViewModel mChakraViewModel;
    List<ChakraEntity>data;

    public ChakraAdapter(Activity activity,ChakraViewModel mChakraViewModel) {
        // TODO change constructor to receive/save any data you need to read/modify
        this.activity = activity;
        this.mChakraViewModel=mChakraViewModel;
    }

    @NonNull
    @Override
    public ChakraViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);

        return new ChakraViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChakraViewHolder holder, int position) {
    // TODO bind new data to views in holder. Use position variable for correct position in your data
        if(data!=null){

            holder.tv1.setText(data.get(position).getName());
            if(data.get(position).isFav()){
                holder.im.setImageResource(R.drawable.ic_star);
            }
            else{
                holder.im.setImageResource(R.drawable.ic_no_star);
            }
            if(data.get(position).getId()%7==0){
                holder.im2.setImageResource(R.drawable.ic_circle1);
            }
            else if(data.get(position).getId()%7==1){
                holder.im2.setImageResource(R.drawable.ic_circle2);
            }
            else if(data.get(position).getId()%7==2){
                holder.im2.setImageResource(R.drawable.ic_circle3);
            }
            else if(data.get(position).getId()%7==3){
                holder.im2.setImageResource(R.drawable.ic_circle4);
            }
            else if(data.get(position).getId()%7==4){
                holder.im2.setImageResource(R.drawable.ic_circle5);
            }
            else if(data.get(position).getId()%7==5){
                holder.im2.setImageResource(R.drawable.ic_circle6);
            }
            else if(data.get(position).getId()%7==6){
                holder.im2.setImageResource(R.drawable.ic_circle7);
            }
        }
    }

    @Override
    public int getItemCount() {
    // TODO return length of list(deciding how many items will be represented)
        if(data!=null){
            return data.size();
        }
        else{
            return 0;
        }
    }

    void setChakras(List<ChakraEntity>words){
        data=words;
        notifyDataSetChanged();
    }


    class ChakraViewHolder extends RecyclerView.ViewHolder {
        ImageView im;
        TextView tv1;
        ImageView im2;

        public ChakraViewHolder(@NonNull final View itemView) {
            super(itemView);
            im=itemView.findViewById(R.id.imageView);
            tv1=itemView.findViewById(R.id.textView3);
            im2=itemView.findViewById(R.id.imageView2);
            im.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ChakraEntity ce=data.get(getLayoutPosition());
                    ce.setFav(!ce.isFav());
                    Log.i("Message","hello"+data.get(getLayoutPosition()).getName());
                    mChakraViewModel.insert(data.get(getLayoutPosition()));
                    notifyDataSetChanged();

                }
            });
            tv1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in=new Intent(view.getContext(),Information.class);
                    in.putExtra("info",data.get(getLayoutPosition()).getInfo());
                    in.putExtra("info1",data.get(getLayoutPosition()).getName());
                    view.getContext().startActivity(in);
                }
            });

        }
    }
}
