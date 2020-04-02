package designMode.observerPattern;

/**
 * @author lijie  2020/2/28.
 */
public class NewsModel {
    private String title;

    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NewsModel(String title, String content) {
        this.title = title;
        this.content = content;
    }
}