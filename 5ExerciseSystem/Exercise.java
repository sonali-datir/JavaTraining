public class Exercise {
    String alpha;
    String exName;
    int exMET;

    Exercise(String alpha, String exName, int exMET){
        this.alpha = alpha;
        this.exName = exName;
        this.exMET = exMET;
    }

    public String getAlpha() {
        return alpha;
    }

    public void setAlpha(String alpha) {
        this.alpha = alpha;
    }

    public String getExName() {
        return exName;
    }

    public void setExName(String exName) {
        this.exName = exName;
    }

    public int getExMET() {
        return exMET;
    }

    public void setExMET(int exMET) {
        this.exMET = exMET;
    }

}
