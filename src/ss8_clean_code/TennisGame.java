package ss8_clean_code;

public class TennisGame {
    private static final int WINNING_SCORE = 4;

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        if (isDraw(player1Score, player2Score)) {
            return getDrawScore(player1Score);
        }

        if (isEndGame(player1Score, player2Score)) {
            return getEndGameScore(player1Score, player2Score);
        }

        return getNormalScore(player1Score, player2Score);
    }

    private static boolean isDraw(int score1, int score2) {
        return score1 == score2;
    }

    private static String getDrawScore(int score) {
        switch (score) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }

    private static boolean isEndGame(int score1, int score2) {
        return score1 >= WINNING_SCORE || score2 >= WINNING_SCORE;
    }

    private static String getEndGameScore(int score1, int score2) {
        int diff = score1 - score2;

        if (diff == 1) {
            return "Advantage Player 1";
        }
        if (diff == -1) {
            return "Advantage Player 2";
        }
        if (diff >= 2) {
            return "Win for Player 1";
        }
        return "Win for Player 2";
    }

    private static String getNormalScore(int score1, int score2) {
        return getScoreName(score1) + "-" + getScoreName(score2);
    }

    private static String getScoreName(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "";
        }
    }
}
