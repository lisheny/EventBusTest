> EventBus 通过发布/订阅的方式进行消息传递。主要功能是替代Intent、Handler、BroadCast在Fragment、Activity、Service，线程之间传递消息。

#### 使用方法：
* 1.引入EventBus:
```
 compile 'org.greenrobot:eventbus:3.0.0'
```

* 2.注册与注销
```
    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
```

* 3.定义事件消息类
```
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
```
* 4.发送消息
```
   MessageEvent messageEvent = new MessageEvent();
   messageEvent.setName("lisheny");
   messageEvent.setSex("boy");
   EventBus.getDefault().post(messageEvent);
```

* 5.接收消息处理
```
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(final MessageEvent event){
        textView.setText(event.getName()+","+event.getSex());
    }
```

* 6.proguard 混淆处理:

 ```
#EventBus
 -keepclassmembers class ** {
    public void onEvent*(**);
    void onEvent*(**);
 }
```
##### 特别的：四种 threadMode：
* ThreadMode.POSTING ，默认模式，在发布者所在的线程中调用；
* ThreadMode.MAIN ，主线程中调用，不宜耗时操作；
* ThreadMode.BACKGROUND ,后台进程调用，不宜耗时操作，避免阻塞进程。
*  ThreadMode.ASYNC ，单独的线程中调用，耗时操作用它。

官网：https://github.com/greenrobot/EventBus

