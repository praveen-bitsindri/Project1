package resourcesAndUtils;

import org.apache.commons.codec.binary.Base64;

public class Utils_PasswordDecoder {
	
	public String passworddecoder(String password) {
		byte[] decode = Base64.decodeBase64(password);
		return new String(decode);
	}


}