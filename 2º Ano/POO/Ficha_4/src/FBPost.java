import java.time.LocalDateTime;
import java.util.ArrayList;

public class FBPost {

    private int id;
    private String user;
    private LocalDateTime creationDate;
    private String content;
    private int likes;
    private ArrayList<String> comments;

    public FBPost () {
        this.id = 0;
        this.user = null;
        this.creationDate = null;
        this.content = null;
        this.likes = 0;
        this.comments = null;
    }

    public FBPost (int id, String user, LocalDateTime date, String content, int likes, ArrayList<String> comments) {
        this.id = id;
        this.user = user;
        this.creationDate = date;
        this.content = content;
        this.likes = likes;
        this.comments = comments;
    }

    public FBPost (FBPost f) {
        this.id = f.getId();
        this.user = f.getUser();
        this.content = f.getContent();
        this.creationDate = f.getCreationDate();
        this.likes = f.getLikes();
        this.comments = f.getComments();
    }

    // GETTERS E SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public void setComments(String comments) {
        this.comments.add(comments);
    }

    public boolean equals(Object o) {
        if (this==o) return true;
        if ((o==null) ||(o.getClass()!=this.getClass())) return false;

        FBPost f = (FBPost) o;
        return f.getId() == this.id &&
                f.getUser() == this.user &&
                f.getCreationDate() == this.creationDate &&
                f.getContent() == this.content &&
                f.getLikes() == this.likes &&
                f.getComments() == this.comments;
    }

    public FBPost clone() {
        return new FBPost(this);
    }

}
