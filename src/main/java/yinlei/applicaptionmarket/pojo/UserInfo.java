package yinlei.applicaptionmarket.pojo;

/**
 * UserInfo  类
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: UserInfo.java
 * @author: 若兰明月
 * @date: 2016-06-19 16:03
 */
public class UserInfo {


    /**
     * status : 1
     * message : success
     * data : {"id":16383,"email":null,"logo_url":null,"username":"15677975034","mobi":"15677975034"}
     * token : 9f4f3971-2238-4cfc-9365-0100402fe281
     */

    private int status;
    private String message;
    /**
     * id : 16383
     * email : null
     * logo_url : null
     * username : 15677975034
     * mobi : 15677975034
     */

    private DataEntity data;
    private String token;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static class DataEntity {
        private int id;
        private Object email;
        private Object logo_url;
        private String username;
        private String mobi;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getLogo_url() {
            return logo_url;
        }

        public void setLogo_url(Object logo_url) {
            this.logo_url = logo_url;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getMobi() {
            return mobi;
        }

        public void setMobi(String mobi) {
            this.mobi = mobi;
        }
    }
}
