package com.example.next.saxparsing;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by next on 9/3/17.
 */
public class SAXController {
ISAXData isaxData;
    public SAXController(ISAXData isaxData) {
        this.isaxData = isaxData;
    }

    public void calTask(){
        new SAXTask(isaxData).execute();
    }

    private class  SAXTask extends AsyncTask<Void, Void, Void> {
        XMLHelper xmlHelper;
        ISAXData isaxData;
        public SAXTask(ISAXData isaxData) {
            this.isaxData = isaxData;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            StringBuffer stringBuffer = new StringBuffer();
            for (DataModel dataModel:xmlHelper.modelArrayList){
                stringBuffer.append("Title:  "+dataModel.getTitle()+"\n");
                stringBuffer.append("Desc:  "+dataModel.getDesc()+"\n");
                stringBuffer.append("Link:  "+dataModel.getLink()+"\n");
                stringBuffer.append("Date:  "+dataModel.getDate()+"\n"+"\n");
            }
            isaxData.getData(stringBuffer.toString());
        }

        @Override
        protected Void doInBackground(Void... params) {
            xmlHelper = new XMLHelper();
            xmlHelper.get();

            return null;
        }
    }
}
