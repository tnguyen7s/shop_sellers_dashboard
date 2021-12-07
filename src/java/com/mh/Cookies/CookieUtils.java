/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mh.Cookies;

import jakarta.servlet.http.Cookie;

/**
 *
 * @author Tuyen
 */
public class CookieUtils {
    public static String getCookieValue(Cookie[] cookies, String key)
    {
        for (Cookie c:cookies)
        {
            if (c.getName().compareTo(key) == 0)
            {
                return c.getValue();
            }
        }
        return null;
    }
}
