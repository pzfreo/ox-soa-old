package freo.me.security;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

public class ClientCallback implements CallbackHandler {
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		for (int i = 0; i < callbacks.length; i++) {
			WSPasswordCallback pwcb = (WSPasswordCallback) callbacks[i];
			String id = pwcb.getIdentifier();
			switch (pwcb.getUsage()) {

			case WSPasswordCallback.DECRYPT:
			case WSPasswordCallback.SIGNATURE:

				if ("client".equals(id)) {
					pwcb.setPassword("clientpass");
				}
				break;
			}
		}
	}
}
