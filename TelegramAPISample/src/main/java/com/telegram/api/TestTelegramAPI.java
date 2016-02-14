package com.telegram.api;

import java.io.IOException;

import org.telegram.api.TLAbsUpdates;
import org.telegram.api.TLConfig;
import org.telegram.api.auth.TLSentCode;
import org.telegram.api.engine.ApiCallback;
import org.telegram.api.engine.AppInfo;
import org.telegram.api.engine.TelegramApi;
import org.telegram.api.requests.TLRequestAuthSendCode;
import org.telegram.api.requests.TLRequestHelpGetConfig;

public class TestTelegramAPI {
	public static void main(String[] args) throws IOException {
		
		MemoryApiState apistate = new MemoryApiState(true);
		TelegramApi api = new TelegramApi(apistate, new AppInfo(34086, "console", "1.0", "1.0", "en"), new ApiCallback() {
			
			@Override
			public void onUpdatesInvalidated(TelegramApi arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onUpdate(TLAbsUpdates arg0) {
				// TODO Auto-generated method stub
				System.out.println("Update");
			}
			
			@Override
			public void onAuthCancelled(TelegramApi arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
        TLConfig config = api.doRpcCallNonAuth(new TLRequestHelpGetConfig());
        apistate.updateSettings(config);
        TLSentCode sentCode;
        sentCode = api.doRpcCallNonAuth(new TLRequestAuthSendCode("+919818760941", 5, 34086, "5308ea5996c2cec5948b3c4b45382380", "en"));
        boolean registered = sentCode.getPhoneRegistered();
		
		System.out.println(registered);
		
		
	}
}
