package com.projeto.think.xls.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Time;
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

import com.projeto.think.Model.Area;
import com.projeto.think.Model.Categoria;
import com.projeto.think.Model.NivelPergunta;
import com.projeto.think.Model.Pergunta;
import com.projeto.think.Model.Subcategoria;
import com.projeto.think.xls.IExcel;

public class PerguntaExcel implements IExcel {

	Map<String, Object> resultado = null;

	List<Pergunta> perguntas = null;

	public Map<String, Object> lerArquivoExcel(String diretorio) {

		Pergunta p = null;

		NivelPergunta np = null;
		Area ar = null;
		Categoria c = null;
		Subcategoria sc = null;

		try {
			resultado = new HashMap<String, Object>();
			perguntas = new ArrayList<Pergunta>();
			
			FileInputStream file = new FileInputStream(diretorio);
			XSSFWorkbook wb = new XSSFWorkbook(file);

			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFRow row = null;
			XSSFCell cell = null;
			
			Iterator<?> rows = sheet.rowIterator();

			while (rows.hasNext()) {
				p = new Pergunta();
				
				row = (XSSFRow) rows.next();
				Iterator<Cell> cells = row.cellIterator();

				while (cells.hasNext()) {
					
					cell = (XSSFCell) cells.next();
					
					switch (cell.getColumnIndex()) {
					// coluna descricao
					case 0:
						p.setDescricao(cell.getStringCellValue());
						break;

					// coluna pontuacao
					case 1:
						p.setPontuacao((int) cell.getNumericCellValue());
						break;

					// coluna tempo resposta
					case 2:
						p.setTempoResposta(new Time((long) cell.getNumericCellValue()));
						break;

					// coluna id nivel pergunta
					case 3:
						np = new NivelPergunta();
						np.setId((int) cell.getNumericCellValue());

						p.setNivelPergunta(np);
						break;

					// coluna id area
					case 4:
						ar = new Area();
						ar.setId((int) cell.getNumericCellValue());

						p.setArea(ar);
						break;

					// coluna id categoria
					case 5:
						c = new Categoria();
						c.setId((int) cell.getNumericCellValue());

						p.setCategoria(c);
						break;

					// coluna id subcategoria
					case 6:
						sc = new Subcategoria();
						sc.setId((int) cell.getNumericCellValue());

						p.setSubcategoria(sc);
						break;
					}
				}
				perguntas.add(p);
				
			}
			wb.close();
			file.close();

			resultado.put("lista", perguntas);
			resultado.put("statusOperacao", "true");
			
		} catch (IOException e) {
			e.printStackTrace();
			resultado.put("statusOperacao", "false");

		}

		return resultado;
	}

}
