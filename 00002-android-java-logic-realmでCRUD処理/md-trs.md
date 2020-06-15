# 1.

- 事象

```
2020-05-15 18:34:15.237 9532-9532/com.example.ppp E/AndroidRuntime: FATAL EXCEPTION: main
    Process: com.example.ppp, PID: 9532
    java.lang.IllegalStateException: Could not execute method for android:onClick
        at androidx.appcompat.app.AppCompatViewInflater$DeclaredOnClickListener.onClick(AppCompatViewInflater.java:390)
        at android.view.View.performClick(View.java:7125)
        at android.view.View.performClickInternal(View.java:7102)
        at android.view.View.access$3500(View.java:801)
        at android.view.View$PerformClick.run(View.java:27336)
        at android.os.Handler.handleCallback(Handler.java:883)
        at android.os.Handler.dispatchMessage(Handler.java:100)
        at android.os.Looper.loop(Looper.java:214)
        at android.app.ActivityThread.main(ActivityThread.java:7356)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:492)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:930)
     Caused by: java.lang.reflect.InvocationTargetException
        at java.lang.reflect.Method.invoke(Native Method)
        at androidx.appcompat.app.AppCompatViewInflater$DeclaredOnClickListener.onClick(AppCompatViewInflater.java:385)
        at android.view.View.performClick(View.java:7125) 
        at android.view.View.performClickInternal(View.java:7102) 
        at android.view.View.access$3500(View.java:801) 
        at android.view.View$PerformClick.run(View.java:27336) 
        at android.os.Handler.handleCallback(Handler.java:883) 
        at android.os.Handler.dispatchMessage(Handler.java:100) 
        at android.os.Looper.loop(Looper.java:214) 
        at android.app.ActivityThread.main(ActivityThread.java:7356) 
        at java.lang.reflect.Method.invoke(Native Method) 
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:492) 
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:930) 
     Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'void io.realm.Realm.beginTransaction()' on a null object reference
        at com.example.ppp.MainActivity.addRecord(MainActivity.java:53)
        at com.example.ppp.MainActivity.clickAction(MainActivity.java:42)
        at java.lang.reflect.Method.invoke(Native Method) 
        at androidx.appcompat.app.AppCompatViewInflater$DeclaredOnClickListener.onClick(AppCompatViewInflater.java:385) 
        at android.view.View.performClick(View.java:7125) 
        at android.view.View.performClickInternal(View.java:7102) 
        at android.view.View.access$3500(View.java:801) 
        at android.view.View$PerformClick.run(View.java:27336) 
        at android.os.Handler.handleCallback(Handler.java:883) 
        at android.os.Handler.dispatchMessage(Handler.java:100) 
        at android.os.Looper.loop(Looper.java:214) 
        at android.app.ActivityThread.main(ActivityThread.java:7356) 
        at java.lang.reflect.Method.invoke(Native Method) 
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:492) 
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:930) 
2020-05-15 18:34:15.255 9532-9532/com.example.ppp I/Process: Sending signal. PID: 9532 SIG: 9
```

- 原因


  - トランザクション開始時にrealmオブジェクトがnull
```
     Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'void io.realm.Realm.beginTransaction()' on a null object reference
        at com.example.ppp.MainActivity.addRecord(MainActivity.java:53)
        at com.example.ppp.MainActivity.clickAction(MainActivity.java:42)
        at java.lang.reflect.Method.invoke(Native Method) 
```

- 対策


at com.example.ppp.MainActivity.addRecord(MainActivity.java:53)

この行を追加

```
Realm realm = Realm.getDefaultInstance();
```


結果こうなる

```
    public void addRecord(){

        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        Student student = realm.createObject(Student.class);
        student.setRoll_no(Integer.parseInt(roll_no.getText().toString()));
        student.setName(name.getText().toString());

        realm.commitTransaction();
    }
```


- 予防




# 2.


- 事象

