import java.util.Random;

public class Randoomed {
    int score;

    public char makeMove() {
        Random random = new Random();
        boolean randomBoolean = random.nextBoolean();
        return (randomBoolean) ? 'C' : 'D';
    }

    public void updateScore(char myMove, char opponentMove) {
        if (myMove == 'C' && opponentMove == 'C') {
            score += 3;
        } else if (myMove == 'D' && opponentMove == 'C') {
            score += 5;
        } else if (myMove == 'D' && opponentMove == 'D') {
            score += 1;
        }
    }

    public int getScore() {
        return score;
    }
}