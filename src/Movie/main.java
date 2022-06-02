package Movie;

public class main {
    public static void main(String[] args) {
        view v = new view();
        model m = new model();
        controller c = new controller(m, v);
    }
}
