package nyc.c4q.helenchan.a12_21_2016_exam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.helenchan.a12_21_2016_exam.models.Animal;
import nyc.c4q.helenchan.a12_21_2016_exam.models.AnimalResponse;
import nyc.c4q.helenchan.a12_21_2016_exam.models.AnimalService;
import nyc.c4q.helenchan.a12_21_2016_exam.recyclerview.AnimalAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by helenchan on 12/21/16.
 * http://jsjrobotics.nyc/cgi-bin/12_21_2016_exam.pl
 */
public class AnimalFragment extends Fragment {

    View mRoot;
    RecyclerView recyclerView;
    AnimalAdapter adapter;
    List<Animal> animalList = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.animal_fragment, container, false);
        recyclerView = (RecyclerView) mRoot.findViewById(R.id.animal_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(mRoot.getContext()));
        adapter = new AnimalAdapter(animalList);
        recyclerView.setAdapter(adapter);
        return mRoot;
    }

    @Override
    public void onStart() {
        super.onStart();
        fetchAnimals();
    }


    private void fetchAnimals(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsjrobotics.nyc/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AnimalService service = retrofit.create(AnimalService.class);
        Call<AnimalResponse> call = service.getAnimals();
        call.enqueue(new Callback<AnimalResponse>() {
            @Override
            public void onResponse(Call<AnimalResponse> call, Response<AnimalResponse> response) {
                animalList = response.body()
                        .getAnimals();
                adapter = new AnimalAdapter(animalList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<AnimalResponse> call, Throwable t) {
                Toast.makeText(getContext(),"Cannot Download", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
