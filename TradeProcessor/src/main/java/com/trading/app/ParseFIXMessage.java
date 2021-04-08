package com.trading.app;
import quickfix.FieldNotFound;
import quickfix.InvalidMessage;
import quickfix.Message;
import quickfix.MessageParseError;
import quickfix.MessageUtils;
 
public class ParseFIXMessage {
	
	
public static void main(String[] args) throws MessageParseError, InvalidMessage, FieldNotFound {
		
		Message message = new Message("8=FIX.4.29=020535=D49=DEAN356=MSRX334=466252=20160621-12:31:08128=MSCO10016=DEAN55=AIZ54=238=1340=159=047=I18=563=021=160=20160621-12:31:07100=N11=SOS045920160621083107682S/AIZ9321=EQ2016062108310768210=046");
		
		String fixMessage = message.toString();
		
		System.out.println("Origional FIX message:-->"+fixMessage+"\n");
		System.out.println(MessageUtils.getStringField(fixMessage, 8));
		System.out.println(MessageUtils.getStringField(fixMessage, 9));
		System.out.println(MessageUtils.getStringField(fixMessage, 35));
		System.out.println(MessageUtils.getStringField(fixMessage, 49));
		System.out.println(MessageUtils.getStringField(fixMessage, 56));
		System.out.println(MessageUtils.getStringField(fixMessage, 34));
		System.out.println(MessageUtils.getStringField(fixMessage, 52));
		System.out.println(MessageUtils.getStringField(fixMessage, 128));
		System.out.println(MessageUtils.getStringField(fixMessage, 10016));
		System.out.println(MessageUtils.getStringField(fixMessage, 55));
		System.out.println(MessageUtils.getStringField(fixMessage, 54));
		System.out.println(MessageUtils.getStringField(fixMessage, 38));
		System.out.println(MessageUtils.getStringField(fixMessage, 40));		
		System.out.println(MessageUtils.getStringField(fixMessage, 59));
		System.out.println(MessageUtils.getStringField(fixMessage, 47));
		System.out.println(MessageUtils.getStringField(fixMessage, 18));
		System.out.println(MessageUtils.getStringField(fixMessage, 63));
		System.out.println(MessageUtils.getStringField(fixMessage, 21));
		System.out.println(MessageUtils.getStringField(fixMessage, 60));
		System.out.println(MessageUtils.getStringField(fixMessage, 100));
		System.out.println(MessageUtils.getStringField(fixMessage, 11));
		System.out.println(MessageUtils.getStringField(fixMessage, 9321));
		System.out.println(MessageUtils.getStringField(fixMessage, 10));
 
	}
 
 
}