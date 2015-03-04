package com.htc.ToolTest;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import junit.framework.Assert;
import junit.framework.AssertionFailedError;

import com.bitbar.recorder.extensions.ExtSolo;

public class RobotiumMethod extends Activity {
	private boolean cmdSuccess = true;

	public boolean enterText(ExtSolo solo, String ID, String methodName,
			String value) throws AssertionFailedError {
		try {

			solo.enterText((EditText) solo.findViewById(ID), value);

			return true;
		} catch (AssertionFailedError e) {
			Assert.assertNull(null);
			return false;
		}
	}

	// public boolean clickOnRadioButton(ExtSolo solo, String ID,
	// String methodName, String value) throws AssertionFailedError {
	// try {
	// if (!value.isEmpty()) {
	// cmdSuccess = solo.waitForRadioButtonById(ID, 100);
	// if (cmdSuccess)
	// solo.clickOnRadioButton((RadioButton) solo.findViewById(ID));
	// }
	// return cmdSuccess;
	// } catch (AssertionFailedError e) {
	// Assert.assertNull(null);
	// return false;
	// }
	// }
	public boolean clickOnRadioButton(ExtSolo solo, String ID,
			String methodName, String value) throws AssertionFailedError {
		try {
			if (!value.isEmpty()) {
				cmdSuccess = solo.waitForRadioButtonById(ID, 100);
				if (cmdSuccess)
					solo.clickOnRadioButton((RadioButton) solo.findViewById(ID));
			}
			return cmdSuccess;
		} catch (AssertionFailedError e) {
			Assert.assertNull(null);
			return false;
		}
	}

	public boolean clickLongOnRadioButton(ExtSolo solo, String ID,
			String methodName, String value) throws AssertionFailedError {
		try {
			if (!value.isEmpty()) {
				cmdSuccess = solo.waitForRadioButtonById(ID, 100);
				if (cmdSuccess)
					solo.clickLongOnRadioButton((RadioButton) solo
							.findViewById(ID));
			}
			return cmdSuccess;
		} catch (AssertionFailedError e) {
			Assert.assertNull(null);
			return false;
		}
	}

	public boolean clickOnButton(ExtSolo solo, String ID, String methodName,
			String value) throws AssertionFailedError {
		try {
			if (!ID.isEmpty()) {
				solo.clickOnButton((Button) solo.findViewById(ID));
			} else if (!value.isEmpty()) {
				solo.clickOnButton(value);
			}
			return true;
		} catch (AssertionFailedError e) {
			Assert.assertNull(null);
			return false;
		}

	}

	public boolean clickLongOnButton(ExtSolo solo, String ID,
			String methodName, String value) throws AssertionFailedError {
		try {
			if (!ID.isEmpty()) {
				solo.clickLongOnButton((Button) solo.findViewById(ID));
			} else if (!value.isEmpty()) {
				solo.clickLongOnButton(value);
			}
			return true;
		} catch (AssertionFailedError e) {
			Assert.assertNull(null);
			return false;
		}

	}

	public boolean setDatePicker(ExtSolo solo, String ID, String methodName,
			String value) {
		try {
			if (!value.isEmpty()) {
				int Year = Integer.parseInt(value.substring(0, 4));
				int Month = Integer.parseInt(value.substring(4, 6));
				int Day = Integer.parseInt(value.substring(6, 8));
				solo.setDatePicker(0, Year, Month, Day);
			}
			return true;
		} catch (AssertionFailedError e) {
			Assert.assertNull(null);
			return false;
		}
	}

	public boolean setTimePicker(ExtSolo solo, String ID, String methodName,
			String value) {
		try {
			if (!value.isEmpty()) {
				int Hours = Integer.parseInt(value.substring(0, 4));
				int Minutes = Integer.parseInt(value.substring(4, 6));
				solo.setTimePicker(0, Hours, Minutes);
			}
			return true;
		} catch (AssertionFailedError e) {
			Assert.assertNull(null);
			return false;
		}
	}

	 public boolean clickOnImageView(ExtSolo solo, String ID, String
	 methodName,String value) {
	 try {
	
	 cmdSuccess = solo.waitForViewById(ID, 100);
	 if (cmdSuccess)
	 solo.clickOnView((ImageView) solo.findViewById(ID));
	 return cmdSuccess;
	 } catch (AssertionFailedError e) {
	 Assert.assertNull(null);
	 return false;
	 }
	
	 }

//	public boolean clickOnImageView(ExtSolo solo, String ID, String methodName,
//			String value) {
//		try {
//			View actionbarItem1 = solo.getView(ID);
//			solo.clickOnView(actionbarItem1);
//			return true;
//		} catch (AssertionFailedError e) {
//			Assert.assertNull(null);
//			return false;
//		}
//	}

