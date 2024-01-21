public class Friedman {
    char playerLastMove = 'n';
    int score = 0;
    int defectCount = 0;

    public char makeMove(int rounds) {
        if (rounds == 1 || playerLastMove == 'C' && !(defectCount >= 2)) {
            return 'C';
        }
        if (playerLastMove == 'D') {
            defectCount++;
        }
        if (defectCount >= 2) {
            return 'D';
        }
        return 'C';
    }

    public void updatePlayerLastMove(char playerMove) {
        playerLastMove = playerMove;
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
