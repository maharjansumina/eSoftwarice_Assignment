package com.softwarica.esoftwarice_assignment.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softwarica.esoftwarice_assignment.Model.Students;
import com.softwarica.esoftwarice_assignment.R;

import java.util.List;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentsViewHolder> {

    Context context;
    List<Students> studentsList;

    public StudentsAdapter(Context context, List<Students> contactsList) {
        this.context = context;
        this.studentsList = studentsList;

    }

    @NonNull
    @Override
    public StudentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_students,parent,false);

        return new StudentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsViewHolder holder, final int position) {
        final Students students = studentsList.get(position);

        holder.imgProfile.setImageResource(students.getImageId());
        holder.tvName.setText(students.getFullname());
        holder.tvAge.setText(students.getAge());
        holder.tvGender.setText(students.getGender());
        holder.tvAddress.setText(students.getAddress());

        holder.imgDelete.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_delete_black_24dp));
        holder.imgEdit.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_edit_black_24dp));
        String gender = students.getGender();
        if (gender == "male") {
            holder.imgProfile.setImageResource(R.drawable.male);
        } else if (gender == "female") {
            holder.imgProfile.setImageResource(R.drawable.female);
        } else {
            holder.imgProfile.setImageResource(R.drawable.male);
        }


        //Adding click listener in an imageview
        holder.imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Hello this is : "+ students.getFullname(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Students students = studentsList.get(position);
                studentsList.remove(position);
                notifyItemRemoved(position);
                Toast.makeText(context, students + "details removed", Toast.LENGTH_SHORT).show();
            }
        });

        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Students edtStudents = studentsList.get(position);
                int index = studentsList.indexOf(edtStudents);
                EditDetailsActivity.index = index;
                Intent intent = new Intent(context, EditDetailsActivity.class);
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }

    public class StudentsViewHolder extends RecyclerView.ViewHolder {

        ImageView imgProfile, imgDelete, imgEdit;
        TextView tvName, tvAge, tvAddress, tvGender;

        public StudentsViewHolder(@NonNull View itemView) {
            super(itemView);

            imgProfile = itemView.findViewById(R.id.imgProfile);
            tvName = itemView.findViewById(R.id.tvName);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvGender = itemView.findViewById(R.id.tvGender);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            imgDelete = itemView.findViewById(R.id.imgDelete);
            imgEdit = itemView.findViewById(R.id.imgEdit);


        }
    }
}
