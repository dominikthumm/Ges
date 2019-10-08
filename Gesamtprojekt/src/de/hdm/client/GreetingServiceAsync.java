package de.hdm.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.shared.bo.tupel;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback) throws IllegalArgumentException;
	void getAllData(AsyncCallback<ArrayList<tupel>> callback);
}
