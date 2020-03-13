package com.example.recyclerviewprogressbar_button_interface;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

 import com.daimajia.numberprogressbar.NumberProgressBar;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.Recy_holder> {


    Context context;
    Model[] modelList;
    Recyclerview_Interface anInterface;


    public RecyclerviewAdapter(Context context, Model[] modelList, Recyclerview_Interface anInterface) {
        this.context = context;
        this.modelList = modelList;
        this.anInterface = anInterface;
    }

   /* public RecyclerviewAdapter(Model[] modelList) {
        this.modelList = modelList;
    }*/

    @NonNull
    @Override
    public Recy_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return new Recy_holder(view, anInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull Recy_holder holder, int position) {
        final Model model2 = modelList[position];
        holder.imageView.setImageResource(modelList[position].getImageView());
        holder.textView.setText(modelList[position].getText());
        holder.progressBar.setProgress(Integer.parseInt(modelList[position].getProgress()));
    }

    @Override
    public int getItemCount() {
        return modelList.length;
    }

    public class Recy_holder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        int count;
        ObjectAnimator progressAnimator;
        NumberProgressBar progressBar;
        private Timer timer;


        @SuppressLint("ObjectAnimatorBinding")
        public Recy_holder(@NonNull View itemView, final Recyclerview_Interface listener) {
            super(itemView);

            imageView = itemView.findViewById(R.id.action_image);
            textView = itemView.findViewById(R.id.textview);
            progressBar = itemView.findViewById(R.id.progress_horizontal);



            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = v.getId();
                    if (id == R.id.action_image) {
                        if (listener != null) {
                            listener.onViewclick(getAdapterPosition(), v);
                             count++;
                            textView.setText("you click on  " + count + "  times");
                            progressBar.setProgress(0);


                            timer = new Timer();
                            timer.schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    progressBar.incrementProgressBy(1);


                                }
                            },1500,200);




                        }
                    }
                }
            });
        }


    }
}
