package com.lishent.eventbusstudy;

/**
 * <pre>
 *     author : lisheny
 *     e-mail : 1020044519@qq.com
 *     time   : 2017/08/24
 *     desc   : Define events
 *     version: 1.0
 * </pre>
 */
public class MessageEvent {
    private String name;
    private String sex;

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public MessageEvent(){

    }

    public MessageEvent(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }
}
