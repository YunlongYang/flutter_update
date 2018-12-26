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
          title: const Text('Plugin example app'),
        ),
        body: Column(
            children: <Widget>[
              Center(
                child:Text('Move one apk file to /sdcard/Android/tmp/app.apk'),
              ),
              FlatButton.icon(
                icon: Icon(Icons.open_in_new),
                label: Text("Install"),
                onPressed: (){
                  FlutterUpdate.install("/sdcard/Android/tmp/app.apk");
                },
              )
            ],
          )
        ),
    );
  }
}
