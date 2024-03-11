package co.com.study.model.helper;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Pair {

    private String left;
    private String right;

    public String left() {
        return left;
    }

    public String right() {
        return right;
    }
}
