package Com.Cookie;

import javax.servlet.http.Cookie;

public class CookieUtils {

    public static Cookie findCookie(String name, Cookie cookies[]) {
        if (name == null || cookies == null || cookies.length == 0) {
            return null;
        }

        Cookie iWantCookie = null;
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                iWantCookie = cookie;
                break;
            }
        }
        return iWantCookie;
    }

}
