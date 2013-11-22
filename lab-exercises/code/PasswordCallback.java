package me.freo.security;

import java.io.IOException;

import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

public class PasswordCallback implements CallbackHandler {

	@Override
	public void handle(javax.security.auth.callback.Callback[] cbs)
			throws IOException, UnsupportedCallbackException {
		
		for (int i = 0; i < cbs.length; i++) {
			WSPasswordCallback pwcb = (WSPasswordCallback) cbs[i];
			String id = pwcb.getIdentifier();
			
			switch (pwcb.getUsage()) {
			case WSPasswordCallback.USERNAME_TOKEN:

				if ("paul".equals(id)) {
					pwcb.setPassword("paul");
				}
				break;
			}
		}
	}
}
