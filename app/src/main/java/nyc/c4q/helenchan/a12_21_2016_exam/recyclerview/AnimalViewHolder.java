package nyc.c4q.helenchan.a12_21_2016_exam.recyclerview;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.helenchan.a12_21_2016_exam.R;
import nyc.c4q.helenchan.a12_21_2016_exam.models.Animal;

/**
 * Created by helenchan on 12/21/16.
 */
public class AnimalViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    int color;
    private int backgroundColor;

    public AnimalViewHolder(final View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.name_textview);

        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                itemView.getRootView().setBackgroundColor(backgroundColor);

            }
        });

    }

    public void bind(Animal myAnimals) {
        name.setText(myAnimals.getName());
        color = Color.parseColor(myAnimals.getTextColor());
        backgroundColor = Color.parseColor(myAnimals.getBackground());
        name.setTextColor(color);

    }

}

