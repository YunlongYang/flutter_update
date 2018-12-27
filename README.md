# flutter_update
To update your app to newest version.
Only Support Android Device for now.

## Getting Started
You have to download the newest app to your device,
then call FlutterUpdate to install it by using the file path.
You can use it like this.
```dart
import 'package:flutter_update/flutter_update.dart';
void main(){
    FlutterUpdate.install(YourAppHomeUrl,YourLocalApkFilePath);
}
```
## Future Work
Maybe I will add function download to this lib,for more easiler use.
For now, I want the coder download by self,for coder to make some custom tip or festures.

## Partner  Wanted
I am good at Android,but know less about ios. If you want make it support IOS devices,
Just email to me, or take an issue.
[New Issue](https://github.com/YunlongYang/flutter_update/issues/new)