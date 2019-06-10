package com.cg.jpacrud.exception;

public class StudentException extends Exception {
	
		String message;
		
		public StudentException(String message)
		{
			this.message = message;
		}
		@Override
		public String getMessage()
		{
			return this.message;
		}

	}