```
2020-05-16 02:55:14.998 15484-15484/com.example.ppp E/AndroidRuntime: FATAL EXCEPTION: main
    Process: com.example.ppp, PID: 15484
    java.lang.IllegalStateException: Could not execute method for android:onClick
        at androidx.appcompat.app.AppCompatViewInflater$DeclaredOnClickListener.onClick(AppCompatViewInflater.java:390)
        at android.view.View.performClick(View.java:7125)
        at android.view.View.performClickInternal(View.java:7102)
        at android.view.View.access$3500(View.java:801)
        at android.view.View$PerformClick.run(View.java:27336)
        at android.os.Handler.handleCallback(Handler.java:883)
        at android.os.Handler.dispatchMessage(Handler.java:100)
        at android.os.Looper.loop(Looper.java:214)
        at android.app.ActivityThread.main(ActivityThread.java:7356)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:492)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:930)
     Caused by: java.lang.reflect.InvocationTargetException
        at java.lang.reflect.Method.invoke(Native Method)
        at androidx.appcompat.app.AppCompatViewInflater$DeclaredOnClickListener.onClick(AppCompatViewInflater.java:385)
        at android.view.View.performClick(View.java:7125) 
        at android.view.View.performClickInternal(View.java:7102) 
        at android.view.View.access$3500(View.java:801) 
        at android.view.View$PerformClick.run(View.java:27336) 
        at android.os.Handler.handleCallback(Handler.java:883) 
        at android.os.Handler.dispatchMessage(Handler.java:100) 
        at android.os.Looper.loop(Looper.java:214) 
        at android.app.ActivityThread.main(ActivityThread.java:7356) 
        at java.lang.reflect.Method.invoke(Native Method) 
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:492) 
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:930) 
     Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'io.realm.RealmQuery io.realm.Realm.where(java.lang.Class)' on a null object reference
        at com.example.ppp.MainActivity.viewRecord(MainActivity.java:66)
        at com.example.ppp.MainActivity.clickAction(MainActivity.java:44)
        at java.lang.reflect.Method.invoke(Native Method) 
        at androidx.appcompat.app.AppCompatViewInflater$DeclaredOnClickListener.onClick(AppCompatViewInflater.java:385) 
        at android.view.View.performClick(View.java:7125) 
        at android.view.View.performClickInternal(View.java:7102) 
        at android.view.View.access$3500(View.java:801) 
        at android.view.View$PerformClick.run(View.java:27336) 
        at android.os.Handler.handleCallback(Handler.java:883) 
        at android.os.Handler.dispatchMessage(Handler.java:100) 
        at android.os.Looper.loop(Looper.java:214) 
        at android.app.ActivityThread.main(ActivityThread.java:7356) 
        at java.lang.reflect.Method.invoke(Native Method) 
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:492) 
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:930) 
2020-05-16 02:55:15.010 15484-15484/com.example.ppp I/Process: Sending signal. PID: 15484 SIG: 9
```

- 原因

  - トランザクション開始時にrealmオブジェクトがnull

```
     Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'io.realm.RealmQuery io.realm.Realm.where(java.lang.Class)' on a null object reference
        at com.example.ppp.MainActivity.viewRecord(MainActivity.java:66)
        at com.example.ppp.MainActivity.clickAction(MainActivity.java:44)
        at java.lang.reflect.Method.invoke(Native Method) 
```

- 対策

at com.example.ppp.MainActivity.viewRecord(MainActivity.java:66)

この行を追加

```
Realm realm = Realm.getDefaultInstance();
```


結果こうなる


```
    public void viewRecord(){
        Realm realm = Realm.getDefaultInstance();

        RealmResults<Student> results = realm.where(Student.class).findAll();

        text.setText("");

        for(Student student : results){
            text.append(student.getRoll_no() + " " + student.getName() + "\n");
        }
    }
```

- 予防



# 3.


- 事象