	public boolean clickOnView(ExtSolo solo, String ID, String methodName,
			String value) {
		try {
			cmdSuccess = solo.waitForViewById(ID, 100);
			if (cmdSuccess)
				solo.clickOnView((View) solo.findViewById(ID));
			return cmdSuccess;
		} catch (AssertionFailedError e) {
			Assert.assertNull(null);
			return false;
		}

	}

//	public boolean clickLongOnView(ExtSolo solo, String ID, String methodName,
//			String value) {
//		try {
//			cmdSuccess = solo.waitForViewById(ID, 100);
//			if (cmdSuccess)
//				solo.clickLongOnView((View) solo.findViewById(ID));
//			return cmdSuccess;
//		} catch (AssertionFailedError e) {
//			Assert.assertNull(null);
//			return false;
//		}
//	}

	
	public boolean clickLongOnView(ExtSolo solo, int ID, String methodName,
			String value) {
		solo.clickOnView(((LinearLayout)solo.getView("value")).getChildAt(ID));
		return true;
	}
	
	
	public boolean clickOnCheckBox(ExtSolo solo, String ID, String methodName,
			String value) {
		try {
			cmdSuccess = solo.waitForCheckBoxById(ID, 100);
			if (cmdSuccess)
				if (value.equalsIgnoreCase("Y")) {
					if (!solo.isCheckBoxChecked(0))
						solo.clickOnCheckBox((CheckBox) solo.findViewById(ID));
				} else {
					if (solo.isCheckBoxChecked(0))
						solo.clickOnCheckBox((CheckBox) solo.findViewById(ID));
				}
			return cmdSuccess;
		} catch (AssertionFailedError e) {
			Assert.assertNull(null);
			return false;
		}
	}

	public boolean clickLongOnCheckBox(ExtSolo solo, String ID,
			String methodName, String value) {
		try {
			cmdSuccess = solo.waitForCheckBoxById(ID, 100);
			if (cmdSuccess)
				if (value.equalsIgnoreCase("Y"))
					solo.clickLongOnCheckBox((CheckBox) solo.findViewById(ID));
			return cmdSuccess;
		} catch (AssertionFailedError e) {
			Assert.assertNull(null);
			return false;
		}
	}

	public boolean clickOnText(ExtSolo solo, String ID, String methodName,
			String value) {
		try {
			cmdSuccess = solo.searchText(value);
			if (cmdSuccess) {
				solo.clickOnText(value);

			}
			return cmdSuccess;
		} catch (AssertionFailedError e) {
			Assert.assertNull(null);
			return false;
		}

	}

	public boolean clickLongOnText(ExtSolo solo, String ID, String methodName,
			String value) {
		try {
			cmdSuccess = solo.searchText(value);
			if (cmdSuccess) {
				solo.clickLongOnText(value);

			}
			return cmdSuccess;
		} catch (AssertionFailedError e) {
			Assert.assertNull(null);
			return false;
		}
	}

	public boolean clickOnToggleButton(ExtSolo solo, String ID,
			String methodName, String value) {
		try {
			cmdSuccess = solo.searchText(value);
			if (cmdSuccess) {
				solo.clickOnToggleButton(value);

			}
			return cmdSuccess;
		} catch (AssertionFailedError e) {
			Assert.assertNull(null);
			return false;
		}
	}

	// public boolean clickOnToggleButton(ExtSolo solo, String ID,
	// String methodName, String value) throws AssertionFailedError {
	// try {
	// if (!value.isEmpty()) {
	// cmdSuccess = solo.waitForRadioButtonById(ID, 100);
	// if (cmdSuccess)
	// solo.clickOnRadioButton((RadioButton) solo.findViewById(ID));
	// }
	// return cmdSuccess;
	// } catch (AssertionFailedError e) {
	// Assert.assertNull(null);
	// return false;
	// }
	// }
	public boolean clickLongOnSpinner(ExtSolo solo, String ID,
			String methodName, String value) {
		try {
			cmdSuccess = solo.waitForViewById(ID, 100);
			if (cmdSuccess)
				solo.clickOnView((View) solo.findViewById(ID));
			return cmdSuccess;
		} catch (AssertionFailedError e) {
			Assert.assertNull(null);
			return false;
		}
	}

	public boolean clickOnImageButton(ExtSolo solo, String ID,
			String methodName, String value) {
		try {
			if (!ID.isEmpty()) {
				solo.clickOnImageButton((ImageButton) solo.findViewById(ID));
			} else if (!value.isEmpty()) {
				solo.clickOnButton(value);
			}
			return true;
		} catch (AssertionFailedError e) {
			Assert.assertNull(null);
			return false;
		}
	}

	public boolean goBack(ExtSolo solo, String ID, String methodName,
			String value) {
		try {
			if (!ID.isEmpty()) {
				solo.goBack();
			} else if (!value.isEmpty()) {
				solo.goBack();
			}
			return true;
		} catch (AssertionFailedError e) {
			Assert.assertNull(null);
			return false;
		}
	}

}
