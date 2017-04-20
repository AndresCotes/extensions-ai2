/**
 * @author AndresCotes (andres.daniel.cotes.p@gmail.com)
 */


package co.com.dendritas;



import android.util.Log;
import android.widget.Toast;
import android.widget.PopupMenu;
import android.view.Gravity;
import android.view.View;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import android.app.Activity;


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





@DesignerComponent(version = ToastU.VERSION,
    description = "añadir Toast a la Aplicacion",
    category = ComponentCategory.EXTENSION,
    nonVisible = true,
    iconName = "images/extension.png")

@SimpleObject(external = true)





public class ToastU extends AndroidNonvisibleComponent implements Component {
    public static final int VERSION = 1;
    private ComponentContainer container;
    private Context context;
    private static final String LOG_TAG = "ToastU";
	
	
		
	
	 public ToastU(ComponentContainer container) {
        super(container.$form());
        this.container = container;
        context = (Context) container.$context();
        Log.d(LOG_TAG, "Toast creado" );
    }
	
	   @SimpleFunction(description = "Return true if number is prime number")
		public void mensaje(String texto, int ejex,int ejey){
                    
					Toast toast1 =
            Toast.makeText(context,
                    texto, Toast.LENGTH_SHORT);
					
					toast1.setGravity(Gravity.TOP|Gravity.CENTER_VERTICAL, ejex, ejey);
					
					 toast1.show();
					
					
    
		}
	
							
	
}