```
2020-05-16 03:11:52.113 15994-15994/com.example.ppp E/AndroidRuntime: FATAL EXCEPTION: main
    Process: com.example.ppp, PID: 15994
    java.lang.IllegalStateException: Could not execute method for android:onClick
        at androidx.appcompat.app.AppCompatViewInflater$DeclaredOnClickListener.onClick(AppCompatViewInflater.java:390)
        at android.view.View.performClick(View.java:7125)
        at android.view.View.performClickInternal(View.java:7102)
        at android.view.View.access$3500(View.java:801)
        at android.view.View$PerformClick.run(View.java:27336)
        at android.os.Handler.handleCallback(Handler.java:883)
        at android.os.Handler.dispatchMessage(Handler.java:100)
        at android.os.Looper.loop(Looper.java:214)
        at android.app.ActivityThread.main(ActivityThread.java:7356)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:492)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:930)
     Caused by: java.lang.reflect.InvocationTargetException
        at java.lang.reflect.Method.invoke(Native Method)
        at androidx.appcompat.app.AppCompatViewInflater$DeclaredOnClickListener.onClick(AppCompatViewInflater.java:385)
        at android.view.View.performClick(View.java:7125) 
        at android.view.View.performClickInternal(View.java:7102) 
        at android.view.View.access$3500(View.java:801) 
        at android.view.View$PerformClick.run(View.java:27336) 
        at android.os.Handler.handleCallback(Handler.java:883) 
        at android.os.Handler.dispatchMessage(Handler.java:100) 
        at android.os.Looper.loop(Looper.java:214) 
        at android.app.ActivityThread.main(ActivityThread.java:7356) 
        at java.lang.reflect.Method.invoke(Native Method) 
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:492) 
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:930) 
     Caused by: java.util.ConcurrentModificationException: No outside changes to a Realm is allowed while iterating a RealmResults. Use iterators methods instead.
        at io.realm.RealmResults$RealmResultsIterator.assertRealmIsStable(RealmResults.java:645)
        at io.realm.RealmResults$RealmResultsIterator.hasNext(RealmResults.java:607)
        at com.example.ppp.MainActivity.updateRecord(MainActivity.java:84)
        at com.example.ppp.MainActivity.clickAction(MainActivity.java:46)
        at java.lang.reflect.Method.invoke(Native Method) 
        at androidx.appcompat.app.AppCompatViewInflater$DeclaredOnClickListener.onClick(AppCompatViewInflater.java:385) 
        at android.view.View.performClick(View.java:7125) 
        at android.view.View.performClickInternal(View.java:7102) 
        at android.view.View.access$3500(View.java:801) 
        at android.view.View$PerformClick.run(View.java:27336) 
        at android.os.Handler.handleCallback(Handler.java:883) 
        at android.os.Handler.dispatchMessage(Handler.java:100) 
        at android.os.Looper.loop(Looper.java:214) 
        at android.app.ActivityThread.main(ActivityThread.java:7356) 
        at java.lang.reflect.Method.invoke(Native Method) 
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:492) 
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:930) 
```

- 原因

```
     Caused by: java.util.ConcurrentModificationException: No outside changes to a Realm is allowed while iterating a RealmResults. Use iterators methods instead.
        at io.realm.RealmResults$RealmResultsIterator.assertRealmIsStable(RealmResults.java:645)
        at io.realm.RealmResults$RealmResultsIterator.hasNext(RealmResults.java:607)
```


- 対策

拡張for文ではなくてイテレートして繰り返し処理をおこなう

```
    public void updateRecord(){
        Realm realm = Realm.getDefaultInstance();

        RealmResults<Student> students = realm.where(Student.class).equalTo("roll_no", Integer.parseInt(roll_no.getText().toString())).findAll();
        realm.beginTransaction();

        for (int i = 0; i < students.size(); i++) {
            students.get(i).setName(name.getText().toString());
        }
        realm.commitTransaction();

    }
```

- 予防

# 4.

- 事象

