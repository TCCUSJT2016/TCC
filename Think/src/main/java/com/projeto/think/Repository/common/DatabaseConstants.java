package com.projeto.think.Repository.common;


/**
 * 
 * @author Mauricio Souza Couto
 * Est� classe abstrata tem por objetivo gerar as queries que ser�o utilizadas na persist�ncia com o banco de dados.
 * Est� classe deve ser herdada por todos os DAOs.
 */
public abstract class DatabaseConstants {
	
	protected static final String INSERT_INTO 		= "INSERT INTO";
	protected static final String SELECT	 		= "SELECT";
	protected static final String SELECT_ALL 		= "SELECT * FROM";
	protected static final String DELETE	 		= "DELETE";
	protected static final String UPDATE	 		= "UPDATE";
	
	protected static final String OPEN_PARENTHESIS  = "(";
	protected static final String CLOSE_PARENTHESIS = ")";
	protected static final String COLUMNS_SEPARATOR = ", ";
	protected static final String SPACE				= " ";
	protected static final String QUERY_END			= ";";
	protected static final String PARAMETER_SIGN	= "?";
	protected static final String EQUALS_SIGN		= "=";
	
	protected static final String FROM		 		= "FROM";
	protected static final String WHERE		 		= "WHERE";
	protected static final String VALUES	 		= "VALUES";
	protected static final String ORDER_BY	 		= "ORDER BY";
	protected static final String ASC		 		= "ASC";
	protected static final String DESC		 		= "DESC";
	protected static final String SET		 		= "SET";
	
	
	public String getSelectOne(String table_name, String fieldToSelect, String filterColumn)
	{
		return SELECT + SPACE + fieldToSelect + SPACE + FROM + SPACE + table_name +
			   SPACE + WHERE  + SPACE + filterColumn + SPACE + EQUALS_SIGN + PARAMETER_SIGN;
	}
	
	public String getSelectOne(String table_name, String[] fields, String filterColumn)
	{
		String fieldsQuery = "";
		
		for(int i = 0; i < fields.length; i++)
		{
			fieldsQuery  += fields[i];
			
			if(i != fields.length - 1)
			{
				fieldsQuery  += COLUMNS_SEPARATOR + SPACE;
			}
		}
		
		return SELECT + SPACE + fieldsQuery + SPACE + FROM + SPACE + table_name +
			   SPACE + WHERE  + SPACE + filterColumn + SPACE + EQUALS_SIGN + PARAMETER_SIGN;
	}
	
	public String getSelectAllQuery(String table_name)
	{
		return SELECT_ALL + SPACE + table_name;
	}
	
	public String getSelectAllQuery(String table_name, String ordenacao)
	{
		return SELECT_ALL + SPACE + table_name + SPACE + ORDER_BY + SPACE + ordenacao;
	}
	
	public String getSelectAllQuery(String table_name, String ordenacao, String ascDesc)
	{
		return SELECT_ALL + SPACE + table_name + SPACE + ORDER_BY + SPACE + ordenacao + SPACE + (ascDesc.equals(ASC) ? ASC : DESC);
	}
	
//	public String getSelectQuery(String table_name, String[] fields)
//	{
//		String fieldsQuery = "";
//		
//		for(int i = 0; i < fields.length; i++)
//		{
//			fieldsQuery += fields[i];
//			
//			if(i != fields.length - 1)
//			{
//				fieldsQuery += COLUMNS_SEPARATOR;
//			}
//		}
//		
//		return SELECT + SPACE + fieldsQuery + SPACE + FROM + table_name;
//	}
	
	public String getInsertQuery(String table_name, String[] fields )
	{
		String fieldsQuery = "";
		String fieldsValues = "";
		
		for(int i = 0; i < fields.length; i++)
		{
			fieldsQuery  += fields[i];
			fieldsValues += PARAMETER_SIGN; 
			
			
			if(i != fields.length - 1)
			{
				fieldsQuery  += COLUMNS_SEPARATOR + SPACE;
				fieldsValues += COLUMNS_SEPARATOR + SPACE;
			}
		}
		
		return INSERT_INTO + SPACE + table_name + SPACE +
			   OPEN_PARENTHESIS  + SPACE +
			   		fieldsQuery  +
			   CLOSE_PARENTHESIS +
			   VALUES +
			   OPEN_PARENTHESIS +
			   		fieldsValues +
			   CLOSE_PARENTHESIS;
	}
	
	public String getDeleteQuery(String table_name, String filterColumn) {
		return DELETE + SPACE + FROM + SPACE + table_name + SPACE + 
			   WHERE + SPACE + filterColumn + SPACE + EQUALS_SIGN + SPACE + PARAMETER_SIGN;
	}
	
	public String getUpdateQuery(String table_name, String[] fields, String filterColumn) {
		
		String fieldsQuery = "";
		
		for(int i = 0; i < fields.length; i++)
		{
			fieldsQuery  += fields[i]; 
			
			if(i != fields.length - 1)
			{
				fieldsQuery  += SPACE + EQUALS_SIGN + SPACE + PARAMETER_SIGN + COLUMNS_SEPARATOR;
			}
			else {
				fieldsQuery  += SPACE + EQUALS_SIGN + SPACE + PARAMETER_SIGN;
			}
		}
		
		return UPDATE + SPACE + table_name + SPACE + 
			   SET + SPACE + fieldsQuery + SPACE + 
			   WHERE + SPACE + filterColumn + SPACE + EQUALS_SIGN + SPACE + PARAMETER_SIGN;
	}
}
