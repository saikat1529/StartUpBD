package com.bit_makers.saikat.stratupbd;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONObject;

/**
 * Created by SAIKAT on 2/24/2016.
 */
public class JSONExecuter extends AsyncTask<String,String,JSONObject[]> {

    private ProgressDialog pDialog;
    Context context;
    JSONObject jsonObject;
    JSONParser jsonParser;

    public AsyncResponse delegate = null;

    public JSONExecuter (Context ctx){
        context = ctx;
        jsonParser = new JSONParser();
    }


    /**
     * Before starting background thread Show Progress Dialog
     * */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(context);
        pDialog.show();
        pDialog.setMessage("Please be patient, we are fetching data for you");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
    }

    @Override
    protected JSONObject[] doInBackground(String... strings) {
        int count = strings.length;
        JSONObject[] jsonObjects = new JSONObject[count];
        for(int i=0; i<count; i++) {
            jsonObjects[i] = jsonParser.makeHttpRequest(strings[i], "GET", null);
        }
        return jsonObjects;
    }


    @Override
    protected void onPostExecute(JSONObject[] s) {
        delegate.processFinish(s);
        pDialog.dismiss();
    }
}
