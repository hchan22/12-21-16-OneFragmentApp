package nyc.c4q.helenchan.a12_21_2016_exam.models;

/**
 * Created by helenchan on 12/21/16.
 * {"success":true,"animals":[{"name":"Lion","textColor":"white","background":"yellow"},{"name":"Blue Jay","textColor":"purple","background":"cyan"},{"name":"Blue Jay","textColor":"purple","background":"cyan"},{"name":"Hippopotamus","textColor":"silver","background":"grey"},{"name":"Cow","textColor":"black","background":"blue"}]}
 */
public class Animal {
    private String name;
    private String textColor;
    private String background;

    public String getBackground() {
        return background;
    }

    public String getName() {
        return name;
    }

    public String getTextColor() {
        return textColor;
    }


}
