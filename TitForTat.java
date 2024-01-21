public class TitForTat {
    char playerLastMove = 'n';
    int score = 0;
    public char makeMove() {
        return (playerLastMove == 'n') ? 'C' : playerLastMove;
    }
    public void updatePlayerLastMove(char playerMove) {
        this.playerLastMove = playerMove;
    }
    public void updateScore(char myMove, char opponentMove){
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