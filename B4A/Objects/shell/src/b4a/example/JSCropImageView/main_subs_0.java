package b4a.example.JSCropImageView;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,29);
if (RapidSub.canDelegate("activity_create")) return main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 29;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 31;BA.debugLine="Activity.LoadLayout(\"1\")";
Debug.ShouldStop(1073741824);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("1")),main.mostCurrent.activityBA);
 BA.debugLineNum = 32;BA.debugLine="JSCropImageView1.ImageBitmap = LoadBitmap(File.Di";
Debug.ShouldStop(-2147483648);
main.mostCurrent._jscropimageview1.runVoidMethod ("setImageBitmap",(main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("1.jpg"))).getObject()));
 BA.debugLineNum = 33;BA.debugLine="JSCropImageView1.ShowCropOverlay = True";
Debug.ShouldStop(1);
main.mostCurrent._jscropimageview1.runVoidMethod ("setShowCropOverlay",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 34;BA.debugLine="Activity.AddMenuItem3(\"Crop\", \"mnuCrop\", Null, Tr";
Debug.ShouldStop(2);
main.mostCurrent._activity.runVoidMethod ("AddMenuItem3",(Object)(RemoteObject.createImmutable(("Crop"))),(Object)(BA.ObjectToString("mnuCrop")),(Object)((main.mostCurrent.__c.getField(false,"Null"))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 35;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,41);
if (RapidSub.canDelegate("activity_pause")) return main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 41;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(256);
 BA.debugLineNum = 43;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,37);
if (RapidSub.canDelegate("activity_resume")) return main.remoteMe.runUserSub(false, "main","activity_resume");
 BA.debugLineNum = 37;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(16);
 BA.debugLineNum = 39;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 25;BA.debugLine="Private JSCropImageView1 As JSCropImageView";
main.mostCurrent._jscropimageview1 = RemoteObject.createNew ("com.salvadorjhai.widgets.JSCropImageView");
 //BA.debugLineNum = 26;BA.debugLine="Private ImageView1 As ImageView";
main.mostCurrent._imageview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _mnucrop_click() throws Exception{
try {
		Debug.PushSubsStack("mnuCrop_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,45);
if (RapidSub.canDelegate("mnucrop_click")) return main.remoteMe.runUserSub(false, "main","mnucrop_click");
 BA.debugLineNum = 45;BA.debugLine="Sub mnuCrop_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 46;BA.debugLine="ImageView1.Bitmap = JSCropImageView1.CroppedImage";
Debug.ShouldStop(8192);
main.mostCurrent._imageview1.runMethod(false,"setBitmap",main.mostCurrent._jscropimageview1.runMethod(false,"getCroppedImage"));
 BA.debugLineNum = 47;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.JSCropImageView.main");
starter.myClass = BA.getDeviceClass ("b4a.example.JSCropImageView.starter");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}