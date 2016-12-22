package nyc.c4q.helenchan.a12_21_2016_exam.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.helenchan.a12_21_2016_exam.R;
import nyc.c4q.helenchan.a12_21_2016_exam.models.Animal;

/**
 * Created by helenchan on 12/21/16.
 */
public class AnimalAdapter extends RecyclerView.Adapter<AnimalViewHolder> {

    List<Animal> animalList;

    public AnimalAdapter(List<Animal> animalList) {
        this.animalList = animalList;
    }


    @Override
    public AnimalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.animal_itemview, parent, false);
        return new AnimalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AnimalViewHolder holder, int position) {
        Animal myAnimals = animalList.get(position);
        holder.bind(myAnimals);
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }
}
