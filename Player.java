public class Player {
    int score = 0;

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
        return this.score;
    }
}
