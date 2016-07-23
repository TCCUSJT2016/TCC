package com.projeto.think.xls.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.projeto.think.Model.Alternativa;
import com.projeto.think.Model.Pergunta;
import com.projeto.think.xls.IExcel;

public class AlternativaExcel implements IExcel {

	Map<String, Object> resultado = null;

	List<Alternativa> alternativas = null;

	public Map<String, Object> lerArquivoExcel(String diretorio) {

		Alternativa a = null;

		Pergunta p = null;

		try {
			resultado = new HashMap<String, Object>();
			alternativas = new ArrayList<Alternativa>();
			
			FileInputStream file = new FileInputStream(diretorio);
			XSSFWorkbook wb = new XSSFWorkbook(file);

			XSSFSheet sheet = wb.getSheetAt(1);
			XSSFRow row = null;
			XSSFCell cell = null;
			
			Iterator<?> rows = sheet.rowIterator();

			while (rows.hasNext()) {
				a = new Alternativa();
				
				row = (XSSFRow) rows.next();
				Iterator<Cell> cells = row.cellIterator();

				while (cells.hasNext()) {
					
					cell = (XSSFCell) cells.next();
					
					switch (cell.getColumnIndex()) {
					// coluna descricao
					case 0:
						a.setDescricao(cell.getStringCellValue());
						break;

					// coluna correta
					case 1:
						boolean b;
						int i = (int) cell.getNumericCellValue();
						if (i == 0) { b = false; } else { b = true; }
						a.setCorreta(b);
						break;

					// coluna id pergunta
					case 2:
						p = new Pergunta((int) cell.getNumericCellValue());
						a.setPergunta(p);
						break;
					}
				}
				alternativas.add(a);
				
			}
			wb.close();
			file.close();

			resultado.put("lista", alternativas);
			resultado.put("statusOperacao", "true");
			
		} catch (IOException e) {
			e.printStackTrace();
			resultado.put("statusOperacao", "false");

		}

		return resultado;
	}

}
