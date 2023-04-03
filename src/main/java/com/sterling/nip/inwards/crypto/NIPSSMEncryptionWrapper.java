package com.sterling.nip.inwards.crypto;

import nfp.ssm.core.SSMLib;
import org.apache.commons.lang3.StringEscapeUtils;
//import org.slf4j.logger;
//import org.slf4j.loggerFactory;



/**
 * 
 */
public class NIPSSMEncryptionWrapper {
	
	
	

	
    private static SSMLib ssmLib = getSsmLib();



    private static SSMLib getSsmLib() {
        SSMLib ssmLib = null;
        try {
            ssmLib = new SSMLib("/Users/olujimio/Documents/Test_public.key", "/Users/olujimio/Documents/new_private.key");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ssmLib;
    }


    public static String encrypt(String message) {
        try {
            //logger.info("Begin encryption");

            //message =  StringEscapeUtils.escapeHtml4(message);

            //logger.info("Encoding message complete {}", message);

            if (ssmLib != null)

            {
                return ssmLib.encryptMessage(message);
            } else {
                //logger.error("SSM LIB not initialized");
            }

        } catch (Exception e) {
            //logger.error("Problem encrypting message {} {}", message, e);
            return "";
        }
        return "";
    }

    public static String decrypt(String message) {

        //logger.info("Encrypted string -- {}", message);

        String decryptedMessage = "";

        try {

            if (ssmLib == null){
                throw  new Exception("SSM Lib is not initialized");
            }
                //decryptedMessage = ssmLib.decryptFile(message, "password2$"); //test
            decryptedMessage = ssmLib.decryptFile(message,"KBL@!23" ); //"iksaqqqklmbsADFhasdf78$#");
                

            //logger.info("Decryption complete. Msg {}", decryptedMessage);

            decryptedMessage = StringEscapeUtils.unescapeHtml4(decryptedMessage);

            //logger.info("Escaped message {}", decryptedMessage);

            //logger.info("Decrypted Message -- {}", decryptedMessage.replace("><", ">\n\t<"));


        } catch (Exception exp) {

           //logger.error("Problem in decrypting message {}", exp);

        }

        return decryptedMessage;


    }
    
    
    public static boolean generateNewNIPKeys(String name, String password)
    {
    	if(ssmLib == null)
    		return false;
    	
    	else {
			return ssmLib.generateKeyPair(name, password);
		}
    }
    
    
    public static void main(String [] args)
    {
    	//String encString = "848C0303FDFCCB9D4202B40103FD15E796FA377D9415AEA101EE0CABF443FD3D98918FBA0296A5F72D95CF373FC611029B5EBDA3BE612C9C474EFD6B78E23C69A691217145C6862466C68171CD3AFB7BEBD8F88E5C3F16D08B3F83B2E1FBDEF98AFCBB83D1A1AAC41EE56D38FAA41BB35DEA9753EC51EB66ECB7098A6EF1A21BA48222260862527EF3442C83A6B4C9C02407A7A992813001B6E3D4FC429AF0FE9A3FC5148230914E811534855FB19C61A7AC36505CF59A68C59CD6893F6C3C558B43A165780774EC9BF4E7BA32D64A42F29212CECD0BBC29475F5FBAB67D9C06FDA03304AFD273F0C767B7D99CB3CFD0FA4D481C9778F50B9C203DFB337330B8D92649EF952A699C59502A641DEEEF24F85DF60EF4389BF8649F96550F1E23872BC394F8B50CF098A2D968F82BB0F10C7F6F448327946A55A5812301591BFEF9759F9CA7EC0B0B65E67094F4D358533246F0872DDE72FE5B8ECE82A9F60CAE4630030FD361A1CE601EB104ABCD306334C4719106DC;";
    	getSsmLib();
    	boolean KEY_GEN=  ssmLib.generateKeyPair("KEYSTONE", "KBL@!23");
    	//System.err.println("Key generate: " + KEY_GEN);
     // System.out.println("Decrypted: " + decrypt(encString));
    	//System.out.println(encrypt("<?xml version=\"1.0\" encoding=\"UTF-8\" ?><NESingleRequest><SessionID>999082200309105825341327966622</SessionID><DestinationInstitutionCode>999070</DestinationInstitutionCode><ChannelCode>2</ChannelCode><AccountNumber>5050104057</AccountNumber></NESingleRequest>"));
	    	
    }
}