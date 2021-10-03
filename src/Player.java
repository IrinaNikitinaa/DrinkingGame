public class Player {
    private String name;
    private int number;
    private int wrong;

    public Player(String name, int number) {
        this.name = name;
        this.number = number;
        wrong = 0;
    }

    public String getName() {
        return name;
    }

    public int getWrong() {
        return wrong;
    }

    public int getNumber() {
        return number;
    }

    public void add() {
        wrong++;
    }
}
