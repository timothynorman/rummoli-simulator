public class Player {

    public String name;
    public int tokenCount = 0;
    public boolean isEliminated = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTokenCount() {
        return tokenCount;
    }

    public void setTokenCount(int tokenCount) {
        this.tokenCount = tokenCount;
    }

    public boolean isEliminated() {
        return isEliminated;
    }

    public void setEliminated(boolean eliminated) {
        isEliminated = eliminated;
    }
}
