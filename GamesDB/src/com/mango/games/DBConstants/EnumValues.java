package com.mango.games.DBConstants;

public class EnumValues 
{
	public static enum mCurrencyType 
	{
		Chips("chips") , Gold("gold") , Cash("cash");
		
		private String type;
		private mCurrencyType(String name) {
			type = name;
		}
		public String getType() {
			return type;
		}
		@Override
		public String toString()
		{
			return this.type;
		}
		
		
		public static mCurrencyType getEnum(String type) {
			if (type != null && type.equals(Chips.getType())) {
				return Chips;
			} else if (type != null && type.equals(Gold.getType())) {
				return Gold;
			} else if (type != null && type.equals(Cash.getType())) {
				return Cash;
			} else {
				throw new IllegalArgumentException();
			}
		}		
	}
	
	public static enum mTransactiontype
	{
		Credit("credit") , Debit("debit");
		private String type;
		private mTransactiontype(String typ)
		{
			this.type = typ;
		}
		public String getType()
		{
			return type;
		}
		@Override
		public String toString()
		{
			return this.type;
		}
		public static mTransactiontype getEnum(String type)
		{
			if (type != null && type.equals(Credit.getType())) {
				return Credit;
			} else if (type != null && type.equals(Debit.getType())) {
				return Debit;
			} 
			else {
				throw new IllegalArgumentException();
			}
		}
		
	}
}
