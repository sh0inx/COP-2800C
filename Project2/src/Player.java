public class Player {

    int score;
    boolean turn;

    public Player() {
        score = 0;
        turn = false;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public boolean getTurn() {
        return turn;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void scorePoints(int points) {
        score += points;
    }

    public void deductPoints(int points) {
        score -= points;
    }
}
