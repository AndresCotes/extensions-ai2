/**
 * @author AndresCotes (andres.daniel.cotes.p@gmail.com)
 */


package co.com.dendritas;

import android.content.Context;
import android.util.Log;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.*;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.runtime.util.*;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.HtmlEntities;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.common.YaVersion;
import com.google.appinventor.components.runtime.collect.Lists;
import com.google.appinventor.components.runtime.collect.Maps;
import com.google.appinventor.components.runtime.util.AsynchUtil;
import com.google.appinventor.components.runtime.util.ErrorMessages;
import com.google.appinventor.components.runtime.util.FileUtil;
import com.google.appinventor.components.runtime.util.GingerbreadUtil;
import com.google.appinventor.components.runtime.util.JsonUtil;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.SdkLevel;
import com.google.appinventor.components.runtime.util.YailList;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import com.google.gson.Gson;

@DesignerComponent(version = JsonU.VERSION,
    description = "Json Utilidad",
    category = ComponentCategory.EXTENSION,
    nonVisible = true,
    iconName = "images/extension.png")

@SimpleObject(external = true)

@UsesPermissions(permissionNames = "android.permission.INTERNET," +
 		 "android.permission.WRITE_EXTERNAL_STORAGE," +
 		 "android.permission.READ_EXTERNAL_STORAGE"+
 		 "android.permission.WAKE_LOCK" +
		 "android.permission.ACCESS_NETWORK_STATE"+
		 "android.permission.READ_PHONE_STATE")
@UsesLibraries(libraries = "json.jar")


public class JsonU extends AndroidNonvisibleComponent implements Component {
    public static final int VERSION = 1;
    private ComponentContainer container;
    private Context context;
    private static final String LOG_TAG = "JsonU";
	
	
		
	 public JsonU(ComponentContainer container) {
        super(container.$form());
        this.container = container;
        context = (Context) container.$context();
        Log.d(LOG_TAG, "JsonU Creado" );
    }


    @SimpleFunction
  
  public Object JsonTextDecode(String jsonText) {
    try {
      return decodeJsonText(jsonText);
    } catch (IllegalArgumentException e) {
      form.dispatchErrorOccurredEvent(this, "JsonTextDecode",
          ErrorMessages.ERROR_WEB_JSON_TEXT_DECODE_FAILED, jsonText);
      return "";
    }
  }
  
  /**
   * Decodes the given JSON encoded value.
   *
   * @param jsonText the JSON text to decode
   * @return the decoded object
   * @throws IllegalArgumentException if the JSON text can't be decoded
   */
  // VisibleForTesting
  static Object decodeJsonText(String jsonText) throws IllegalArgumentException {
    try {
      return JsonUtil.getObjectFromJson(jsonText);
    } catch (JSONException e) {
      throw new IllegalArgumentException("jsonText is not a legal JSON value");
    }
  } 

@SimpleFunction
  
  public Object JsonTextencode(String jsonText) {
    try {
      return encodeJsonText(jsonText);
    } catch (IllegalArgumentException e) {
      form.dispatchErrorOccurredEvent(this, "JsonTextDecode",
          ErrorMessages.ERROR_WEB_JSON_TEXT_DECODE_FAILED, jsonText);
      return "";
    }
  }

  /**
   * Decodes the given JSON encoded value.
   *
   * @param jsonText the JSON text to decode
   * @return the decoded object
   * @throws IllegalArgumentException if the JSON text can't be decoded
   */
  // VisibleForTesting
  static Object encodeJsonText(String jsonText) throws IllegalArgumentException {
    try {
		
      JSONObject jsonObj = new JSONObject(jsonText);
      return jsonObj;
    } catch (JSONException e) {
      throw new IllegalArgumentException("jsonText is not a legal JSON value");
    }
  }

   @SimpleFunction
  
  public String CSVtoJSON(String output) {

    String[] lines = output.split("\n");

    StringBuilder builder = new StringBuilder();
    builder.append('[');
    String[] headers = new String[0];

    //CSV TO JSON
    for (int i = 0; i < lines.length; i++) {
        String[] values = lines[i].replaceAll("\"", "").split("۞");

        if (i == 0) //INDEX LIST
        {
            headers = values;
        } else {
            builder.append('{');
            for (int j = 0; j < values.length && j < headers.length; j++) {

                String jsonvalue = "\"" + headers[j] + "\":\"" + values[j] + "\"";
                if (j != values.length - 1) { //if not last value of values...
                    jsonvalue += ',';
                }
                builder.append(jsonvalue);
            }
            builder.append('}');
            if (i != lines.length - 1) {
                builder.append(',');
            }
        }
    }
    builder.append(']');
    output = builder.toString();

    return output;
	
}		

	
}