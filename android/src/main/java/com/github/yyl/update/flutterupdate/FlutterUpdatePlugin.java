package com.github.yyl.update.flutterupdate;

import android.app.Activity;
import android.content.Context;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import com.github.yyl.update.flutterupdate.impl.AppInstaller;

/** FlutterUpdatePlugin */
public class FlutterUpdatePlugin implements MethodCallHandler {
  private Registrar registrar;

  public FlutterUpdatePlugin(Registrar registrar) {
    this.registrar = registrar;
  }

  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutter_update");
    channel.setMethodCallHandler(new FlutterUpdatePlugin(registrar));
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("install")) {
      try {
        String path = call.argument("filePath");
        AppInstaller installer = new AppInstaller(path, getContext());
        installer.install();
        result.success(null);
      } catch (Exception e) {
        e.printStackTrace();
        result.error("1", e.getMessage(), null);
      }
    } else {
      result.notImplemented();
    }
  }

  private Context getContext() {
    Activity activity = registrar.activity();
    if (activity != null) {
      return activity;
    } else {
      return registrar.context();
    }
  }
}
