package Classes;

public class LearningBlock {
    private final String topic;
    private final String url;
    private boolean isRated = false;
    private int rating = 3;

    public LearningBlock(String topic, String url){
        this.topic = topic;
        this.url = url;
    }

    public boolean equalByTopic(LearningBlock other){
        return topic.equals(other.getTopic());
    }

    public String getTopic() {
        return topic;
    }

    public int getRating() {
        return rating;
    }

    public boolean rate(int rating){
        if(!isRated){
            isRated = true;
            this.rating = rating;
            return true;
        }
        return false;
    }

    public String getUrl() {
        return url;
    }
}
