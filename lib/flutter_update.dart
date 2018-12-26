import 'dart:async';

import 'package:flutter/services.dart';

class FlutterUpdate {
  static const MethodChannel _channel =
      const MethodChannel('flutter_update');
      
  static Future install(String filePath)async{
    await _channel.invokeMethod('install',filePath);
  }
}
