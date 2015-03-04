package com.htc.ToolTest;

import android.os.Bundle;
import android.test.InstrumentationTestRunner;

public  class MyTestRunner extends InstrumentationTestRunner {

    private static final String TAG = null;
    private static String mArgument;

    /* (non-Javadoc)
     * @see android.test.InstrumentationTestRunner#onCreate(android.os.Bundle)
     */
    @Override
    public  void onCreate(Bundle arguments) {
        super.onCreate(arguments);

        if (arguments != null) {
            mArgument = arguments.getString("myarg");
        }
    }

    public String getArgument() {
        return mArgument;
    }
    
   


}