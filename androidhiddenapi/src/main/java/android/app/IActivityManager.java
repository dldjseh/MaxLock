package android.app;

import android.content.IIntentReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.IBinder;

import java.util.List;

import android_hidden.app.ActivityManager;

public interface IActivityManager {
    boolean finishActivity(IBinder token, int code, Intent data, int finishTask);

    Intent registerReceiver(IApplicationThread caller, String callerPackage,
                            IIntentReceiver receiver, IntentFilter filter,
                            String requiredPermission, int userId, int flags);

    List<ActivityManager.RunningTaskInfo> getTasks(int maxNum);

    void setFocusedTask(int taskId);

    boolean removeTask(int taskId);

    void registerProcessObserver(IProcessObserver observer);

    void unregisterProcessObserver(IProcessObserver observer);

    int startActivity(IApplicationThread caller, String callingPackage, Intent intent,
                      String resolvedType, IBinder resultTo, String resultWho, int requestCode,
                      int flags, ProfilerInfo profilerInfo, Bundle options);

    WaitResult startActivityAndWait(IApplicationThread caller, String callingPackage, Intent intent,
                                    String resolvedType, IBinder resultTo, String resultWho, int requestCode,
                                    int flags, ProfilerInfo profilerInfo, Bundle options, int userId);

    ContentProviderHolder getContentProviderExternal(String name, int userId, IBinder token);

    ContentProviderHolder getContentProviderExternal(String name, int userId, IBinder token, String whatever);

    int getFocusedStackId();

    ActivityManager.StackInfo getStackInfo(int stackId);

    // Since Pie
    ActivityManager.StackInfo getFocusedStackInfo();
}