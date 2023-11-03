package type;

public enum GameStatus {
    CONTINUE(1),
    END(2);

    private final int status;

    GameStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public boolean isContinue(int status) {
        return CONTINUE.getStatus() == status;
    }



}
