package nyc.c4q.helenchan.a12_21_2016_exam.models;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by helenchan on 12/21/16.
 * http://jsjrobotics.nyc/cgi-bin/12_21_2016_exam.pl
 */

public interface AnimalService {

    @GET("cgi-bin/12_21_2016_exam.pl")
    Call<AnimalResponse> getAnimals();
}
