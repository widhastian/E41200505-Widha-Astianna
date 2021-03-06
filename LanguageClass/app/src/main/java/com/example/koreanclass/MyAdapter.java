package com.example.koreanclass;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String data1[], data2[];
    int images[];
    Context context;

    public MyAdapter(Context ct, String s1[], String s2[], int img[]) {
        context = ct;
        data1 = s1;
        data2 = s2;
        images = img;
    }

    @NonNull
    @Override
    //untuk memunculkan susunan data yang sudah dibuat di file my_row
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    //untuk membuat masing masing data item di file my_row dapat di klik
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.MyText1.setText(data1[position]);
        holder.MyText2.setText(data2[position]);
        holder.myImage.setImageResource(images[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity3.class);
                intent.putExtra("data1", data1[position]);
                intent.putExtra("data2", data2[position]);
                intent.putExtra("myImage", images[position]);

                context.startActivity(intent);
            }
        });

    }

    @Override
    //menghitung panjang data
    public int getItemCount() {
        return images.length;
    }

    //fungsi untuk menemukan data menggunakan id yang akan dieksekusi oleh
    //public void onBindViewHolder
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView MyText1, MyText2;
        ImageView myImage;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            MyText1 = itemView.findViewById(R.id.MyText1);
            MyText2 = itemView.findViewById(R.id.MyText2);
            myImage = itemView.findViewById(R.id.myImageView);
            mainLayout = itemView.findViewById(R.id.MainLayout);
        }
    }
}