```
2020-05-16 03:25:16.093 16211-16211/com.example.ppp E/AndroidRuntime: FATAL EXCEPTION: main
    Process: com.example.ppp, PID: 16211
    java.lang.RuntimeException: Unable to destroy activity {com.example.ppp/com.example.ppp.MainActivity}: java.lang.NullPointerException: Attempt to invoke virtual method 'void io.realm.Realm.close()' on a null object reference
        at android.app.ActivityThread.performDestroyActivity(ActivityThread.java:4941)
        at android.app.ActivityThread.handleDestroyActivity(ActivityThread.java:4970)
        at android.app.servertransaction.DestroyActivityItem.execute(DestroyActivityItem.java:44)
        at android.app.servertransaction.TransactionExecutor.executeLifecycleState(TransactionExecutor.java:176)
        at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:97)
        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:2016)
        at android.os.Handler.dispatchMessage(Handler.java:107)
        at android.os.Looper.loop(Looper.java:214)
        at android.app.ActivityThread.main(ActivityThread.java:7356)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:492)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:930)
     Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'void io.realm.Realm.close()' on a null object reference
        at com.example.ppp.MainActivity.onDestroy(MainActivity.java:114)
        at android.app.Activity.performDestroy(Activity.java:8048)
        at android.app.Instrumentation.callActivityOnDestroy(Instrumentation.java:1334)
        at android.app.ActivityThread.performDestroyActivity(ActivityThread.java:4926)
        at android.app.ActivityThread.handleDestroyActivity(ActivityThread.java:4970) 
        at android.app.servertransaction.DestroyActivityItem.execute(DestroyActivityItem.java:44) 
        at android.app.servertransaction.TransactionExecutor.executeLifecycleState(TransactionExecutor.java:176) 
        at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:97) 
        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:2016) 
        at android.os.Handler.dispatchMessage(Handler.java:107) 
        at android.os.Looper.loop(Looper.java:214) 
        at android.app.ActivityThread.main(ActivityThread.java:7356) 
        at java.lang.reflect.Method.invoke(Native Method) 
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:492) 
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:930) 
2020-05-16 03:25:16.098 16211-16211/com.example.ppp I/Process: Sending signal. PID: 16211 SIG: 9
```

- 原因

  - トランザクション開始時にrealmオブジェクトがnull

```
     Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'void io.realm.Realm.close()' on a null object reference
        at com.example.ppp.MainActivity.onDestroy(MainActivity.java:114)
```

- 対策

at com.example.ppp.MainActivity.onDestroy(MainActivity.java:114)


この行を追加

```
Realm realm = Realm.getDefaultInstance();
```


結果こうなる

```
    @Override
    protected void onDestroy() {
        Realm realm = Realm.getDefaultInstance();

        realm.close();
        super.onDestroy();
    }
```

- 予防

# 5.

- 事象


```
05/15 18:09:09: Launching 'app' on Pixel 3a API 29.
$ adb shell am start -n "com.example.ppp/com.example.ppp.MainActivity" -a android.intent.action.MAIN -c android.intent.category.LAUNCHER
Connected to process 7076 on device 'Pixel_3a_API_29 [emulator-5554]'.



18:11	Emulator: emulator: ERROR: VkCommonOperations.cpp:496: Failed to create Vulkan instance.

18:11	Emulator: pulseaudio: pa_context_connect() failed

18:11	Emulator: pulseaudio: Reason: Connection refused

18:11	Emulator: pulseaudio: Failed to initialize PA contextaudio: Could not init `pa' audio driver

18:11	Emulator: E0516 03:11:49.837703053    1679 socket_utils_common_posix.cc:201] check for SO_REUSEPORT: {"created":"@1589566309.837691738","description":"SO_REUSEPORT unavailable on compiling system","file":"/mnt/tmpfs/src/android/emu-master-dev/external/grpc/src/core/lib/iomgr/socket_utils_common_posix.cc","file_line":169}

```

- 原因


ソケット通信周りだと思っているが、エミュレータは起動してくれいたので、一旦保留

redditにも上がっていた

- https://www.reddit.com/r/linux_gaming/comments/5tidzc/a_solution_for_pulseaudio_pa_context_connect/

- 対策

pulseaudioデーモンプロセスを一般ユーザーではなく、rootユーザーで起動しておく必要がある
rootユーザーがソケットファイルを見つけることができないらしいから

ということで一般ユーザーがsudo経由で

```
$sudo pulseaudio -D
```

のように起動しておくといいらしい

- 予防

dockerホストとdockerコンテナ側で、以下のファイルを共有すれば、うまく行くんじゃないかと思っている

```
/run/user/$ID/pulse/native
```

