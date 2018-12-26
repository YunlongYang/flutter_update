# flutter_update_example

You have to download the newest app to your device,
then call me to install it by using the file path.

## About Android FileProvider
- For safe,Android use FileProvider to share files between diffenrent apps.
- You can change the default FileProvider authorities by this way.
- There are two places that you should replace. Just find all "your.auth",and replace to yours.
```
<manifest xmlns:android="http://schemas.android.com/apk/res/android" package="com.github.yyl.update.flutterupdateexample" 
    xmlns:tools="http://schemas.android.com/tools">
     <meta-data android:name="FILE_PROVIDER_AUTHORITIES" tools:replace="android:value" android:value="your.auth"/>

        <provider android:name="android.support.v4.content.FileProvider" tools:replace="android:authorities" android:authorities="your.auth" android:exported="false" android:grantUriPermissions="true">
            <meta-data android:name="android.support.FILE_PROVIDER_PATHS" android:resource="@xml/file_paths" />
        </provider>

    </application>
</manifest>
```

### Tips
You must add this attr "xmlns:tools" to node manifest.
```
<manifest xmlns:tools="http://schemas.android.com/tools">
```


## Getting Started

```dart
import 'package:flutter/material.dart';
import 'package:flutter_update/flutter_update.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {

  @override
  void initState() {
    super.initState();
  }


  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('flutter_update example'),
        ),
        body: Column(
            children: <Widget>[
              Center(
                child:Text('Move one apk file to /sdcard/Android/tmp/app.apk\nThen click Install'),
              ),
              FlatButton.icon(
                icon: Icon(Icons.open_in_new),
                label: Text("Install"),
                onPressed: (){
                  FlutterUpdate.install("http://itunes.apple.com/lookup?id=yourid","/sdcard/Android/tmp/app.apk");
                },
              )
            ],
          )
        ),
    );
  }
}

```
