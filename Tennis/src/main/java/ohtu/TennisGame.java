package ohtu;

public class TennisGame {
    
    private int player1_score = 0;
    private int player2_score = 0;
    private final int winDifference = 2;
    private final int END_GAME_START = 4;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            player1_score++;
        } else {
            player2_score++;
        }
    }

    public String getScore() {
        String score = "";
        int tempScore;
        if (player1_score == player2_score) {
            return getTies();
        }
        
        if (player1_score >= END_GAME_START || player2_score >= END_GAME_START) {
            return endGameScores();
        }
        else {
            score += normalScoreAsString(player1_score) + "-";
            score += normalScoreAsString(player2_score);
        }
        
        return score;
    }
    
    public String getTies() {
        switch (player1_score) {
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
    
    public String endGameScores() {
        int minusResult = player1_score - player2_score;
        
        switch(minusResult) {
            case 1:
                return "Advantage player1";
            case -1:
                return "Advantage player2";
            default:
                break;
        }
        
        if (minusResult >= winDifference) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }
    
    private String normalScoreAsString(int playerScore) {
        
        switch (playerScore) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "you are drunk";
        }
    }
}