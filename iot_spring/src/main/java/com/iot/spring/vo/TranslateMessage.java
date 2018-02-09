package com.iot.spring.vo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

public class TranslateMessage {
	@JsonIgnoreProperties(ignoreUnknown = true)
	public class Message{

		@JsonIgnoreProperties(ignoreUnknown = true)
		public class Result{
			private String translatedText;
		
			public String getTranslatedText() {
				return translatedText;
			}
		
			public void setTranslatedText(String translatedText) {
				this.translatedText = translatedText;
			}

			@Override
			public String toString() {
				return "Result [translatedText=" + translatedText + "]";
			}
			
		}
		private Result result;

		public Result getResult() {
			return result;
		}

		public void setResult(Result result) {
			this.result = result;
		}

		@Override
		public String toString() {
			return "Message [result=" + result + "]";
		}
	}

	private Message message;

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "TranslateMessage [message=" + message + "]";
	}
	
}
