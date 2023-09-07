package pojos;

public class JsonPlacePojo {

    /*
    {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
     */

    //1- Obje icindeki tum variable`lari private olarak olusturduk
    private String title;
    private String body;
    private int userId;
    private int id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
